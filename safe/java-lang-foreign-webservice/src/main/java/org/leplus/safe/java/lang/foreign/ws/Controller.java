package org.leplus.safe.java.lang.foreign.ws;

import jakarta.annotation.PostConstruct;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** A simple REST controller. */
@RestController
public final class Controller {

  /** The buffer size: the maximum number of days of the year. */
  private static final int BUFFER_SIZE = 366;

  /** The segment. */
  private MemorySegment segment = null;

  /** Initializes the controller. */
  @PostConstruct
  public void initialize() {
    segment = Arena.global().allocate(BUFFER_SIZE * Long.BYTES);
  }

  /**
   * Sets the employee ID for a given day.
   *
   * @param day the day.
   * @param id the employee ID.
   */
  @PostMapping(path = "/schedule/{day}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void setEmployeeIdForDay(@PathVariable final int day, @RequestBody final long id) {
    synchronized (segment) {
      segment.set(ValueLayout.JAVA_LONG, (long) day * (long) Long.BYTES, id);
    }
  }

  /**
   * Returns the employee ID for a given day.
   *
   * @param day the day.
   * @return the employee ID.
   */
  @GetMapping(path = "/schedule/{day}", produces = MediaType.APPLICATION_JSON_VALUE)
  public long getEmployeeIdForDay(@PathVariable final int day) {
    synchronized (segment) {
      return segment.get(ValueLayout.JAVA_LONG, (long) day * (long) Long.BYTES);
    }
  }
}
