# sun.misc.Unsafe

This folder contains examples of unsafe usages of sun.misc.Unsafe.

## Execution

You can simply run this code using the following shell command on Mac:

```bash
./mvnw exec:java -Dexec.mainClass=org.leplus.unsafe.sun.misc.unsafe.UnsafeMain -Dexec.args="foo"
```

Or this one on Windows:

```batch
mvnw.cmd exec:java -Dexec.mainClass=org.leplus.unsafe.sun.misc.unsafe.UnsafeMain -Dexec.args="foo"
```

This will try to write the String `foo` to an allocated memory space
of size zero. The expected output is something like this, which shows that a
segmentation fault (SIGSEGV) was achieved:

```text
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< org.leplus.unsafe:sun-misc-unsafe >------------------
[INFO] Building sun-misc-unsafe 1.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec:3.5.0:java (default-cli) @ sun-misc-unsafe ---
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x00000001021bc5bc, pid=70985, tid=39427
#
#  [...]
#
Abort trap: 6
```

## Code scans

### Checkstyle

You can run it using `./mvnw checkstyle:check`.

Checkstyle reports `Illegal import - sun.misc.Unsafe. [IllegalImport]`.

### CodeQL

Reports `Access to unsupported JDK-internal API`.

### PMD

You can run it using `./mvnw pmd:check`.

No finding.

### SpotBugs (including findsecbugs plugin)

You can run it using `./mvnw spotbugs:check`.

No finding.
