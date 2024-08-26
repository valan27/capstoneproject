package org.example.capstoneproject.cart.exception;

public class CartNotFoundException extends Exception{
    private int cartId;
    public CartNotFoundException(){

    }
    public CartNotFoundException(int cusId){
        this.cartId=cartId;
    }

    public CartNotFoundException(String s) {
    }

    public String toString(){
        return "Cart not found "+cartId;
    }
}
