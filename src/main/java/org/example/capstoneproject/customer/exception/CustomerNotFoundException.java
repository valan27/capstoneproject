package org.example.capstoneproject.customer.exception;

import org.example.capstoneproject.customer.repo.CustomerRepo;

public class CustomerNotFoundException extends Exception{
    private int cusId;
    public CustomerNotFoundException(){

    }
    public CustomerNotFoundException(int cusId){
        this.cusId=cusId;
    }

    public CustomerNotFoundException(String s) {
    }

    public String toString(){
        return "Customer not found "+cusId;
    }
}
