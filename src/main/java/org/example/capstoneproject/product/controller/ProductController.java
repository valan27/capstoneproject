package org.example.capstoneproject.product.controller;



import org.example.capstoneproject.product.dto.Product;
import org.example.capstoneproject.product.exception.ProductNotFoundException;
import org.example.capstoneproject.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();

    }

    @GetMapping("/find/{prodId}")
    public Product findById(@PathVariable("prodId") int prodId) throws ProductNotFoundException {
        return productService.findById(prodId);
    }

    @DeleteMapping("/delete/{prodId}")
    public void deleteById(@PathVariable("prodId") int prodId) {
        productService.deleteById(prodId);
    }

    @PutMapping("/update/{prodId}")
    public Product updateProduct(@PathVariable int prodId, @RequestBody Product product) {
        return productService.updateProduct(prodId, product);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);


    }

    @GetMapping("/prodName{prodName}")
    public List<Product> findByProdName(@PathVariable("prodName") String prodName) throws ProductNotFoundException {
        return productService.findByProdName(prodName);
    }

    @GetMapping("/prodCategory{prodCategory}")
    public List<Product> findByProdCategory(@PathVariable("prodCategory") String prodCategory) throws ProductNotFoundException {
        return productService.findByProdCategory(prodCategory);
    }

    @GetMapping("/priceGreaterThan{prodPrice}")
    public List<Product> findByProdPrice(@PathVariable("prodPrice") double prodPrice) throws ProductNotFoundException {
        return productService.findByProdPrice(prodPrice);
    }


}