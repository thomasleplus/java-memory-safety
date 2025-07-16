<!-- markdownlint-disable MD041 -->

### Some progress

- [JEP 260](https://openjdk.org/jeps/260) (Java 9): many of these
methods have been migrated into two separate classes/modules:
  - `jdk.internal.misc.Unsafe` in `java.base`.
  - `sun.misc.Unsafe` in `jdk.unsupported`.
- Developers added `--add-opens` &#x1F622;
- Java 23: the methods in `sun.misc.Unsafe` are deprecated and
marked for removal. But not `jdk.internal.misc.Unsafe`.

Note: Funny to deprecate undocumented APIs. Speaks to how widely they
are used. And for that reason they can't be removed easily.
