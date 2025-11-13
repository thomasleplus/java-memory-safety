<!-- markdownlint-disable MD041 -->

### How can I tell?

|            | `s.m.Unsafe` | `j.i.m.Unsafe` |
| ---------- | ------------ | -------------- |
| Semgrep    | &#x274C;     | &#x274C;       |
| SonarQube  | &#x2705;     | &#x1F527;      |
| CodeQL     | &#x2705;     | &#x274C;       |
| CheckStyle | &#x1F527;    | &#x1F527;      |
| PMD/Codacy | &#x2705;     | &#x274C;       |
| SpotBugs   | &#x1F6A7;    | &#x1F6A7;      |
| Scorecard  | &#x1F6A7;    | &#x1F6A7;      |

Request it &#x1F91E; or write your own &#x1F4AA;.

Note: PMD, Checkstyle, SonarCloud and CodeQL have rules for
`sun.*`. Checkstyle's rule is enabled for Sun profile, but not newer
Google one, and has to be configured further to catch
`jdk.internal.misc.*`. Ironically it's the only one that doesn't claim
to be a security tool. Commercial scanner are similar. Even a simple
`grep` of your code should do it.
