# Code

The code in this project demonstrates a safer implementation of the
patterns . It uses the Foreign Function and Memory (FFM) API (out of
preview since Java 22). Executing this code results in a much cleaner
unchecked java.lang.IndexOutOfBoundsException insted of a segmentation
fault (SIGSEGV).

To run is use this command on Mac/Linux:

```bash
./mvnw exec:java -Dexec.mainClass=org.leplus.safe.java.lang.foreign.SafeMemorySegment -Dexec.args="foo"
```

Or on Windows:

```batch
mvnw.cmd exec:java -Dexec.mainClass=org.leplus.safe.java.lang.foreign.SafeMemorySegment -Dexec.args="foo"
```
