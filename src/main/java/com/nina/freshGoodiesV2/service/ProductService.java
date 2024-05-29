package com.nina.freshGoodiesV2.service;

import com.nina.freshGoodiesV2.entity.Product;
import com.nina.freshGoodiesV2.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Log
public class ProductService {


  private final ProductRepository productRepository;

//  public String doesItRun() {
//    List<Product> productList = productRepository.findAll();
//    if (productList != null) {
//      return "Ayeeeeee";
//    } else {
//      return "No products yet";
//    }
//  }

  public List<Product> getAllProduct() {
    return productRepository.findAll();
  }

  public Product addProduct(@RequestBody Product newProduct) {
    return productRepository.save(newProduct);
  }
}
