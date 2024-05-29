package com.nina.freshGoodiesV2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
  private Long id;

  @Min(value = 0, message = "Price must be valid")
  private double price;

  @Min(value = 1000, message = "A minimum of 1000g is required")
  private int weight;

  @NotBlank(message = "Please enter name")
  private String name;

  @NotBlank(message = "Please enter category")
  private String category;

  @NotBlank(message = "Please provide valid image path")
  private String imageUrl;

  @NotNull(message = "Metadata is required")
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
