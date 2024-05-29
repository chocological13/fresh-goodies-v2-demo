package com.nina.freshGoodiesV2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private double price;
  private int weight;
  private String name;
  private String category;
  private String imageUrl;

  public Product(Integer id, double price, int weight, String name, String category, String imageUrl) {
    this.id = id;
    this.price = price;
    this.weight = weight;
    this.name = name;
    this.category = category;
    this.imageUrl = imageUrl;
  }
}
