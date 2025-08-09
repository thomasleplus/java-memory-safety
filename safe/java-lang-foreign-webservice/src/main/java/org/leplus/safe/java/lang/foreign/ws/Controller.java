package org.leplus.safe.java.lang.foreign.ws;

import jakarta.annotation.PostConstruct;
import java.lang.foreign.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public final class Controller {

  private static final int BUFFER_SIZE = 366;

  private MemorySegment segment = null;

  @PostConstruct
  public void initialize() {
    segment = Arena.global().allocate(BUFFER_SIZE * Long.BYTES);
  }

  @PostMapping(path = "/schedule/{day}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void setEmployeeIdForDay(@PathVariable final int day, @RequestBody final long id) {
    synchronized (segment) {
      segment.set(ValueLayout.JAVA_LONG, (long) day * (long) Long.BYTES, id);
    }
  }

  @GetMapping(path = "/schedule/{day}", produces = MediaType.APPLICATION_JSON_VALUE)
  public long getEmployeeIdForDay(@PathVariable final int day) {
    synchronized (segment) {
      return segment.get(ValueLayout.JAVA_LONG, (long) day * (long) Long.BYTES);
    }
  }
}
