# Checkstyle

This directory contains a
[Checkstyle](https://checkstyle.sourceforge.io) configuration file
(`unsafe_checks.xml`) to detect usages of `sun.misc.Unsafe` or
`jdk.internal.misc.Unsafe`.

To use it, run the following command:

```bash
java -jar checkstyle-x.y.z-all.jar -c unsafe_checks.xml target.jar
```

It configures the
[IllegalImport](https://checkstyle.sourceforge.io/checks/imports/illegalimport.html)
rule which by default only checks for imports from `sun.*` packages.
