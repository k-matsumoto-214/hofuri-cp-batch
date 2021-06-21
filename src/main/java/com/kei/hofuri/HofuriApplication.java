package com.kei.hofuri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HofuriApplication {
  public static void main(String[] args) {
    SpringApplication.run(HofuriApplication.class, args);
  }
}
