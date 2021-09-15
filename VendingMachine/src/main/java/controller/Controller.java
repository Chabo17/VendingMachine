/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VendingMachineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import serviceLayer.ServiceLayer;
import serviceLayer.VendingMachineInventoryValidationException;
import serviceLayer.VendingMachinePurchaseValidationException;
import ui.VendingMachineView;

/**
 *
 * @author chadb
 */
@Component
public class Controller {
    
    private VendingMachineView view;
    //private VendingMachineDao dao;
    private ServiceLayer service;
    @Autowired
    public Controller(VendingMachineView view, ServiceLayer service){
        this.view = view;
        this.service = service;
    }
    
    public void run() throws VendingMachinePurchaseValidationException, VendingMachineInventoryValidationException{

        boolean running = true;
        
        while(running){
            getItems();
            int choice = view.printOptions(service.getPersonBalance());
            switch (choice){ 
                case 1:
                    buyItem(view.buyItem());
                    break;
                case 2:
                    insertMoney(view.insertCoins());
                    break;
                case 3:
                    exitVendingMachine();
                    running = false;
                    break;
            }
        }
    }
    
   public void insertMoney(double insertedBalance){
        service.setPersonBalance(insertedBalance);
//       dao.setPersonBalance(view.insertCoins());
   }
    
    public void getItems(){
        view.getAllItems(service.getAllItems());
        
    }
    
    public void buyItem(int Index) throws VendingMachinePurchaseValidationException, VendingMachineInventoryValidationException{
     
        switch (service.buyItem(Index)){
            case -1: 
                view.buyBanner("Not enough Money");
                break;
            case 0:
                view.buyBanner("Not enough Stock");
                break;
            default:
                view.buyBanner("Item Purchased");
        }
            
    }
    
    public void exitVendingMachine(){
        service.returnChange();
        view.returnChange(service.returnChange());
        //view.returnChange(dao.returnChange());
    }
}
