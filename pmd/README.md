# PMD

This directory contains a
[PMD](https://pmd.github.io) ruleset to
detect usages of `sun.misc.Unsafe` or `jdk.internal.misc.Unsafe`.

To use it, run the following command:

```bash
pmd check -d src -R unsafe-ruleset.xml
```
