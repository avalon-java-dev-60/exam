/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author MultatulyIM
 */
@Local
public interface SelectBeanLocal {
    public ArrayList<String> selectAll();
    public String selectOneRec(String name);
    public ArrayList<String> selectAllPatt();
    
}
