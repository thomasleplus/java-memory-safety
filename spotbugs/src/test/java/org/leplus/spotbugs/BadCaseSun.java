package org.leplus.spotbugs;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * Demonstrates unsafe memory manipulation using {@code sun.misc.Unsafe}.
 *
 * <p>This class contains a method that uses reflection to access the private
 * {@code theUnsafe} instance of {@code sun.misc.Unsafe} and performs a direct
 * memory operation via {@code putAddress}. Such usage can lead to JVM crashes,
 * memory corruption, or security vulnerabilities, and should be avoided in
 * production code.
 *
 * @throws Exception if reflection or memory access fails
 */
class BadCaseSun {

  /**
   * Demonstrates the use of reflection to access the private {@code theUnsafe}
   * field of the {@link Unsafe} class and performs a potentially unsafe memory
   * operation by writing to address 0.
   *
   * @throws Exception if reflection fails or if the memory operation is not
   *     permitted
   * @implNote This method uses internal Java APIs and unsafe operations that
   *     can compromise JVM stability and security. Use only for demonstration
   *     or testing purposes.
   */
  void method() throws Exception {
    final Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    final Unsafe unsafe = (Unsafe) f.get(null);
    unsafe.putAddress(0, 0);
  }
}
