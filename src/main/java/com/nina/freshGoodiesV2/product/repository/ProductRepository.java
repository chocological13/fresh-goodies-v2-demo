package com.nina.freshGoodiesV2.product.repository;

import com.nina.freshGoodiesV2.product.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByNameContainingIgnoreCase(String searchQuery);
  List<Product> findByCategoryContainingIgnoreCase(String searchQuery);
}
