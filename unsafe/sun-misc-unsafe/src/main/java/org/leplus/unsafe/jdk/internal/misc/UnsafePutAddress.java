package org.leplus.unsafe.jdk.internal.misc;

import jdk.internal.misc.Unsafe;

/**
 * This class is intended to demonstrate UNSAFE uses of jdk.internal.misc.Unsafe. DO NOT USE THIS CODE AS AN
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
      Unsafe.getUnsafe().putAddress(0, Long.parseLong(s));
    }
  }
}
