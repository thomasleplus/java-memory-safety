package org.leplus.unsafe.sun.misc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final long address = getUnsafe().allocateMemory(0);
        for (final String s : args) {
            for (final char c : s.toCharArray()) {
                getUnsafe().putChar(address, c);
            }
        }
    }

    private static Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
        final Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

}
