# PMD

Out-of-the-box PMD has a rule called `DontImportSun` that will detect
uses of `sun.misc.Unsafe`. But nothing for `jdk.internal.misc.Unsafe`.

This directory contains a
[PMD](https://pmd.github.io) ruleset to
detect usages of `sun.misc.Unsafe` or `jdk.internal.misc.Unsafe`.

To use it, run the following command:

```bash
pmd check -d src -R unsafe-ruleset.xml
```
