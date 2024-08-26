package org.example.capstoneproject.product.repo;

import org.example.capstoneproject.product.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByProdName(String prodName);
    List<Product> findByProdCategory(String prodCategory);
    List<Product> findByProdPrice(double prodPrice);
}
