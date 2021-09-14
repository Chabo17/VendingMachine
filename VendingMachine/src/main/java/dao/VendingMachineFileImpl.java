/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Items;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chadb
 */
public class VendingMachineFileImpl implements VendingMachineDao{
    
    private final String INVENTORY = "INVENTORY.txt";
    public static final String DELIMITER = "::";
    
     List<Items> inventory = new ArrayList<>();
     double personBalance;

    @Override
    //Edge cases        
        //throw exception if insufficient balance (inventory[i].getPrice()>personBalance)
        //throw exception if quantity == 0
    public void buyItem(int indexOfItem) {
        //loadnventory();
        Items desiredItem = inventory.get(indexOfItem);
        desiredItem.decreaseCount();
        //personBalance -= desiredItem.getPrice();
        personBalance -= (desiredItem.getPrice());
        //  


//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public double checkCost(int indexOfItem) {       
        return inventory.get(indexOfItem).getPrice();
    }

    @Override
    public int checkQuantity(int indexOfItem) {
        return inventory.get(indexOfItem).getCount();
    }

    @Override
    public void returnChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Items> getAllItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private String marshallItem(Items item){
        String itemAsText = item.getName()+ DELIMITER;
        itemAsText += item.getPrice()+ DELIMITER;
        itemAsText += item.getCount()+ DELIMITER;
        return itemAsText;
    }
    
    private void writeLibrary() throws VendingMachineDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY));
        } catch (IOException e) {
            throw new VendingMachineDaoException(
                    "Could not save Vending Machine Inventory Data.", e);
        }

        String ItemAsText;

        for (Items currentItem : inventory) {
            // turn a Student into a String
            ItemAsText = marshallItem(currentItem);
            out.println(ItemAsText);
            out.flush();
        }
 
        out.close();
    }


    
    
}
