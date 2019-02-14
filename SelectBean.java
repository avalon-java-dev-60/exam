/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import database.Parameter;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author MultatulyIM
 */
@Stateless
public class SelectBean implements SelectBeanLocal {

    @Override
    public ArrayList<Parameter> selectAll() {
        return null;
    }

    @Override
    public Parameter selectOneRec(String name) {
       return null; 
    }

    @Override
    public ArrayList<Parameter> selectAllPatt() {
        return null;
    }

}
