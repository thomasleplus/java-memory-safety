package org.leplus.unsafe.sun.misc.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * This class is intended to demonstrate UNSAFE uses of sun.misc.Unsafe.
 * DO NOT USE THIS CODE AS AN EXAMPLE FOR ANYTHING.
 * You've been warned.
 *
 * @author Thomas Leplus
 * @since 1.0.0
 */
public class UnsafeMain {

  /**
   * This is the entrypoint method to run the POC.
   *
   * @param args some strings to write to the off-heap memory.
   */
  public static void main(final String[] args) throws NoSuchFieldException, IllegalAccessException {
    final long address = getUnsafe().allocateMemory(0);
    for (final String s : args) {
      for (final char c : s.toCharArray()) {
        getUnsafe().putChar(address, c);
      }
    }
  }

  /**
   * This is the method to instantiate Unsafe.
   *
   * @return an Unsafe instance.
   */
  private static Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
    final Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    return (Unsafe) f.get(null);
  }
}
