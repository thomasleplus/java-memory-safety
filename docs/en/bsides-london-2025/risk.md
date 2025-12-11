<!-- markdownlint-disable MD041 -->

### How bad is the problem?

- Buffer overflows and uninitialized variables means that a program
  can be tricked into reading data from another
  program. Potentially leaking sensitive information (e.g. secrets
  like keys or credentials).
- Heap and stack memory seat together in RAM, so overwriting
  memory can lead to arbitrary code execution.

Note: [Go over items.]
