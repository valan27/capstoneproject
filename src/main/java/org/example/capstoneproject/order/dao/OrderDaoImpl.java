package org.example.capstoneproject.order.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.cartline.dto.CartLine;
import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.order.dto.Order;
import org.example.capstoneproject.order.exception.OrderNotFoundException;
import org.example.capstoneproject.orderline.dto.OrderLine;
import org.example.capstoneproject.product.dto.Product;
import org.example.capstoneproject.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{

    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void buyNow(int cusId, int prodId, int prodQuantity) throws ProductNotFoundException, CustomerNotFoundException {
        Customer cust = em.find(Customer.class,cusId);
        Product prod = em.find(Product.class,prodId);
        if(prod.getProdQuantity()<prodQuantity)throw new ProductNotFoundException("Product on low stock"+prodId);
        if(cust==null){
            throw new CustomerNotFoundException("No customer found:"+cusId);
        }
        if(prod==null){
            throw new ProductNotFoundException("No product found:"+prodId);
        }
        Order order = new Order();
        order.setCustomer(cust);
        List<OrderLine> orderLineList = new ArrayList<>();
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(prod);
        orderLine.setOrLinePrice(prod.getProdPrice());
        orderLine.setOrLineProdQuantity(prodQuantity);
        orderLine.setOrLineStatus("Ordered");
        orderLine.setOrLineDate(LocalDate.now());
        orderLine.setOrLineTotPrice(prod.getProdPrice()*prodQuantity);

        em.persist(orderLine);
        orderLineList.add(orderLine);
        order.setOrLineList(orderLineList);
        order.setOrTotPrice(orderLine.getOrLineTotPrice());
        em.persist(order);
        int prodQuan = prod.getProdQuantity()-prodQuantity;
        prod.setProdQuantity(prodQuan);
        em.persist(prod);
        cust.setOrderTab(order);
        em.persist(cust);
    }

    @Override
    @Transactional
    public void orderFromCart(int cusId) throws CustomerNotFoundException, ProductNotFoundException {
        Customer cust = em.find(Customer.class,cusId);
        if(cust==null){
            throw new CustomerNotFoundException("Customer not found:"+cusId);
        }

        Cart cart = cust.getCart();
        if(cart==null){
            throw new ProductNotFoundException("Not cart found for this customer:"+cusId);
        }
        Order order = new Order();
        order.setCustomer(cust);
        List<OrderLine> orderLineList = new ArrayList<>();
        if(cart!=null){
            List<CartLine> cartLines=cart.getCartLineProducts();
            for(CartLine cartLine:cartLines){
                OrderLine orderLine = new OrderLine();
                orderLine.setProduct(cartLine.getProduct());
                orderLine.setOrLinePrice(cartLine.getProdPrice());
                orderLine.setOrLineProdQuantity(cartLine.getProdQuantity());
                orderLine.setOrLineStatus("Ordered");
                orderLine.setOrLineDate(LocalDate.now());
                orderLine.setOrLineTotPrice(cartLine.getTotalPrice());
                order.setOrTotPrice(order.getOrTotPrice()+orderLine.getOrLineTotPrice());

                em.persist(orderLine);
                orderLineList.add(orderLine);
//                int prod;
//                Product product = new Product();
//                prod = orderLine.getOrLineProdQuantity();
//                int prodQuan;
//                int prodId = orderLine.getProduct().getProdId();
//                if(prodId == product.getProdId()){
//                    prodQuan = product.getProdQuantity()-prod;
//                    product.setProdQuantity(prodQuan);
//                    em.persist(product);
//                }


            }
            order.setOrLineList(orderLineList);
            em.persist(order);
            cust.setOrderTab(order);
            em.persist(cust);

            cart.getCartLineProducts().clear();
            em.persist(cart);
        }

    }

    @Override
    @Transactional
    public void cancelOrder(int cusId) throws CustomerNotFoundException, OrderNotFoundException {
        Customer cust = em.find(Customer.class,cusId);
        if(cust == null){
            throw new CustomerNotFoundException("No customer with id"+cusId);
        }
        Order order = cust.getOrderTab();
        if(order==null){
            throw new OrderNotFoundException("No order found with this customer:"+cusId);
        }
        if(order!=null){
            cust.setOrderTab(null);
        }
        em.persist(cust);
    }

    @Override
    @Transactional
    public Order getOrderById(int cusId) {
        Customer cust = em.find(Customer.class,cusId);
        Order order = cust.getOrderTab();
        return order;
    }

}
