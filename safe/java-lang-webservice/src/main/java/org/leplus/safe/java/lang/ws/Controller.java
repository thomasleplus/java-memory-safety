package org.leplus.safe.java.lang.ws;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public final class Controller {

  private final long[] schedule = new long[366];

  @PostMapping(path = "/schedule/{day}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void setEmployeeIdForDay(@PathVariable final int day, @RequestBody final long id) {
    synchronized (schedule) {
      schedule[day] = id;
    }
  }

  @GetMapping(path = "/schedule/{day}", produces = MediaType.APPLICATION_JSON_VALUE)
  public long getEmployeeIdForDay(@PathVariable final int day) {
    synchronized (schedule) {
      return schedule[day];
    }
  }
}
