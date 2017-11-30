package com.example.interceptordemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

  private Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person(" +
        "id=" + id +
        ", name='" + name + '\'' +
        ')';
  }
}
