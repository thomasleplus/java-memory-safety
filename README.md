# Java Memory Safety

A study of the limits of Java's memory safety.

[![Maven](https://github.com/thomasleplus/java-memory-safety/workflows/Maven/badge.svg)](https://github.com/thomasleplus/java-memory-safety/actions?query=workflow:"Maven")
[![CodeQL](https://github.com/thomasleplus/java-memory-safety/workflows/CodeQL/badge.svg)](https://github.com/thomasleplus/java-memory-safety/actions?query=workflow:"CodeQL")

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

I presentated this stiday as a talk to various meetups and
conferences. You can find the slides [here](https://thomasleplus.github.io/java-memory-safety/).

## Code

The `unsafe` directory contains various code samples that show how NOT
to write Java code. As its name indicate, the code inside this
directory is not safe and must not be used for purpose other than
illustrating the point of this study. All the samples can be run as a
proof of concept. It can also be used to benchmark the ability to
detect memory safety issues with static application security testing
(SAST) tools.

The `safe` directory contains safer alternative implemetations.

## Results

Results from this study are shared in this document and key takeaways
are published in the OSSF Memory Safety SIG Best Practices series
(especially [Memory-Safe By Default Languages](https://github.com/ossf/Memory-Safety/blob/main/docs/best-practice-memory-safe-by-default-languages.md)
and [Interfacing Between Memory-Safe By Default and Non-Memory-Safe by Default Languages](https://github.com/ossf/Memory-Safety/blob/main/docs/best-practice-interfacing.md)).
