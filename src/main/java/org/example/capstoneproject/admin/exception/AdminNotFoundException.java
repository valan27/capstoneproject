package org.example.capstoneproject.admin.exception;

public class AdminNotFoundException extends Exception{
    private int adId;
    public AdminNotFoundException(){

    }
    public AdminNotFoundException(int adId){
        this.adId=adId;
    }
    public String toString(){
        return "Admin not found "+adId;
    }
}
