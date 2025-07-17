package org.leplus.spotbugs;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;
import org.apache.bcel.Const;

public class UnsafeDetector extends OpcodeStackDetector {

  private final BugReporter bugReporter;

  public UnsafeDetector(BugReporter bugReporter) {
    this.bugReporter = bugReporter;
  }

  @Override
  public void sawOpcode(int seen) {
    if (seen != Const.INVOKEVIRTUAL) {
      return;
    }
    if (getClassConstantOperand().equals("sun/misc/Unsafe")
        || getClassConstantOperand().equals("jdk/internal/misc/Unsafe")) {
      BugInstance bug =
          new BugInstance(this, "UNSAFE_CALL", HIGH_PRIORITY)
              .addClassAndMethod(this)
              .addSourceLine(this, getPC());
      bugReporter.reportBug(bug);
    }
  }
}
