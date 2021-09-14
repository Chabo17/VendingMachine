/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Items;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chadb
 */
public interface VendingMachineDao {
    
     List<Items> inventory = new ArrayList<>();
     
     public void buyItem();
     
     public void checkCost();
     
     public void checkQuantity();
     
    public void returnChange();
    
    public List<Items> getAllItems();
    
    public void cancelOrder(); 
 
       
}