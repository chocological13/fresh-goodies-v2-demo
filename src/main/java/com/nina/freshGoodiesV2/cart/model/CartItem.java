package com.nina.freshGoodiesV2.cart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long cartItemId;

  @NotNull(message = "Product ID must be present")
  private Long productId;

  @Min(value = 1, message = "Minimum quantity 1")
  private int quantity;
}
