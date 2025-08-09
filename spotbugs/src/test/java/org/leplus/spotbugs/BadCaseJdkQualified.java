package org.leplus.spotbugs;

import java.lang.reflect.Field;

/**
 * Demonstrates usage of internal JDK APIs to access and use {@code jdk.internal.misc.Unsafe}.
 *
 * <p>This class uses reflection to obtain the singleton instance of {@code Unsafe} and invokes the
 * {@code putAddress} method, which can potentially compromise memory safety.
 *
 * <p><b>Warning:</b> Accessing internal JDK APIs is strongly discouraged as it may break in future
 * Java versions and can lead to undefined behavior or security vulnerabilities.
 *
 * @throws Exception if reflection fails or access is denied
 */
class BadCaseJdkQualified {

  /**
   * Uses reflection to access the internal {@code Unsafe} class and sets a memory address to zero.
   *
   * <p>This method retrieves the {@code theUnsafe} instance from {@code jdk.internal.misc.Unsafe},
   * makes it accessible, and invokes {@code putAddress} to write a value to a specific memory
   * address. <b>Warning:</b> This code uses internal JDK APIs and reflection, which can break in
   * future Java versions and may compromise application security and stability.
   *
   * @throws Exception if reflection fails or access to the field is denied
   */
  void method() throws Exception {
    final Field f = jdk.internal.misc.Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    final jdk.internal.misc.Unsafe unsafe = (jdk.internal.misc.Unsafe) f.get(null);
    unsafe.putAddress(0, 0);
  }
}
