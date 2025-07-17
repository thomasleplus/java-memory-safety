# Checkstyle

This directory contains a
[Checkstyle](https://checkstyle.sourceforge.io) configuration to
detect usages of `sun.misc.Unsafe` or `jdk.internal.misc.Unsafe`.

To use it, run the following command:

```bash
java -jar checkstyle-x.y.z-all.jar -c unsafe_checks.xml target.jar
```
