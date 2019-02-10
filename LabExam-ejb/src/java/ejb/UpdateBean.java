package ejb;

import database.DBParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
//@LocalBean
public class UpdateBean {

    @EJB
    DBParameterFacade DBparameter;

    public boolean addNew(String param, String value) throws InstantiationException {
        int intvalue = Integer.parseInt(value);
        return DBparameter.addNew(param, intvalue);
    }

    public  boolean delete(String param) {
        return  DBparameter.delete(param);
    }

}
