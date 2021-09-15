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
     
    public void buyItem(int indexOfItem);
     
    public double checkCost(int indexOfItem);
     
    public int checkQuantity(int indexOfItem);
     
    public int[] returnChange();
    
    public List<Items> getAllItems();
    
    public void cancelOrder(); 

    public void setPersonBalance(double insertCoins);
     
       
}
