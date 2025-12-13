<!-- markdownlint-disable MD041 -->

### Unsafe: Java's worst kept secret

`sun.misc.Unsafe`

```java
public byte getByte(long address);
public void putByte(long address, byte x);
public short getShort(long address);
public void putShort(long address, short x);
public int getInt(long address);
public void putInt(long address, int x);
public long getLong(long address);
public void putLong(long address, long x);
public float getFloat(long address);
public void putFloat(long address, float x);
public double getDouble(long address);
public void putDouble(long address, double x);
```

Note: Undocumented API introduced with Java 8 (2014).
