package com.nina.freshGoodiesV2.repository;

import com.nina.freshGoodiesV2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
