package org.example.capstoneproject.cart.dao;

import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.cart.exception.CartNotFoundException;

public interface CartDao {
    public void addToCart(int cusId, int prodId);
    public String updateCart(int cusId, int prodId);
    public Cart getCartById(int cusId)throws CartNotFoundException;
    public String removeAllCart(int cusId);


}
