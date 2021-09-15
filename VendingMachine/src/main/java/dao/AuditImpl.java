/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Brian
 */
public class AuditImpl implements Audit{
    private static final String AUDIT = "AUDIT.txt"; 
    @Override
    public void writeAuditEntry(String entry) throws VendingMachineDaoException {
       PrintWriter out;
       try{
           out = new PrintWriter(new FileWriter(AUDIT, true));
       }catch(IOException e)
       {
           throw new VendingMachineDaoException("Could not gather Audit Information ", e);
       }
       LocalDateTime timestamp = LocalDateTime.now();
       out.println(timestamp.toString() + " : " + entry);
       out.flush();
    }
    
}
