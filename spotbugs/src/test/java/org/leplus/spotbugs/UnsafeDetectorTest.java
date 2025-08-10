package org.leplus.spotbugs;

import static edu.umd.cs.findbugs.test.CountMatcher.containsExactly;
import static org.junit.Assert.assertThat;

import edu.umd.cs.findbugs.BugCollection;
import edu.umd.cs.findbugs.test.SpotBugsRule;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcher;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcherBuilder;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Rule;
import org.junit.Test;

/** Tests for the {@link UnsafeDetector}. */
public class UnsafeDetectorTest {

  /** The SpotBugs rule. */
  @Rule public SpotBugsRule spotbugs = new SpotBugsRule();

  private void testBadCase(final String name) {
    Path path =
        Paths.get(
            "target/test-classes",
            "org.leplus.spotbugs".replace('.', '/'),
            "BadCase" + name + ".class");
    BugCollection bugCollection = spotbugs.performAnalysis(path);
    BugInstanceMatcher bugTypeMatcher =
        new BugInstanceMatcherBuilder().bugType("UNSAFE_CALL").build();
    assertThat(bugCollection, containsExactly(1, bugTypeMatcher));
  }

  /** Tests the bad case for {@code sun.misc.Unsafe}. */
  @Test
  public void testBadCaseSun() {
    testBadCase("Sun");
  }

  /** Tests the bad case for {@code sun.misc.Unsafe} with a fully qualified name. */
  @Test
  public void testBadCaseSunQualified() {
    testBadCase("SunQualified");
  }

  /** Tests the bad case for {@code jdk.internal.misc.Unsafe}. */
  @Test
  public void testBadCaseJdk() {
    testBadCase("Jdk");
  }

  /** Tests the bad case for {@code jdk.internal.misc.Unsafe} with a fully qualified name. */
  @Test
  public void testBadCaseJdkQualified() {
    testBadCase("JdkQualified");
  }
}
