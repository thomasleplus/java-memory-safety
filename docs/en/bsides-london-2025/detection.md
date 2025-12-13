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

Note: Static Application Security Testing. If no SAST, you should. [Go
over list.] Commercial scanner are similar. SpotBugs and Veracode scan
bytecode so with those you could scan third-party software or
libraries... Request it or write your own. Even a simple `grep` of
your code could do it. No excuse for not checking.
