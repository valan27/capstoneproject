package org.example.capstoneproject.product.exception;

public class ProductNotFoundException extends Exception{
    private int prodId;
    public ProductNotFoundException(){

    }
    public ProductNotFoundException(int prodId){
        this.prodId=prodId;
    }

    public ProductNotFoundException(String s) {
    }

    public String toString(){
        return "Product not found "+prodId;
    }
}
