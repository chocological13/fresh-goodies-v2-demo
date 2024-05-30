package com.nina.freshGoodiesV2.product.service;

import com.nina.freshGoodiesV2.product.entity.Product;
import com.nina.freshGoodiesV2.product.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {

  List<Product> getProduct(String searchQuery, String searchValue);

  Optional<Product> getProductById(Long productId);

  // POST
  Product addProduct(Product newProduct);

  // PUT
  Product updateProduct(Long productId, Product updatedProduct);

  // DEL
  void deleteProduct(Long productId);
}
