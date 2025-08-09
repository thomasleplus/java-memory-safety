package org.leplus.spotbugs;

import java.lang.reflect.Field;

/**
 * Demonstrates the use of reflection to access the internal {@code sun.misc.Unsafe} class and perform
 * a potentially unsafe memory operation. This example retrieves the singleton instance of {@code Unsafe}
 * and invokes the {@code putAddress} method, which can lead to undefined behavior and should be avoided
 * in production code. Use of {@code sun.misc.Unsafe} is discouraged as it relies on internal APIs that
 * are not guaranteed to be present or stable across Java versions.
 *
 * @throws Exception if reflection fails or access to the field is denied
 */
class BadCaseSunQualified {

  /**
   * Uses reflection to access the {@code sun.misc.Unsafe} instance and attempts to write a value to memory address 0.
   * <p>
   * This method demonstrates unsafe operations by bypassing standard Java access controls and directly manipulating memory.
   * It may cause JVM crashes or undefined behavior and should only be used for demonstration or testing purposes.
   *
   * @throws Exception if reflection fails or access to {@code sun.misc.Unsafe} is denied
   */
  void method() throws Exception {
    final Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    final sun.misc.Unsafe unsafe = (sun.misc.Unsafe) f.get(null);
    unsafe.putAddress(0, 0);
  }
}
