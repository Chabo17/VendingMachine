/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Controller;
import dao.VendingMachineDao;
import dao.VendingMachineFileImpl;
import ui.UserIO;
import ui.UserIOConsoleImpl;
import ui.VendingMachineView;

/**
 *
 * @author chadb
 */
public class App {
    
    public static void main(String args[]){
        UserIO myIO = new UserIOConsoleImpl();
        VendingMachineDao myDao = new VendingMachineFileImpl();
        VendingMachineView myView = new VendingMachineView(myIO);
        Controller myController = new Controller(myView,myDao);
        myController.run();
    }
    
}
