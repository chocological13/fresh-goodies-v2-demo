package com.nina.freshGoodiesV2.cart.service.impl;

import com.nina.freshGoodiesV2.cart.model.Cart;
import com.nina.freshGoodiesV2.cart.model.CartItem;
import com.nina.freshGoodiesV2.cart.repository.CartRepository;
import com.nina.freshGoodiesV2.cart.service.CartService;
import com.nina.freshGoodiesV2.product.repository.ProductRepository;
import com.nina.freshGoodiesV2.product.service.ProductService;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

  // POST

  @Override
  @Transactional
  public Cart createCart() {
    Cart cart = new Cart();
    cartRepository.save(cart);
    return cart;
  }

  @Override
  @Transactional
  public CartItem addCartItem(Long cartId, Long productId, int quantity) {
    // check if product exists
    productService.getProductById(productId);

    Optional<Cart> cart = cartRepository.findById(cartId);
    if (cart.isEmpty()) {
      throw new RuntimeException("Cart does not Exist!");
    }

    Cart existingCart = cart.get();

    // create new arraylist for the cart items
    if (existingCart.getCartItems() == null) {
      existingCart.setCartItems(new ArrayList<>());
    }

    boolean itemExists = existingCart.getCartItems().stream().anyMatch(item -> item.getProductId() == productId);

    if (itemExists) {
      throw new RuntimeException("Product ID exists in the cart! Please update the cart to change the quantity "
          + "instead.");
    }

    CartItem cartItem = new CartItem();
    cartItem.setProductId(productId);
    cartItem.setQuantity(quantity);
    existingCart.getCartItems().add(cartItem);

    cartRepository.save(existingCart);
    return cartItem;

  }

}
