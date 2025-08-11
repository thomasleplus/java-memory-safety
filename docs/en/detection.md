<!-- markdownlint-disable MD041 -->

### How can I tell?

|            | `s.m.Unsafe` | `j.i.m.Unsafe` |
| ---------- | ------------ | -------------- |
| PMD/Codacy | &#x2705;     | &#x274C;       |
| SonarCloud | &#x2705;     | &#x274C;       |
| CodeQL     | &#x2705;     | &#x274C;       |
| Semgrep    | &#x274C;     | &#x274C;       |
| SpotBugs   | &#x274C;     | &#x274C;       |
| CheckStyle | &#x1F527;    | &#x1F527;      |

Request it &#x1F91E; or write your own &#x1F4AA;.

Note: PMD, Checkstyle, SonarCloud and CodeQL have rules for
`sun.*`. Checkstyle's rule is enabled for Sun profile, but not newer
Google one, and has to be configured further to catch
`jdk.internal.misc.*`. Ironically it's the only one that doesn't claim
to be a security tool. Commercial scanner are similar. Even a simple
`grep` of your code should do it.
