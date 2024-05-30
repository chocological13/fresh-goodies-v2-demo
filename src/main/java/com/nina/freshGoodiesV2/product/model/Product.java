package com.nina.freshGoodiesV2.product.model;

import jakarta.persistence.Entity;
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
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotBlank(message = "Unit must be provided")
    private String unit;

    @Min(value = 0, message = "Value must be valid")
    private int weight;

    @Min(value = 0, message = "Value must be valid")
    private int calorie;

    @Min(value = 0, message = "Value must be valid")
    private double proteins;

    @Min(value = 0, message = "Value must be valid")
    private double fats;

    @Min(value = 0, message = "Value must be valid")
    private int increment;

    @Min(value = 0, message = "Value must be valid")
    private int carbs;
  }
}
