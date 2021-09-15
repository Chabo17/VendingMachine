/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Controller;
import dao.VendingMachineDao;
import dao.VendingMachineDaoException;
import dao.VendingMachineFileImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import serviceLayer.VendingMachineInventoryValidationException;
import serviceLayer.VendingMachinePurchaseValidationException;
import ui.UserIO;
import ui.UserIOConsoleImpl;
import ui.VendingMachineView;

/**
 *
 * @author chadb
 */
public class App {

   
    public static void main(String args[]) throws VendingMachineDaoException, VendingMachinePurchaseValidationException, VendingMachineInventoryValidationException{
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = 
           ctx.getBean("controller", Controller.class);
        controller.run();
//       AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
//        appContext.scan("app.App");
//        appContext.refresh();
//
//        Controller controller = appContext.getBean("controller", Controller.class);
//        controller.run();
    }
    
}
