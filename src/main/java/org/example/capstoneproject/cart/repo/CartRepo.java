package org.example.capstoneproject.cart.repo;

import org.example.capstoneproject.cart.dao.CartDao;
import org.example.capstoneproject.cart.dto.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>, CartDao {

}
