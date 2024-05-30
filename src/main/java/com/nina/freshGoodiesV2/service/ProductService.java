package com.nina.freshGoodiesV2.service;

import com.nina.freshGoodiesV2.entity.Product;
import com.nina.freshGoodiesV2.repository.ProductRepository;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Log
public class ProductService {


  private final ProductRepository productRepository;

  public List<Product> getProduct(String searchQuery, String searchValue) {
    if (searchQuery == null && searchValue == null) {
      return productRepository.findAll();
    } else if (searchQuery == null || searchValue == null) {
      throw new RuntimeException("Enter all queries");
    } else {
      if (searchQuery.equals("name")) {
        return productRepository.findByNameContainingIgnoreCase(searchValue);
      } else if (searchQuery.equals("category")) {
        return productRepository.findByCategoryContainingIgnoreCase(searchValue);
      } else {
        throw new RuntimeException("Invalid search query!");
      }
    }
  }

  public Optional<Product> getProductById(Long productId) {
    return productRepository.findById(productId);
  }

  // POST
  public Product addProduct(@RequestBody Product newProduct) {
    if (productRepository.findById(newProduct.getId()).isPresent()) {
      try {
        throw new Exception("Product by this ID already exists!");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return productRepository.save(newProduct);
  }

  // PUT
//  public Product updateProduct(Long productId, @RequestBody Product updatedProduct) {
//
//    Optional<Product> existingProductOptional = productRepository.findById(productId);
//
//    if (existingProductOptional.isEmpty()) {
//      try {
//        throw new Exception(STR."Product with ID \{productId} not found");
//      } catch (Exception e) {
//        throw new RuntimeException(e);
//      }
//    }
//
//    Product existingProduct = existingProductOptional.get();
//    if (!existingProduct.getId().equals(updatedProduct.getId())) {
//      throw new IllegalArgumentException("Provided ID in request body does not match existing product ID!");
//    }
//
//    return productRepository.save(updatedProduct);
//
//  }

  // DEL
  public void deleteProduct(Long productId) {
    if (!productRepository.existsById(productId)) {
      throw new RuntimeException("Product by that ID does not exist");
    }
    productRepository.deleteById(productId);
  }
}
