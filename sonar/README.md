# Sonar

## SonarCloud

The rule `java:S1191` detects imports from `sun.*` which includes
`sun.misc.Unsafe`. But no detection for `jdk.internal.misc.Unsafe`.

## SonarQube

The same rule `java:S1191` detects imports from `sun.*` which includes
`sun.misc.Unsafe`. There ia a
[customizable rule `java:S2253`](https://rules.sonarsource.com/java/RSPEC-3688/)
to blacklist arbitrary classes that can be used to detect
`jdk.internal.misc.Unsafe` and it's not limited to `import`
statements.
