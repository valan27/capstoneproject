package org.example.capstoneproject.order.dao;


import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.order.dto.Order;
import org.example.capstoneproject.order.exception.OrderNotFoundException;
import org.example.capstoneproject.product.exception.ProductNotFoundException;

public interface OrderDao {
    public void buyNow(int cusId, int prodId, int prodQuantity) throws ProductNotFoundException, CustomerNotFoundException;
    public void orderFromCart(int cusId) throws CustomerNotFoundException, ProductNotFoundException;
    public void cancelOrder(int cusId) throws CustomerNotFoundException, OrderNotFoundException;
    public Order getOrderById(int cusId);
}
