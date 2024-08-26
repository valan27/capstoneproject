package org.example.capstoneproject.order.repo;

import org.example.capstoneproject.order.dao.OrderDao;
import org.example.capstoneproject.order.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer>, OrderDao {
}
