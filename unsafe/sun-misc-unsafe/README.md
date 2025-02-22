# Code

## sun.misc.Unsafe

This folder contains a few examples of unsafe usages of sun.misc.Unsafe.

### UnsafePutAddress

This POC will try to write a value provided in argument to address
zero in memory. This results in a access violation. The
expected output is something like this, which shows that a
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
#  SIGSEGV (0xb) at pc=0x00000001021e7354, pid=3341, tid=0x0000000000006203
#
#  [...]
#
Abort trap: 6
```

You can run this example yourself using the following shell command on Mac:

```bash
./mvnw exec:java -Dexec.mainClass=org.leplus.unsafe.sun.misc.UnsafePutAddress -Dexec.args="42"
```

Or this one on Windows:

```batch
mvnw.cmd exec:java -Dexec.mainClass=org.leplus.unsafe.sun.misc.UnsafePutAddress -Dexec.args="42"
```

### UnsafePutChar

This POC will try to write the String provided in argument to an
allocated memory space of size zero, resulting in an overflow. The
expected output is something like this, which shows that a
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

You can run this example yourself using the following shell command on Mac:

```bash
./mvnw exec:java -Dexec.mainClass=org.leplus.unsafe.sun.misc.UnsafePutChar -Dexec.args="foo"
```

Or this one on Windows:

```batch
mvnw.cmd exec:java -Dexec.mainClass=org.leplus.unsafe.sun.misc.UnsafePutChar -Dexec.args="foo"
```

### jdk.internal.misc.Unsafe

Same examples as `sun.misc.Unsafe` but with class
`jdk.internal.misc.Unsafe` (Java 11 or above). To run these examples,
you need to open access to the package `jdk.internal.misc` in module
`java.base` (again this is NOT a good idea, do this only to illustrate
the risk). This can be accomplished using the JVM CLI option
`--add-opens java.base/jdk.internal.misc=ALL-UNNAMED`.

With maven, this can be done using the `MAVEN_OPTS` enveronment
variable, resulting in a command like this one for example:

```bash
MAVEN_OPTS='--add-opens java.base/jdk.internal.misc=ALL-UNNAMED' ./mvnw exec:java -Dexec.mainClass=org.leplus.unsafe.jdk.internal.misc.UnsafePutChar -Dexec.args="foo"
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
