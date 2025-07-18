package org.leplus.unsafe.sun.misc.ws;

import jakarta.annotation.PostConstruct;
import java.lang.reflect.Field;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sun.misc.Unsafe;

@RestController
public class Controller {

  private static final int BUFFER_SIZE = 366;

  private final Object lock = new Object();

  private long address;

  private Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
    final Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    return (Unsafe) f.get(null);
  }

  @PostConstruct
  public void initialize() throws NoSuchFieldException, IllegalAccessException {
    address = getUnsafe().allocateMemory(BUFFER_SIZE * Long.BYTES);
  }

  @PostMapping(path = "/schedule/{day}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void setEmployeeIdForDay(@PathVariable int day, @RequestBody long id)
      throws NoSuchFieldException, IllegalAccessException {
    synchronized (lock) {
      getUnsafe().putLong(address + day * Long.BYTES, id);
    }
  }

  @GetMapping(path = "/schedule/{day}", produces = MediaType.APPLICATION_JSON_VALUE)
  public long getEmployeeIdForDay(@PathVariable int day)
      throws NoSuchFieldException, IllegalAccessException {
    synchronized (lock) {
      return getUnsafe().getLong(address + day * Long.BYTES);
    }
  }
}
