package org.example.capstoneproject.order.exception;

public class OrderNotFoundException extends Exception{
    private int orId;
    public OrderNotFoundException(){

    }
    public OrderNotFoundException(int orId){
        this.orId=orId;
    }

    public OrderNotFoundException(String s) {
    }

    public String toString(){
        return "Order not found "+orId;
    }
}
