package com.nina.freshGoodiesV2.service;

import com.nina.freshGoodiesV2.entity.Product;
import com.nina.freshGoodiesV2.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Log
public class ProductService {


  private final ProductRepository productRepository;

  public  List<Product> getProduct(String searchProduct, String searchValue) {
    if (searchProduct == null && searchValue == null) {
      return productRepository.findAll();
    } else {
      return productRepository.findByNameContainingOrCategoryContainingIgnoreCase(searchProduct, searchValue);
    }
  }

  public Optional<Product> getProductById(Long productId) {
    return productRepository.findById(productId);
  }

  public Product addProduct(@RequestBody Product newProduct) {
    return productRepository.save(newProduct);
  }
}
