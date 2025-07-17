package org.leplus.spotbugs;

import java.lang.reflect.Field;

class BadCaseJdkQualified {

  void method() throws Exception {
    final Field f = jdk.internal.misc.Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    final jdk.internal.misc.Unsafe unsafe = (jdk.internal.misc.Unsafe) f.get(null);
    unsafe.putAddress(0, 0);
  }
}
