package org.leplus.spotbugs;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

class BadCaseSun {

  void method() throws Exception {
    final Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    final Unsafe unsafe = (Unsafe) f.get(null);
    unsafe.putAddress(0, 0);
  }
}
