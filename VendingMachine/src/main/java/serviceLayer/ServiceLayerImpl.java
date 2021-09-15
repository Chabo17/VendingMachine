/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dao.Audit;
import dao.AuditImpl;
import dao.VendingMachineDao;
import dao.VendingMachineDaoException;
import dto.Items;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brian
 */
public class ServiceLayerImpl implements ServiceLayer {
    private VendingMachineDao dao;
    private Audit audit;

    public ServiceLayerImpl(VendingMachineDao dao, AuditImpl audit) {
        this.dao = dao;
        this.audit = audit;
    }
    
    @Override
    public int buyItem(int indexOfItem) throws VendingMachinePurchaseValidationException, VendingMachineInventoryValidationException{
        try{
                if(checkCost(indexOfItem) > dao.getPersonBalance())
            {
                throw new VendingMachinePurchaseValidationException("Not enough Money.");
            }
               
        }catch(VendingMachinePurchaseValidationException e){  
            return -1;
        }
        
        try{
            if(checkQuantity(indexOfItem) == 0 )
                {
                    throw new VendingMachineInventoryValidationException("Item is currently out of stock");
                }
        }catch(VendingMachineInventoryValidationException e){
            return 0;
        }
 
        dao.buyItem(indexOfItem);
        try {
            audit.writeAuditEntry(getItem(indexOfItem).getName() + " was purchased, remaining balance : " + getItem(indexOfItem).getCount());
            
            // dao.buyItem(indexOfItem);
        } catch (VendingMachineDaoException ex) {
            Logger.getLogger(ServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return 1;
    }

    @Override
    public double checkCost(int indexOfItem) {
       return dao.checkCost(indexOfItem);
    }

    @Override
    public int checkQuantity(int indexOfItem) {
        return dao.checkQuantity(indexOfItem);
    }

    @Override
    public int[]returnChange() {
             return dao.returnChange();
    }

    @Override
    public List<Items> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public void cancelOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPersonBalance(double insertCoins) {
        dao.setPersonBalance(insertCoins);
    }
    public double getPersonBalance(){
        return dao.getPersonBalance();
    }
    public Items getItem(int indexOfItem)
    {
        return dao.getAllItems().get(indexOfItem);
    }
}
