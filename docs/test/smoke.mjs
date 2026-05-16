import { createReadStream, statSync } from 'node:fs';
import { createServer } from 'node:http';
import { extname, join, normalize } from 'node:path';
import { fileURLToPath } from 'node:url';
import { chromium } from 'playwright';

const docsDir = fileURLToPath(new URL('..', import.meta.url));

const mime = {
  '.html': 'text/html; charset=utf-8',
  '.js': 'text/javascript; charset=utf-8',
  '.mjs': 'text/javascript; charset=utf-8',
  '.css': 'text/css; charset=utf-8',
  '.md': 'text/markdown',
  '.svg': 'image/svg+xml',
  '.png': 'image/png',
  '.jpg': 'image/jpeg',
  '.jpeg': 'image/jpeg',
  '.gif': 'image/gif',
  '.json': 'application/json',
  '.woff': 'font/woff',
  '.woff2': 'font/woff2',
};

const server = createServer((req, res) => {
  let path = decodeURIComponent(req.url.split('?')[0]);
  if (path.endsWith('/')) path += 'index.html';
  const full = normalize(join(docsDir, path));
  if (!full.startsWith(docsDir)) {
    res.writeHead(403);
    res.end('forbidden');
    return;
  }
  try {
    if (statSync(full).isDirectory()) {
      res.writeHead(302, { Location: req.url + '/' });
      res.end();
      return;
    }
    res.writeHead(200, {
      'Content-Type': mime[extname(full)] || 'application/octet-stream',
    });
    createReadStream(full).pipe(res);
  } catch {
    res.writeHead(404);
    res.end('not found');
  }
});

await new Promise((resolve) => server.listen(0, '127.0.0.1', resolve));
const { port } = server.address();
const base = `http://127.0.0.1:${port}`;
console.log(`serving ${docsDir} at ${base}`);

const browser = await chromium.launch();
const ctx = await browser.newContext();
const page = await ctx.newPage();

const pages = ['/', '/bsides-london-2025/'];
let failed = false;

for (const path of pages) {
  const url = base + path;
  const errors = [];
  const failures = [];

  const onError = (e) => errors.push(`pageerror: ${e.message}`);
  const onConsole = (m) => {
    if (m.type() === 'error') errors.push(`console.error: ${m.text()}`);
  };
  // Only track failures for our own origin — third-party CDNs (Google Fonts,
  // etc.) are out of scope and frequently abort requests on fast page loads.
  const onFailed = (r) => {
    if (!r.url().startsWith(base)) return;
    failures.push(`requestfailed: ${r.failure()?.errorText ?? '?'} ${r.url()}`);
  };
  const onResponse = (r) => {
    if (!r.url().startsWith(base)) return;
    if (r.status() >= 400) failures.push(`HTTP ${r.status()} ${r.url()}`);
  };

  page.on('pageerror', onError);
  page.on('console', onConsole);
  page.on('requestfailed', onFailed);
  page.on('response', onResponse);

  try {
    await page.goto(url, { waitUntil: 'load', timeout: 15000 });
    await page.waitForFunction(
      () => typeof window.Reveal !== 'undefined' && window.Reveal.isReady && window.Reveal.isReady(),
      null,
      { timeout: 15000 }
    );
    // Wait for markdown plugin to fetch+render slide content.
    await page.waitForFunction(
      () =>
        document.querySelectorAll(
          '.reveal .slides section[data-markdown] h1, .reveal .slides section[data-markdown] h2, .reveal .slides section[data-markdown] p'
        ).length > 0,
      null,
      { timeout: 15000 }
    );

    const sectionCount = await page.locator('.reveal .slides > section').count();
    if (sectionCount === 0) errors.push('no <section> elements found');

    if (errors.length || failures.length) {
      failed = true;
      console.error(`FAIL ${path} (${sectionCount} top-level sections)`);
      for (const m of [...errors, ...failures]) console.error('  -', m);
    } else {
      console.log(`OK   ${path} (${sectionCount} top-level sections)`);
    }
  } catch (e) {
    failed = true;
    console.error(`FAIL ${path}: ${e.message}`);
    for (const m of [...errors, ...failures]) console.error('  -', m);
  } finally {
    page.off('pageerror', onError);
    page.off('console', onConsole);
    page.off('requestfailed', onFailed);
    page.off('response', onResponse);
  }
}

await browser.close();
server.close();
process.exit(failed ? 1 : 0);
