/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author MultatulyIM
 */
@Local
public interface UpdateBeanLocal {
    public String insertParameter(String name, int value) ;
    public String updateParameter(String name, int value);
    public String deleteParameter(String name);
    
    
    
}
