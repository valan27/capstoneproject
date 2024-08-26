package org.example.capstoneproject.customer.controller;


import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/cusName/{cusName}")
    public List<Customer> findByCusName(@PathVariable("cusName") String cusName) throws CustomerNotFoundException {
        return customerService.findByCusName(cusName);
    }
    @GetMapping("/cusCity/{cusCity}")
    public List<Customer> findByCusCity(@PathVariable("cusCity")String cusCity) throws CustomerNotFoundException {
        return customerService.findByCusCity(cusCity);
    }
    @GetMapping("/cusPincode/{cusPincode}")
    public List<Customer> findByCusPinCode(@PathVariable("cusPinCode")int cusPinCode) throws CustomerNotFoundException {
        return customerService.findByCusPinCode(cusPinCode);
    }
    @GetMapping("/find/{cusId}")
    public Customer findById(@PathVariable("cusId")int cusId) throws CustomerNotFoundException {
        return customerService.findById(cusId);
    }

    @DeleteMapping("/delete/{cusId}")
    public void deleteById(@PathVariable("cusId")int cusId){
        customerService.deleteById(cusId);
    }

    @PutMapping("/update/{cusId}")
    public Customer updateCustomer(@PathVariable int cusId,@RequestBody Customer customer){
        return customerService.updateCustomer(cusId,customer);
    }
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
