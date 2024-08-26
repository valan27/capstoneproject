package org.example.capstoneproject.customer.service;

import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);

    }

    @Override
    public Customer updateCustomer(int cusId, Customer customer) {
        if(customerRepo.existsById(cusId)){
            customer.setCusId(cusId);
            return customerRepo.save(customer);
        }
        return null;
    }

    @Override
    public void deleteById(int cusId) {
        customerRepo.deleteById(cusId);
    }

    @Override
    public Customer findById(int cusId) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepo.findById(cusId);
        if(customer.isEmpty()){
            throw new CustomerNotFoundException(cusId);
        }
        return customer.get();
    }

    @Override
    public List<Customer> findByCusName(String cusName) {
        return customerRepo.findByCusName(cusName);
    }

    @Override
    public List<Customer> findByCusCity(String cusCity) {
        return customerRepo.findByCusCity(cusCity);
    }

    @Override
    public List<Customer> findByCusPinCode(int cusPinCode) {
        return customerRepo.findByCusPinCode(cusPinCode);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
