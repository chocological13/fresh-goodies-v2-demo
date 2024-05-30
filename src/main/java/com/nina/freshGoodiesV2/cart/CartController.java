package com.nina.freshGoodiesV2.cart;

import com.nina.freshGoodiesV2.cart.model.Cart;
import com.nina.freshGoodiesV2.cart.model.CartItem;
import com.nina.freshGoodiesV2.cart.service.CartService;
import com.nina.freshGoodiesV2.responses.Response;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

  private final CartService cartService;

  @GetMapping
  public ResponseEntity<Response<List<Cart>>> getAllCarts() {
    List<Cart> cart = cartService.getAllCarts();
    if (!cart.isEmpty()) {
      return Response.successfulResponse(HttpStatus.OK.value(), "Carts fetched!", cart);
    } else {
      return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "No cart was made yet :(", cart);
    }
  }

  @GetMapping("/{cartId}")
  public ResponseEntity<Response<Optional<Cart>>> getCartById(@PathVariable Long cartId) {
    Optional<Cart> cart = cartService.getCartById(cartId);
    if (cart.isPresent()) {
      return Response.successfulResponse(HttpStatus.OK.value(), "Here are the items in cart", cart);
    } else {
      return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Cart doesn't exist :(", cart);
    }
  }

  @PostMapping
  public ResponseEntity<Response<Cart>> createCart(@RequestBody CartItem cartItem) {
    Cart cart = cartService.createCart();
    cartService.addCartItem(cart.getCartId(), cartItem.getProductId(), cartItem.getQuantity());
    return Response.successfulResponse(HttpStatus.CREATED.value(), "Cart created, and item added to cart!", cart);
  }

}
