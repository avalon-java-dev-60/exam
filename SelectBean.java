/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author MultatulyIM
 */
@Stateless
public class SelectBean implements SelectBeanLocal {

    @Override
    public ArrayList<String> selectAll() {
        return null;
    }

    @Override
    public String selectOneRec(String name) {
       return null; 
    }

    @Override
    public ArrayList<String> selectAllPatt() {
        return null;
    }

}
