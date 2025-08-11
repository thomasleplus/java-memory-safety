package org.leplus.safe.java.lang.ws;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** A simple REST controller. */
@RestController
public final class Controller {

  /** The schedule. */
  // CHECKSTYLE:OFF MagicNumber
  private final long[] schedule = new long[366];
  // CHECKSTYLE:ON MagicNumber

  /**
   * Sets the employee ID for a given day.
   *
   * @param day the day.
   * @param id the employee ID.
   */
  @PostMapping(
      path = "/schedule/{day}",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public void setEmployeeIdForDay(
      @PathVariable final int day, @RequestBody final long id) {
    synchronized (schedule) {
      schedule[day] = id;
    }
  }

  /**
   * Returns the employee ID for a given day.
   *
   * @param day the day.
   * @return the employee ID.
   */
  @GetMapping(
      path = "/schedule/{day}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public long getEmployeeIdForDay(@PathVariable final int day) {
    synchronized (schedule) {
      return schedule[day];
    }
  }
}
