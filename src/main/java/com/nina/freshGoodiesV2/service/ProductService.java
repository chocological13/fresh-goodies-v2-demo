package com.nina.freshGoodiesV2.service;

import com.nina.freshGoodiesV2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;


}
