/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.ejb.Stateless;

/**
 *
 * @author Ella
 */

public class Notification {
    private String message;
    private String status;
    
    public Notification(String message, String status) {
        this.message = message;
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getStatus() {
        return status;
    }
}
