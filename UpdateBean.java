/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author MultatulyIM
 */
@Stateless
public class UpdateBean implements UpdateBeanLocal {

    @Override
    public String insertParameter(String name, int value) {
        return null;
    }

    @Override
    public String updateParameter(String name, int value) {
        return null;
    }

    @Override
    public String deleteParameter(String name) {
        return null;
    }

    
}
