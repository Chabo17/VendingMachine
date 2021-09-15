/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Items;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public int[] returnChange() {
        double change = personBalance;
      
        int[] assortedChange = new int[5];
        change*=100;
        int intChange = (int)change;
        
        assortedChange[0] = intChange/100;
        intChange %=100;
        assortedChange[1] = intChange/25;
        intChange%=25;
        assortedChange[2]=intChange/10;
        intChange%=10;
        assortedChange[3] = intChange/5;
        intChange%=5;
        assortedChange[4] = intChange/1;
        intChange%=1;
        
        return assortedChange;
    }

    @Override
    public List<Items> getAllItems() {
        return inventory;
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

    private Items unMarshallItem(String itemAsText)
    {
        String[] tokens = itemAsText.split(DELIMITER);
        Items itemFromFile = new Items(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[2]));
        return itemFromFile;
    }
    
    private void readLibrary() throws VendingMachineDaoException{
        Scanner sc;
        String itemAsText; 
        Items itemFromText; 
        
        try{
            sc = new Scanner(new BufferedReader(new FileReader(INVENTORY)));
        }catch(FileNotFoundException e)
        {
            throw new VendingMachineDaoException("Could not retrieve Vending Machine Inventory Data", e);
        }
         
        while(sc.hasNext())
        {
            itemAsText = sc.nextLine();
            itemFromText =  unMarshallItem(itemAsText);
            inventory.add(itemFromText);
        }
        sc.close();
    }
    
    
}
