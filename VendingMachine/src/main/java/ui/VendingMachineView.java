/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author chadb
 */
import dto.Items;
import java.util.List;

/**
 *
 * @author chadb
 */
public class VendingMachineView {
    
    private UserIO io;
    
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    
    public int printOptions(){
        io.print("Main menu");
        io.print("1. Check Items");
        io.print("2. Buy Items");
        io.print("3. Insert Money");
        io.print("4. Exit");
        
        return io.readInt("Please select from the above choices.", 1, 4);
    }
    
    public void getAllItems(List<Items> Inv){
        io.print("=== Invitory ===");
        for (int i =0; i< Inv.size();i++){
            io.print(i + ": " + Inv.get(i).getName() + " -> $"  + Inv.get(i).getPrice());
      }
      io.readString("Please hit enter to continue.");
    }
    
    public int buyItem(){
        return io.readInt("Please enter the ID number of the requested item");
    }
    
    public int checkQuanity() {
        return io.readInt("Please enter the ID number of the requested item");

    } 
    
    public double insertCoins(){
        return io.readDouble("Please enter money ");
    }

//    public void returnChange(int[] changeArray) {
//    	io.print("Here is your change");
//        io.print("Dollars" + changeArray[0]);
//        io.print("Quarters" + changeArray[1]);
//        io.print("Dimes" + changeArray[2]);
//        io.print("Nickels" + changeArray[3]);
//    	
//    }
    
    public String cancelOrder() {
    	return io.readString("Leaving the vending machine");
    }
     
    public double checkCost() {
    	return io.readInt("Check cost of product");
    	
    }

    public void returnChange(int[] returnChange) {
    	io.print("Here is your change");
        io.print("Dollars" + returnChange[0]);
        io.print("Quarters" + returnChange[1]);
        io.print("Dimes" + returnChange[2]);
        io.print("Nickels" + returnChange[3]);
    }

}