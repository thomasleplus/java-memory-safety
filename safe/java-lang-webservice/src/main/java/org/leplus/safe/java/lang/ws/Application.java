package org.leplus.safe.java.lang.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/** The main application class. */
@SpringBootApplication
public class Application {

  /**
   * Creates a request logging filter.
   *
   * @return the request logging filter.
   */
  @Bean
  public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeQueryString(true);
    loggingFilter.setIncludePayload(true);
    return loggingFilter;
  }

  /**
   * The main method.
   *
   * @param args the command line arguments.
   */
  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
