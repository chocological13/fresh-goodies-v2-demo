package com.nina.freshGoodiesV2.cart.service;

import com.nina.freshGoodiesV2.cart.model.Cart;
import com.nina.freshGoodiesV2.cart.model.CartItem;
import java.util.List;
import java.util.Optional;

public interface CartService {

  //GET
  List<Cart> getAllCarts();
  Optional<Cart> getCartById(Long cartId);
  List<CartItem> getAllCartItems(Long cartId);

  // POST
  Cart createCart();

  CartItem addCartItem(Long id, Long productId, int quantity);
}
