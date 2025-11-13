<!-- markdownlint-disable MD041 -->

### How can I tell?

|            | `s.m.Unsafe` | `j.i.m.Unsafe` |
| ---------- | ------------ | -------------- |
| Semgrep    | &#x1F527;    | &#x1F527;      |
| SonarQube  | &#x2705;     | &#x1F527;      |
| CodeQL     | &#x2705;     | &#x274C;       |
| CheckStyle | &#x1F527;    | &#x1F527;      |
| PMD/Codacy | &#x2705;     | &#x274C;       |
| SpotBugs   | &#x1F6A7;    | &#x1F6A7;      |
| Scorecard  | &#x1F6A7;    | &#x1F6A7;      |

Note: Checkstyle's rule is enabled for Sun profile, but not newer
Google one, and has to be configured further to catch
`jdk.internal.misc.*`. Commercial scanner are similar. Request it or
write your own. Even a simple `grep` of your code could do it.
