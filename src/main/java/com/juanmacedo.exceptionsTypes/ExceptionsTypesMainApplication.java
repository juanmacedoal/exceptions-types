package com.juanmacedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;

/** Spring main exception types application. */
@SpringBootApplication
public class ExceptionsTypesMainApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(ExceptionsTypesMainApplication.class, args);
  }

  @GetMapping("/hello")
  public String getHello() {
    return "Hello";
  }
}
