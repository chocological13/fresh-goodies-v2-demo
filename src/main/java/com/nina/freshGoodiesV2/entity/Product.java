package com.nina.freshGoodiesV2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private double price;
  private int weight;
  private String name;
  private String category;
  private String imageUrl;
  @JdbcTypeCode(SqlTypes.JSON)
  private Metadata metadata;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Metadata {
    private String unit;
    private int weight;
    private int calorie;
    private double proteins;
    private double fats;
    private int increment;
    private int carbs;
  }
}
