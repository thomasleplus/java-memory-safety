<!-- markdownlint-disable MD041 -->

### Catch the flag

- Compilation
  - `-Xlint:restricted` causes warnings if unsafe FFM methods (@Restricted) are called in source code.
- Runtime
  - `-Xcheck:jni` causes the JVM to do additional validation on the arguments passed to JNI functions.
  - `-verbose:jni` enables logging of JNI.

FIXME TODO performance impacts?

Note: FIXME
