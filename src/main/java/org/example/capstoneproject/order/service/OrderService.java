package org.example.capstoneproject.order.service;

import org.aspectj.weaver.ast.Or;
import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.order.dto.Order;
import org.example.capstoneproject.order.exception.OrderNotFoundException;
import org.example.capstoneproject.product.exception.ProductNotFoundException;

import java.util.List;

public interface OrderService {
    public void buyNow(int cusId, int prodId, int prodQuantity) throws ProductNotFoundException, CustomerNotFoundException;

    public void orderFromCart(int cusId) throws CustomerNotFoundException, ProductNotFoundException;
    public void cancelOrder(int cusId) throws OrderNotFoundException, CustomerNotFoundException;
    public List<Order> findAll();
    public Order getOrderById(int cusId);
}
