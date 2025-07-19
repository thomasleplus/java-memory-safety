package org.leplus.unsafe.sun.misc.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class Application {

  @Bean
  public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeQueryString(true);
    loggingFilter.setIncludePayload(true);
    return loggingFilter;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
