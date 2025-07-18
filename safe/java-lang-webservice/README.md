# Code

The code in this project demonstrates a safer implementation of the
patterns . It uses the Foreign Function and Memory (FFM) API (out of
preview since Java 22). Executing this code results in a much cleaner
unchecked java.lang.IndexOutOfBoundsException insted of a segmentation
fault (SIGSEGV).

```text
[INFO] Scanning for projects...
[INFO]
[INFO] ---------< org.leplus.unsafe:java-lang-foreign-memorysegment >----------
[INFO] Building java-lang-foreign-memorysegment 1.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec:3.5.0:java (default-cli) @ java-lang-foreign-memorysegment ---
[WARNING]
java.lang.IndexOutOfBoundsException: Out of bound access on segment MemorySegment{ address: 0x600003ef7230, byteSize: 0 }; new offset = 0; new length = 3
    at jdk.internal.foreign.AbstractMemorySegmentImpl.outOfBoundException (AbstractMemorySegmentImpl.java:439)
    at jdk.internal.foreign.AbstractMemorySegmentImpl.apply (AbstractMemorySegmentImpl.java:420)
    at jdk.internal.foreign.AbstractMemorySegmentImpl.apply (AbstractMemorySegmentImpl.java:70)
    at jdk.internal.util.Preconditions.outOfBounds (Preconditions.java:98)
    at jdk.internal.util.Preconditions.outOfBoundsCheckIndex (Preconditions.java:124)
    at jdk.internal.util.Preconditions.checkIndex (Preconditions.java:448)
    at jdk.internal.foreign.AbstractMemorySegmentImpl.checkBounds (AbstractMemorySegmentImpl.java:409)
    at jdk.internal.foreign.AbstractMemorySegmentImpl.checkAccess (AbstractMemorySegmentImpl.java:369)
    at jdk.internal.foreign.AbstractMemorySegmentImpl.copy (AbstractMemorySegmentImpl.java:669)
    at java.lang.foreign.MemorySegment.copy (MemorySegment.java:2583)
    at java.lang.String.copyToSegmentRaw (String.java:1925)
    at java.lang.System$2.copyToSegmentRaw (System.java:2770)
    at jdk.internal.foreign.StringSupport.copyToSegmentRaw (StringSupport.java:325)
    at jdk.internal.foreign.StringSupport.copyBytes (StringSupport.java:315)
    at jdk.internal.foreign.StringSupport.writeByte (StringSupport.java:72)
    at jdk.internal.foreign.StringSupport.write (StringSupport.java:58)
    at jdk.internal.foreign.AbstractMemorySegmentImpl.setString (AbstractMemorySegmentImpl.java:983)
    at jdk.internal.foreign.AbstractMemorySegmentImpl.setString (AbstractMemorySegmentImpl.java:976)
    at org.leplus.unsafe.java.lang.foreign.UnsafeMemorySegment.main (UnsafeMemorySegment.java:29)
    at org.codehaus.mojo.exec.ExecJavaMojo.doMain (ExecJavaMojo.java:375)
    at org.codehaus.mojo.exec.ExecJavaMojo.doExec (ExecJavaMojo.java:364)
    at org.codehaus.mojo.exec.ExecJavaMojo.lambda$execute$0 (ExecJavaMojo.java:286)
    at java.lang.Thread.run (Thread.java:1575)
```

To run is use this command on Mac/Linux:

```bash
./mvnw exec:java -Dexec.mainClass=org.leplus.safe.java.lang.foreign.SafeMemorySegment -Dexec.args="foo"
```

Or on Windows:

```batch
mvnw.cmd exec:java -Dexec.mainClass=org.leplus.safe.java.lang.foreign.SafeMemorySegment -Dexec.args="foo"
```
