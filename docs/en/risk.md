<!-- markdownlint-disable MD041 -->

### How bad is the problem?

- Buffer overflows and uninitialized variables means that a program
  can maybe tricked into reading data from another
  program. Potentially leaking sensitive information (e.g. secrets
  like keys or crendentials).
- Heap and stack memory seat together in RAM, so overwritting
  memory can lead to arbitrary code execution.

Note: [Go over items.]
