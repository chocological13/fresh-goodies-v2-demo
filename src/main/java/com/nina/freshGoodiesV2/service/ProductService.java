package com.nina.freshGoodiesV2.service;

import com.nina.freshGoodiesV2.entity.Product;
import com.nina.freshGoodiesV2.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {


  private final ProductRepository productRepository;

  public String doesItRun() {
    List<Product> productList = productRepository.findAll();
    if (productList != null) {
      return "Ayeeeeee";
    } else {
      return "No products yet";
    }
  }
}
