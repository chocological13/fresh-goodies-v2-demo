package com.nina.freshGoodiesV2.product.service.impl;

import com.nina.freshGoodiesV2.product.entity.Product;
import com.nina.freshGoodiesV2.product.repository.ProductRepository;
import com.nina.freshGoodiesV2.product.service.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  @Override
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

  @Override
  public Optional<Product> getProductById(Long productId) {
    return productRepository.findById(productId);
  }

  // POST
  @Override
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
  @Override
  public Product updateProduct(Long productId, @RequestBody Product updatedProduct) {

    Optional<Product> existingProductOptional = productRepository.findById(productId);

    if (existingProductOptional.isEmpty()) {
      throw new RuntimeException("Product with that ID not found");
    }

    Product existingProduct = existingProductOptional.get();
    if (!existingProduct.getId().equals(updatedProduct.getId())) {
      throw new IllegalArgumentException("Provided ID in request body does not match existing product ID!");
    }

    return productRepository.save(updatedProduct);

  }

  // DEL
  @Override
  public void deleteProduct(Long productId) {
    if (!productRepository.existsById(productId)) {
      throw new RuntimeException("Product by that ID does not exist");
    }
    productRepository.deleteById(productId);
  }
}
