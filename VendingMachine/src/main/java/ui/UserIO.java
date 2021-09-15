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
public interface UserIO {
    
    void print(String msg);
    
    int readInt(String prompt, int min, int max);
    
    int readInt(String prompt);
    
    double readDouble(String prompt);

    
    String readString(String prompt);
    
}
