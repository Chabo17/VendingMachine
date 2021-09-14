/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author chadb
 */
public class Items {
    private String name;
    private double price;
    private int count;
    
    public Items(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getCount(){
        return count;
    }
    
    public void decreaseCount(){
        count--;
    }
    
}
