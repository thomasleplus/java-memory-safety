package org.leplus.unsafe.sun.misc;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * This class is intended to demonstrate UNSAFE uses of sun.misc.Unsafe. DO NOT USE THIS CODE AS AN
 * EXAMPLE FOR ANYTHING. You've been warned.
 *
 * @author Thomas Leplus
 * @since 1.0.0
 */
public final class UnsafePutAddress {

  /** Private constructor for utility class. */
  private UnsafePutAddress() {
    // Prevents instantiation.
  }

  /**
   * This is the entrypoint method to run the POC.
   *
   * @param args some strings to write to the off-heap memory.
   */
  public static void main(final String[] args) throws NoSuchFieldException, IllegalAccessException {
    for (final String s : args) {
      getUnsafe().putAddress(0, Long.parseLong(s));
    }
  }

  /**
   * This is the method to instantiate Unsafe. Recent JDK versions have the method
   * Unsafe.getUnsafe() for this but let's implement our own just to maintain compatibility all the
   * way back to Java 1.8.
   *
   * @return an Unsafe instance.
   */
  private static Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
    final Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    return (Unsafe) f.get(null);
  }
}
