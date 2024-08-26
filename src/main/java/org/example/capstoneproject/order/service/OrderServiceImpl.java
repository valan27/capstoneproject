package org.example.capstoneproject.order.service;

import jakarta.persistence.EntityManager;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.order.dto.Order;
import org.example.capstoneproject.order.exception.OrderNotFoundException;
import org.example.capstoneproject.order.repo.OrderRepo;
import org.example.capstoneproject.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private EntityManager em;
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void buyNow(int cusId, int prodId, int prodQuantity) throws ProductNotFoundException, CustomerNotFoundException {
        orderRepo.buyNow(cusId, prodId, prodQuantity);
    }

    @Override
    public void orderFromCart(int cusId) throws CustomerNotFoundException, ProductNotFoundException {
        orderRepo.orderFromCart(cusId);
    }

    @Override
    public void cancelOrder(int cusId) throws OrderNotFoundException, CustomerNotFoundException {
        orderRepo.cancelOrder(cusId);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(int cusId) {
        return orderRepo.getOrderById(cusId);
    }
}
