/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import parambase.ParametersFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ella
 */
@Stateless
public class UpdateBean implements UpdateBeanLocal {

    @EJB
    ParametersFacade param;

    @Override
    public boolean add(String name, String value) {
        int valueInt = Integer.parseInt(value);
            return param.addParam(name, valueInt);
    }

    @Override
    public boolean delete(String name) {
        return param.deleteParam(name);
    }
}