package com.example.interceptordemo;

import org.aspectj.lang.Aspects;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class InterceptorDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(InterceptorDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner runner(PersonRepository repository) {
    return args -> {
      Stream.of("Jon", "Sean", "John", "Alex")
          .map(Person::new)
          .forEach(repository::save);
      repository.findAll()
          .forEach(System.out::println);
    };
  }

  @Bean
  public Interceptor interceptor() {
    return Aspects.aspectOf(Interceptor.class);
  }
}

