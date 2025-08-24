package org.leplus.spotbugs;

import edu.umd.cs.findbugs.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;

/** Tests for the {@link UnsafeDetector}. */
class UnsafeDetectorTest extends AbstractIntegrationTest {

  /** Tests the bad case for {@code sun.misc.Unsafe}. */
  @Test
  void testBadCaseSun() {
    performAnalysis("target/org/leplus/spotbugs/BadCaseSun.class");
    assertNumOfCTBugs(1);
    assertCTBugInLine(4);
  }

  /** Tests the bad case for {@code sun.misc.Unsafe} with a fully qualified name. */
  @Test
  void testBadCaseSunQualified() {
    performAnalysis("target/org/leplus/spotbugs/BadCaseSunQualified.class");
    assertNumOfCTBugs(2);
    assertCTBugInLine(27);
    assertCTBugInLine(29);
  }

  /** Tests the bad case for {@code jdk.internal.misc.Unsafe}. */
  @Test
  void testBadCaseJdk() {
    performAnalysis("target/org/leplus/spotbugs/BadCaseJdk.class");
    assertNumOfCTBugs(1);
    assertCTBugInLine(4);
  }

  /** Tests the bad case for {@code jdk.internal.misc.Unsafe} with a fully qualified name. */
  @Test
  void testBadCaseJdkQualified() {
    performAnalysis("target/org/leplus/spotbugs/BadCaseJdkQualified.class");
    assertNumOfCTBugs(2);
    assertCTBugInLine(29);
    assertCTBugInLine(31);
  }
}
