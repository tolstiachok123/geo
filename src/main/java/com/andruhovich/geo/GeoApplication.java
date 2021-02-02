package com.andruhovich.geo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication

public class GeoApplication {

  public static void main(String[] args) {
    ApiContextInitializer.init();
    SpringApplication.run(GeoApplication.class, args);
  }

}
