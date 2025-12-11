<!-- markdownlint-disable MD041 -->

### Unsafe (continued)

`sun.misc.Unsafe`

```java
public long allocateMemory(long bytes);
public long reallocateMemory(long address, long bytes);
public void freeMemory(long address);
public void setMemory(...);
public void copyMemory(...);
...
```

Note: Wait, there's more! None of these methods throw any exception
and that's not an oversight.
