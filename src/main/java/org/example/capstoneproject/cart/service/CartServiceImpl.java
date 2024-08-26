package org.example.capstoneproject.cart.service;

import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.cart.exception.CartNotFoundException;
import org.example.capstoneproject.cart.repo.CartRepo;
import org.example.capstoneproject.customer.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepo cartRepo;
    @Override
    public void addCart(int cusId,int prodId) {
         cartRepo.addToCart(cusId,prodId);
    }



    @Override
    public void removeFromCart(int cartId) {
        cartRepo.deleteById(cartId);
    }

    @Override
    public List<Cart> removeCart(Cart cart) {
        return null;
    }


    @Override
    public List<Cart> getAllCarts() {

        return cartRepo.findAll();
    }

    @Override
    public String updateCart(int cusId, int prodId) {
        return cartRepo.updateCart(cusId,prodId);
    }

    @Override
    public Cart getCartById(int cusId) throws CartNotFoundException {
        return cartRepo.getCartById(cusId);
    }

    @Override
    public String removeAllCart(int cusId) {
        return cartRepo.removeAllCart(cusId);
    }


}
