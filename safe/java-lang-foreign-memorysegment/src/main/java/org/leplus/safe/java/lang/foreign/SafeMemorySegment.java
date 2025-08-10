package org.leplus.safe.java.lang.foreign;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * This class is intended to demonstrate safe (failing) uses of
 * java.lang.foreign.MemorySegment. DO NOT USE THIS CODE AS AN EXAMPLE FOR
 * ANYTHING. You've been warned.
 *
 * @author Thomas Leplus
 * @since 1.0.0
 */
public final class SafeMemorySegment {

  /** Private constructor for utility class. */
  private SafeMemorySegment() {
    // Prevents instantiation.
  }

  /**
   * This is the entrypoint method to run the POC.
   *
   * @param args some strings to write to the off-heap memory.
   */
  public static void main(final String[] args) {
    try (Arena arena = Arena.ofShared()) {
      final MemorySegment segment = arena.allocate(0);
      for (final String s : args) {
        segment.setString(0, s);
      }
    }
  }
}
