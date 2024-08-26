package org.example.capstoneproject.order.controller;

import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.order.dto.Order;
import org.example.capstoneproject.order.exception.OrderNotFoundException;
import org.example.capstoneproject.order.service.OrderService;
import org.example.capstoneproject.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/orders")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/buyNow")
    public void buyNow(@RequestParam("cusId")int cusId,@RequestParam("prodId")int prodId,@RequestParam("prodQuantity")int prodQuantity) throws ProductNotFoundException, CustomerNotFoundException {
        orderService.buyNow(cusId,prodId,prodQuantity);
    }
    @PostMapping("orderFromCart")
    public void orderFromCart(@RequestParam("cusId")int cusId) throws CustomerNotFoundException, ProductNotFoundException {
        orderService.orderFromCart(cusId);
    }
    @DeleteMapping("/cancel")
    public void cancelOrder(@RequestParam("cusId")int cusId) throws OrderNotFoundException, CustomerNotFoundException {
        orderService.cancelOrder(cusId);
    }
    @GetMapping("/displayOrder")
    public List<Order> findAll(){
        return orderService.findAll();
    }
    @GetMapping("/findOrderById")
    public Order findOrderById(@RequestParam("cusId")int cusId){
        return orderService.getOrderById(cusId);
    }

}
