/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VendingMachineDao;
import ui.VendingMachineView;

/**
 *
 * @author chadb
 */
public class Controller {
    
    private VendingMachineView view;
    private VendingMachineDao dao;
    public Controller(VendingMachineView view, VendingMachineDao dao){
        this.view = view;
        this.dao = dao;
    }
    
    public void run(){

        boolean running = true;
        while(running){
            int choice = view.printOptions();
            switch (choice){
                case 1:
                    getItems();
                    break;
                case 2:
                    buyItem();
                    break;
                case 3:
                    insertMoney();
                    break;
                case 4:

                    running = false;
                    break;
            }
        }
    }
    
   public void insertMoney(){
       dao.setPersonBalance(view.insertCoins());
   }
    
    public void getItems(){
        view.getAllItems(dao.getAllItems());
        
    }
    
    public void buyItem(){
        dao.buyItem(view.buyItem());
    }
}
