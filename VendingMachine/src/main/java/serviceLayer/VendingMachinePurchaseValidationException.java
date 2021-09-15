/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

/**
 *
 * @author Brian
 */
public class VendingMachinePurchaseValidationException extends Exception{

    public VendingMachinePurchaseValidationException(String message) {
        super(message);
    }

    public VendingMachinePurchaseValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
