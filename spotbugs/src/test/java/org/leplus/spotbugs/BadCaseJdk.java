package org.leplus.spotbugs;

import java.lang.reflect.Field;
import jdk.internal.misc.Unsafe;

/**
 * Demonstrates unsafe usage of the {@link sun.misc.Unsafe} class by directly manipulating memory addresses.
 * <p>
 * This class contains a method that uses reflection to access the private "theUnsafe" field of the {@code Unsafe} class,
 * obtains an instance of {@code Unsafe}, and then calls {@code putAddress} with a hardcoded address.
 * Such usage can lead to JVM crashes, memory corruption, and security vulnerabilities.
 * <p>
 * <b>Warning:</b> This code is for demonstration or testing purposes only and should not be used in production.
 */
class BadCaseJdk {

  /**
   * Demonstrates the use of reflection to access the {@code Unsafe} class and perform a potentially dangerous memory operation.
   * <p>
   * This method retrieves the private static field {@code theUnsafe} from the {@code Unsafe} class,
   * makes it accessible, and obtains an instance of {@code Unsafe}. It then calls {@code putAddress}
   * with address {@code 0} and value {@code 0}, which can lead to JVM crashes or undefined behavior.
   * </p>
   *
   * @throws Exception if reflection fails or if the operation cannot be completed
   * @implNote This method uses internal APIs and should not be used in production code.
   */
  void method() throws Exception {
    final Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    final Unsafe unsafe = (Unsafe) f.get(null);
    unsafe.putAddress(0, 0);
  }
}
