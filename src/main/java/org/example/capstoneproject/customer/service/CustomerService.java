package org.example.capstoneproject.customer.service;

import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public Customer updateCustomer(int cusId, Customer customer);
    public void deleteById(int cusId);
    public Customer findById(int cusId) throws CustomerNotFoundException;
    public List<Customer> findByCusName(String cusName)throws CustomerNotFoundException;
    public List<Customer> findByCusCity(String cusCity)throws CustomerNotFoundException;
    public List<Customer> findByCusPinCode(int cusPinCode)throws CustomerNotFoundException;
    public List<Customer> findAll();


}
