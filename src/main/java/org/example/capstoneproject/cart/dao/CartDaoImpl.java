package org.example.capstoneproject.cart.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.cartline.dto.CartLine;
import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.product.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addToCart(int cusId, int prodId) {

        Customer customer = em.find(Customer.class, cusId);
        Cart cart = customer.getCart();
        if (cart != null) {
            Product p1 = em.find(Product.class, prodId);
            List<CartLine> cp = cart.getCartLineProducts();
            boolean exist = false;
            int cpi = 0;
            for (CartLine ce : cp) {
                if (ce.getProduct() == p1) {
                    cpi = ce.getCartLineId();
                    exist = true;
                    break;
                }
            }
            if (exist) {
                for (CartLine cd : cp) {
                    if (cd.getCartLineId() == cpi) {
                        cd.setTotalPrice(cd.getTotalPrice() + cd.getProdPrice());
                        cd.setProdQuantity(cd.getProdQuantity() + 1);
                    }
                }
            } else {
                CartLine cd = new CartLine();
                cd.setProduct(p1);
                cd.setProdQuantity(1);
                cd.setTotalPrice(p1.getProdPrice());
                cd.setProdPrice(p1.getProdPrice());
                cart.getCartLineProducts().add(cd);
                em.persist(cd);
            }
            em.persist(cart);
            customer.setCart(cart);
            em.persist(customer);

        } else {
            Cart cart2 = new Cart();

            cart2.setCustomer(customer);
            Product p1 = em.find(Product.class, prodId);
            List<CartLine> cp = new ArrayList<>();
            boolean exist = false;
            int cpi = 0;
            CartLine cd = new CartLine();
            cd.setProduct(p1);
            cd.setProdQuantity(1);
            cd.setTotalPrice(p1.getProdPrice());
            cd.setProdPrice(p1.getProdPrice());
            cp.add(cd);
            em.persist(cd);
            cart2.setCartLineProducts(cp);
            em.persist(cart2);
            customer.setCart(cart2);
            em.persist(customer);
        }


    }

    @Override
    @Transactional
    public String updateCart(int cusId, int prodId) {
        Customer customer = em.find(Customer.class, cusId);
        Cart cart = customer.getCart();
        if (cart != null) {
            Product p1 = em.find(Product.class, prodId);
            List<CartLine> cp = cart.getCartLineProducts();
            boolean exist = false;
            int cpi = 0;
            for (CartLine ce : cp) {
                if (ce.getProduct() == p1) {
                    cpi = ce.getCartLineId();
                    exist = true;
                    break;
                }
            }
            if (exist) {
                for (CartLine cd : cp) {
                    if (cd.getCartLineId() == cpi) {
                        if (cd.getProdQuantity() > 0) {
                            cd.setTotalPrice(cd.getTotalPrice() - cd.getProdPrice());
                            cd.setProdQuantity(cd.getProdQuantity() - 1);
                        } else {
                            String sql = "DELETE FROM cart_line where quant<=0";
                            Query q = em.createNativeQuery(sql);
                            q.executeUpdate();
                            return "your prouduct quantity in cartline is already zero";
                        }
                    }
                }

                return "updated successfully";
            }
            customer.setCart(cart);
            em.persist(customer);

        }
        return "cart not found";

    }

    @Override
    @Transactional
    public Cart getCartById(int cusId) {
        Customer cust = em.find(Customer.class, cusId);
        Cart cart = cust.getCart();
        return cart;
    }

    @Override
    @Transactional
    public String removeAllCart(int cusId) {
        Customer customer = em.find(Customer.class, cusId);
        Cart cart = customer.getCart();
        if (cart != null) {
            List<CartLine> cp = cart.getCartLineProducts();
            boolean exist = true;
//            int cpi = 0;
            for (CartLine ce : cp) {
                if (ce.getProduct() == null) {
                    exist = false;
                    break;

                }
            }
            if (exist) {

//                 em.remove(cart);
                String sql="DELETE FROM cart_line WHERE cart_line_id = " + cart.getCartId();
                Query q=em.createNativeQuery(sql);
                q.executeUpdate();
                return "your cart is empty";
            }
        }

        return "your cart is already empty";
        }


}





