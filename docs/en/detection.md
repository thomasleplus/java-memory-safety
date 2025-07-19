<!-- markdownlint-disable MD041 -->

### How can I tell?

|            | `s.m.Unsafe` | `j.i.m.Unsafe` |
| ---------- | ------------ | -------------- |
| SpotBugs   | &#x274C;     | &#x274C;       |
| PMD/Codacy | &#x1F527;    | &#x274C;       |
| CheckStyle | &#x2705;     | &#x1F527;      |
| SonarCloud | &#x2705;     | &#x274C;       |
| CodeQL     | &#x2705;     | &#x274C;       |
| Semgrep    | &#x274C;     | &#x274C;       |

Request it &#x1F91E; or write your own &#x1F4AA;.

Note: PMD has a rule but it doesn't seem enabled by default FIXME?
Checkstyle, SonarCloud and CodeQL have rules for `sun.*`. Checkstyle's
rule can be configured to add more packages. Commercial scanner are
similar. Even a simple `grep` of your code should do it.
