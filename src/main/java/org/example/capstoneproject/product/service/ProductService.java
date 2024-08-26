package org.example.capstoneproject.product.service;

import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.product.dto.Product;
import org.example.capstoneproject.product.exception.ProductNotFoundException;
import org.example.capstoneproject.product.repo.ProductRepo;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public Product updateProduct(int prodId, Product product);
    public void deleteById(int prodId);
    public Product findById(int prodId) throws ProductNotFoundException;
    public List<Product> findByProdName(String prodName)throws ProductNotFoundException;
    public List<Product> findByProdCategory(String prodCategory)throws ProductNotFoundException;
    public List<Product> findByProdPrice(double prodPrice)throws ProductNotFoundException;
    public List<Product> findAll();
}
