<!-- markdownlint-disable MD041 -->

### What is memory safety?

- Spatial (wrong place)
  - Buffer overflow: read/write out of buffer boundaries.
  - Heap overflow: memory exhaustion.
  - Stack overflow: infinite loops.
- Temporal (wrong time)
  - Use uninitialized variables.
  - Use after free, double free.
  - Race conditions?

Note: Race conditions (concurrent access to shared memory) are
sometimes considered a memory safety issue. Not many languages prevent
that but Rust for example ensures there is at most one writer or one
or more readers.
