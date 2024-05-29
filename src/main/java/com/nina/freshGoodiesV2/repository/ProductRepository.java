package com.nina.freshGoodiesV2.repository;

import com.nina.freshGoodiesV2.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByNameContainingOrCategoryContainingIgnoreCase(String searchQuery, String searchValue);
}
