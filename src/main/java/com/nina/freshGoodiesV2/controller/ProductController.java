package com.nina.freshGoodiesV2.controller;

import com.nina.freshGoodiesV2.entity.Product;
import com.nina.freshGoodiesV2.responses.Response;
import com.nina.freshGoodiesV2.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

//  @GetMapping
//  public String testThis() {
//    return productService.doesItRun();
//  }

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProduct();
  }

  @PostMapping
  public ResponseEntity<Response<Product>> addProduct(@Validated @RequestBody Product newProduct) {
    Product createdProduct = productService.addProduct(newProduct);

    return Response.successfulResponse(HttpStatus.CREATED.value(), "New product added", newProduct);
  }

}
