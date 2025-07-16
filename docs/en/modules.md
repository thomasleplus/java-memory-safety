<!-- markdownlint-disable MD041 -->

### Some progress

- [JEP 260](https://openjdk.org/jeps/260) (Java 9): many of these
methods have been migrated into two separate classes:
`jdk.internal.misc.Unsafe` (in `java.base`) and `sun.misc.Unsafe`
(in `jdk.unsupported`). So developers added
`--add-opens java.base/jdk.internal.misc=ALL-UNNAMED`
and `--add-opens jdk.unsupported/sun.misc=ALL-UNNAMED`
to their application startup script and moved on to the next issue.
- Java 23: the methods in `sun.misc.Unsafe` are deprecated and
marked for removal. Not `jdk.internal.misc.Unsafe`.

Note: Funny to deprecate undocumented APIs. Speaks to how widely they
are used. And for that reason they can't be removed easily.
