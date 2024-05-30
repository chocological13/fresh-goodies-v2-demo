package com.nina.freshGoodiesV2.cart.service.impl;

import com.nina.freshGoodiesV2.cart.model.Cart;
import com.nina.freshGoodiesV2.cart.model.CartItem;
import com.nina.freshGoodiesV2.cart.repository.CartRepository;
import com.nina.freshGoodiesV2.cart.service.CartService;
import com.nina.freshGoodiesV2.product.repository.ProductRepository;
import com.nina.freshGoodiesV2.product.service.ProductService;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

  private final CartRepository cartRepository;
  private final ProductService productService;

  // GET

  @Override
  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }

  @Override
  public Optional<Cart> getCartById(Long cartId) {
    return cartRepository.findById(cartId);
  }

  @Override
  public List<CartItem> getAllCartItems(Long cartId) {
    Optional<Cart> cart = cartRepository.findById(cartId);
    if (cart.isEmpty()) {
      throw new RuntimeException("Cart not found!");
    }
    return cart.get().getCartItems();
  }

}
