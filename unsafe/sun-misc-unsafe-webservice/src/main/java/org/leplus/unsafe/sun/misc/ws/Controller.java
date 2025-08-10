package org.leplus.unsafe.sun.misc.ws;

import jakarta.annotation.PostConstruct;
import java.lang.reflect.Field;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Unsafe;

/** A simple REST controller. */
@RestController
public final class Controller {

  private static final int BUFFER_SIZE = 366;

  private final Object lock = new Object();

  private long address;

  private Unsafe getUnsafe()
      throws IllegalAccessException, NoSuchFieldException {
    final Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    return (Unsafe) f.get(null);
  }

  /**
   * Initializes the controller.
   *
   * @throws NoSuchFieldException if the unsafe field cannot be found.
   * @throws IllegalAccessException if the unsafe field cannot be accessed.
   */
  @PostConstruct
  public void initialize() throws NoSuchFieldException, IllegalAccessException {
    address = getUnsafe().allocateMemory(BUFFER_SIZE * Long.BYTES);
  }

  /**
   * Sets the employee ID for a given day.
   *
   * @param day the day.
   * @param id the employee ID.
   * @throws NoSuchFieldException if the unsafe field cannot be found.
   * @throws IllegalAccessException if the unsafe field cannot be accessed.
   */
  @PostMapping(
      path = "/schedule/{day}",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public void setEmployeeIdForDay(
      @PathVariable final int day, @RequestBody final long id)
      throws NoSuchFieldException, IllegalAccessException {
    synchronized (lock) {
      getUnsafe().putLong(address + (long) day * (long) Long.BYTES, id);
    }
  }

  /**
   * Returns the employee ID for a given day.
   *
   * @param day the day.
   * @return the employee ID.
   * @throws NoSuchFieldException if the unsafe field cannot be found.
   * @throws IllegalAccessException if the unsafe field cannot be accessed.
   */
  @GetMapping(
      path = "/schedule/{day}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public long getEmployeeIdForDay(@PathVariable final int day)
      throws NoSuchFieldException, IllegalAccessException {
    synchronized (lock) {
      return getUnsafe().getLong(address + (long) day * (long) Long.BYTES);
    }
  }
}
