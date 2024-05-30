package com.nina.freshGoodiesV2.cart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long cartId;

  @OneToMany
  private List<CartItem> cartItems;
}
