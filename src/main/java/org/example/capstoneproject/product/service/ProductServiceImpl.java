package org.example.capstoneproject.product.service;

import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.product.dto.Product;
import org.example.capstoneproject.product.exception.ProductNotFoundException;
import org.example.capstoneproject.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;
    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(int prodId, Product product) {
        if(productRepo.existsById(prodId)) {
            product.setProdId(prodId);
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public void deleteById(int prodId) {
        productRepo.deleteById(prodId);
    }

    @Override
    public Product findById(int prodId) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(prodId);
        if(product.isEmpty()){
            throw new ProductNotFoundException(prodId);
        }
        return product.get();

    }

    @Override
    public List<Product> findByProdName(String prodName) {
        return productRepo.findByProdName(prodName);
    }

    @Override
    public List<Product> findByProdCategory(String prodCategory) {
        return productRepo.findByProdCategory(prodCategory);
    }

    @Override
    public List<Product> findByProdPrice(double prodPrice) {
        return productRepo.findByProdPrice(prodPrice);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
