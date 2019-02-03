package beans;

import database.ParamsFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ella
 */
@Stateless
public class UpdateBean implements UpdateBeanLocal {

    @EJB
    ParamsFacade params;

    @Override
    public boolean add(String name, String value, long id) {
        int valueInt = Integer.parseInt(value);
            return params.addParam(name, valueInt, id);
    }

    @Override
    public boolean delete(String name, long id) {
        return params.deleteParam(name, id);
    }
}
