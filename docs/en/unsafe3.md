<!-- markdownlint-disable MD041 -->

### Example

```java
  private static final int BUFFER_SIZE = 366;
  private long address;
  @Construct
  public void initialize() {
    address = getUnsafe()
                 .allocateMemory(BUFFER_SIZE * Long.BYTES);
  }
  @POST("/schedule/{day}")
  public void setEmployeeIdForDay(@Path int day, @Body long id) {
    getUnsafe().putLong(address + day, id);
  }
  @GET("/schedule/{day}")
  public long getEmployeeIdForDay(@Path int day) {
    return getUnsafe().getLong(address + day);
  }
```

Note: FIXME
