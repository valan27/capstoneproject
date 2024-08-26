package org.example.capstoneproject.customer.repo;

import org.example.capstoneproject.customer.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findByCusName(String cusName);
    List<Customer> findByCusCity(String cusCity);
    List<Customer> findByCusPinCode(int cusPinCode);
}
