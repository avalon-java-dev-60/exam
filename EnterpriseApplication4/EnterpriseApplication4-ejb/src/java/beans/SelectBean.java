/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.ejb.EJB;
import parambase.Parameters;
import java.util.List;
import parambase.ParametersFacade;




/**
 *
 * @author Ella
 */
@Stateless
public class SelectBean implements SelectBeanLocal {
    
    @EJB
    ParametersFacade params;

    @Override
    public List<Parameters> findAll() {
        return params.findAllParams();
    }

    @Override
    public List<Parameters> findByPattern(String pattern) {
        String SQLpattern = "%" + pattern + "%";
        return params.findByName(SQLpattern);
    }

    @Override
    public List<Parameters> findByInterval(int start, int end) {
        return params.findByValue(start, end);
    }
}