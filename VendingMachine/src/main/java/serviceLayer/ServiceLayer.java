/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dto.Items;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public interface ServiceLayer {
        List<Items> inventory = new ArrayList<>();
     
    public int buyItem(int indexOfItem) throws VendingMachinePurchaseValidationException, VendingMachineInventoryValidationException;
     
    public double checkCost(int indexOfItem);
     
    public int checkQuantity(int indexOfItem);
     
    public int[] returnChange();
    
    public List<Items> getAllItems();
    
    public void cancelOrder(); 

    public void setPersonBalance(double insertCoins);
    public double getPersonBalance();
}
