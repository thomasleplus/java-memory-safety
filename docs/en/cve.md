<!-- markdownlint-disable MD041 -->

### [CVE-2024-36114](https://nvd.nist.gov/vuln/detail/CVE-2024-36114) - 9.8 (Critical)

- "Because Aircompressor uses the JDK class `sun.misc.Unsafe` to speed up memory access, no additional bounds checks are performed and this has similar security consequences as out-of-bounds access in C or C++, namely it can lead to non-deterministic behavior or crash the JVM."
- Similar issue with iq80 Snappy [CVE-2024-36124](https://nvd.nist.gov/vuln/detail/CVE-2024-36124) - 5.3 (Medium).

Note: Probably a lot more, if anybody is interested in collecting bug bounties.
