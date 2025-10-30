# Java Memory Safety

A study of the limits of Java's memory safety.

[![Maven](https://github.com/thomasleplus/java-memory-safety/workflows/Maven/badge.svg)](https://github.com/thomasleplus/java-memory-safety/actions?query=workflow:"Maven")
[![NPM](https://github.com/thomasleplus/java-memory-safety/workflows/NPM/badge.svg)](https://github.com/thomasleplus/java-memory-safety/actions?query=workflow:"NPM")

## Goals

The purpose of this project is to study the limits of Java's [memory
safety](https://en.wikipedia.org/wiki/Memory_safety). The Java
language and the Java Virtual Machine (JVM) provide strong mechanisms to
prevent developers to mismanage memory. All array primitives in the
Java language come with boundary checks to prevent issues such as
buffer overflows. The language does not include a raw pointer type to
address arbitrary memory to prevent memory access violations (the
dreaded segmentation fault). The JVM's garbage collector mitigates the
risk of dangling pointers and reduces memory leaks.

But the Java SDK and third-party libraries provide ways to circumvent
these protections to allow expert developers to push the limits of
what regular Java applications can do (for example to manipulate
efficiently huge amounts of data). Self-managed memory in Java is
often referred to as off-heap memory (although not all off-heap memory
is managed by the application, some is also used by the JVM
itself). Off-heap memory usage is also necessary to interchange data
when interfacing a Java application with non-Java libraries like
operating system libraries.

## Presentation

I presented this study as a talk at the [BSides London 2025](https://bsides.london/bsides-london-2025) conference.
You can watch the recording
or get the [slides](https://thomasleplus.github.io/java-memory-safety/bsides-london-2025).

There is also a longer version of the [slides](https://thomasleplus.github.io/java-memory-safety/).

## Code

The [`unsafe`](unsafe/) directory contains various code samples that show how NOT
to write Java code. As its name indicate, the code inside this
directory is not safe and must not be used for purpose other than
illustrating the point of this study. All the samples can be run as a
proof of concept. It can also be used to benchmark the ability to
detect memory safety issues with static application security testing
(SAST) tools.

The [`safe`](safe/) directory contains safer alternative implementations.

The [`exploit`](exploit/) directory contains scripts to automate the
exploitation of the unsafe implementations above. The same code can be
used against the safe implementations for comparison.

The [`checkstyle`](checkstyle/) directory contains a Checkstyle
configuration file to detect occurrences of non memory-safe Java code.

The [`spotbugs`](spotbugs/) directory contains a SpotBugs plugin to
detect occurrences of non memory-safe Java code.

The [`reports`](reports/) directory contains some data that was
gathered during the research needed for this project.

## Results

Results from this study are shared in this document and key takeaways
are published in the OSSF Memory Safety SIG Best Practices series
(especially [Memory-Safe By Default Languages](https://github.com/ossf/Memory-Safety/blob/main/docs/best-practice-memory-safe-by-default-languages.md)
and [Interfacing Between Memory-Safe By Default and Non-Memory-Safe by Default Languages](https://github.com/ossf/Memory-Safety/blob/main/docs/best-practice-interfacing.md)).

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## Security

Please read [SECURITY.md](SECURITY.md) for details on our security policy and how to report security vulnerabilities.

## Code of Conduct

Please read [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for details on our code of conduct.

## License

This project is licensed under the terms of the [LICENSE](LICENSE) file.
