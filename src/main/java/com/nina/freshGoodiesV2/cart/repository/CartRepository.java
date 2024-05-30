package com.nina.freshGoodiesV2.cart.repository;

import com.nina.freshGoodiesV2.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
