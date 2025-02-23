# Code

## jdk.internal.misc.Unsafe

This folder contains a few examples of unsafe usages of
jdk.internal.misc.Unsafe (Java 11 or higher).

### UnsafePutAddress

This POC will try to write a value provided in argument to address
zero in memory. This results in a access violation. The
expected output is something like this, which shows that a
segmentation fault (SIGSEGV) was achieved:

```text
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< org.leplus.unsafe:jdk-internal-misc-unsafe >------------------
[INFO] Building jdk-internal-misc-unsafe 1.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec:3.5.0:java (default-cli) @ jdk-internal-misc-unsafe ---
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x00000001021e7354, pid=3341, tid=0x0000000000006203
#
#  [...]
#
Abort trap: 6
```

You can run this example yourself using the following shell command on Mac/Linux:

```bash
MAVEN_OPTS='--add-opens java.base/jdk.internal.misc=ALL-UNNAMED' ./mvnw exec:java -Dexec.mainClass=org.leplus.unsafe.jdk.internal.misc.UnsafePutAddress -Dexec.args="42"
```

Or this one on Windows:

```batch
mvnw.cmd exec:java -Dexec.mainClass=org.leplus.unsafe.jdk.internal.misc.UnsafePutAddress -Dexec.args="42"
```

### UnsafePutChar

This POC will try to write the String provided in argument to an
allocated memory space of size zero, resulting in an overflow. The
expected output is something like this, which shows that a
segmentation fault (SIGSEGV) was achieved:

```text
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< org.leplus.unsafe:jdk-internal-misc-unsafe >------------------
[INFO] Building jdk-internal-misc-unsafe 1.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec:3.5.0:java (default-cli) @ jdk-internal-misc-unsafe ---
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x00000001021bc5bc, pid=70985, tid=39427
#
#  [...]
#
Abort trap: 6
```

You can run this example yourself using the following shell command on Mac/Linux:

```bash
MAVEN_OPTS='--add-opens java.base/jdk.internal.misc=ALL-UNNAMED' ./mvnw exec:java -Dexec.mainClass=org.leplus.unsafe.jdk.internal.misc.UnsafePutChar -Dexec.args="foo"
```

Or this one on Windows:

```batch
mvnw.cmd exec:java -Dexec.mainClass=org.leplus.unsafe.jdk.internal.misc.UnsafePutChar -Dexec.args="foo"
```

## Code scans

### Checkstyle

You can run it using `./mvnw checkstyle:check`.

No finding.

### CodeQL

No finding.

### PMD

You can run it using `./mvnw pmd:check`.

No finding.

### SpotBugs (including findsecbugs plugin)

You can run it using `./mvnw spotbugs:check`.

No finding.
