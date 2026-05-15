<!-- markdownlint-disable MD041 -->

### Is Java memory safe?

- Spatial (wrong place)
  - Buffer overflow = IndexOutOfBoundsException
  - Heap overflow = OutOfMemoryError
  - Stack overflow = StackOverflowError
- Temporal (wrong time)
  - Uninitialized variables = NullPointerException and default values for primitive types
  - Use after free / double free = N/A (Garbage Collector)

Note: [Go over equivalences.] Most of the memory safety issues are
dealt with cleanly. You get an error or an exception that you can
handle. If you don't, your application will stop but there's mostly no
harm done except for availability. Nice stack trace. Compare to
segmentation fault and dump in C/C++ applications.
