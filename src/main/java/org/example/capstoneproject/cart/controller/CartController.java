package org.example.capstoneproject.cart.controller;

import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.cart.exception.CartNotFoundException;
import org.example.capstoneproject.cart.repo.CartRepo;
import org.example.capstoneproject.cart.service.CartService;
import org.example.capstoneproject.cartline.dto.CartLine;

import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.customer.service.CustomerService;
import org.example.capstoneproject.order.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/shop/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public void addToCart(@RequestParam("prodId")int prodId,@RequestParam("cusId")int cusId){
        cartService.addCart(cusId,prodId);
    }

    @PutMapping("/update")
    public String updateCart(@RequestParam("prodId")int prodId,@RequestParam("cusId")int cusId){
        return cartService.updateCart(cusId,prodId);
    }

    @GetMapping("/getCartById")
    public Cart getCartById(@RequestParam("cusId")int cusId) throws CartNotFoundException {
        return cartService.getCartById(cusId);
    }
    @GetMapping("/getAllCarts")
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @DeleteMapping("/removeAllCart")
    public String removeAllCart(@RequestParam("cusId")int cusId){
        return cartService.removeAllCart(cusId);

    }


}
