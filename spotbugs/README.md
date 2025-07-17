# SpotBugs plugin

This directory contains a
[SpotBugs](https://spotbugs.github.io/) plugin to
detect usages of `sun.misc.Unsafe` or `jdk.internal.misc.Unsafe`.

To build it, run the following command:
```bash
./mvnw verify
```

To use it, run the following command:

```bash
"${SPOTBUGS_HOME}/spotbugs2" -textui -include unsafe-bug-filter.xml target.jar
```
