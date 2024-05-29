package com.nina.freshGoodiesV2.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {

  @Id
  private Integer id;
  private double price;
  private int weight;
  private String name;
  private String category;
  private String imageUrl;

}
