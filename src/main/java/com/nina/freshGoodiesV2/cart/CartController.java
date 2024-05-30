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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

  private final CartService cartService;

  @GetMapping
  public List<Cart> getAllCarts() {
    return cartService.getAllCarts();
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

}
