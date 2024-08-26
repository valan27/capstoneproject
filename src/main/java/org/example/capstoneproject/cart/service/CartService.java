package org.example.capstoneproject.cart.service;

import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.cart.exception.CartNotFoundException;
import org.example.capstoneproject.customer.dto.Customer;

import java.util.List;

public interface CartService {
    public void addCart(int cusId, int prodId);
    public void removeFromCart(int cartId);
    public List<Cart> removeCart(Cart cart);
    public List<Cart> getAllCarts();
    public String updateCart(int cusId, int prodId);
    public Cart getCartById(int cusId)throws CartNotFoundException;
    public String removeAllCart(int cusId);
}
