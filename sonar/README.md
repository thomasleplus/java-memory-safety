# Sonar

## SonarCloud

The rule `java:S1191` detects imports from `sun.*` which includes
`sun.misc.Unsafe`. But no detection for `jdk.internal.misc.Unsafe`.

## SonarQube

The same rule `java:S1191` detects imports from `sun.*` which includes
`sun.misc.Unsafe`. There might be a [customizable rule](https://rules.sonarsource.com/java/RSPEC-3688/)
to blacklist arbitrary classes in which cases it could be used to detect `jdk.internal.misc.Unsafe`.
