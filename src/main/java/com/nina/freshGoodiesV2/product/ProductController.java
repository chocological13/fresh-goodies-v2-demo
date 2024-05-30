package com.nina.freshGoodiesV2.product;

import com.nina.freshGoodiesV2.product.entity.Product;
import com.nina.freshGoodiesV2.responses.Response;
import com.nina.freshGoodiesV2.product.service.ProductService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService productService;

//  @GetMapping
//  public String testThis() {
//    return productService.doesItRun();
//  }

  @GetMapping
  public ResponseEntity<List<Product>> getProduct(@RequestParam(value = "query", required = false) String searchQuery,
      @RequestParam(value = "value", required = false) String searchValue) {
    List<Product> filteredProduct = productService.getProduct(searchQuery, searchValue);
    return ResponseEntity.ok(filteredProduct);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Response<Optional<Product>>> getProductById(@PathVariable Long productId) {
    Optional<Product> productFound = productService.getProductById(productId);
    if (productFound.isPresent()) {
      return Response.successfulResponse(HttpStatus.OK.value(), "Found it!", productFound);
    } else {
      return Response.failedResponse(HttpStatus.NOT_FOUND.value(), "Naurrrrrr! It doesn't exist!");
    }
  }

  @PostMapping
  public ResponseEntity<Response<Product>> addProduct(@Validated @RequestBody Product newProduct) {
    Product createdProduct = productService.addProduct(newProduct);

    return Response.successfulResponse(HttpStatus.CREATED.value(), "heh", newProduct);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<Response<Product>> updateProduct(@PathVariable Long productId,
      @Validated @RequestBody Product updatedProduct) {
    try {
      Product existingProduct = productService.updateProduct(productId, updatedProduct);
      return Response.successfulResponse(HttpStatus.CREATED.value(), "Product Updated!", existingProduct);
    } catch (Exception e) {
      return Response.failedResponse(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }

  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Response<Objects>> deleteProduct(@PathVariable Long productId) {
    productService.deleteProduct(productId);
    return Response.successfulResponse("Product deleted!");
  }
}



