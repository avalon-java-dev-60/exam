package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UpdateBean {

    @EJB
    DBParameterFacade DBparameter;

    public boolean addNew(String param, String value) throws InstantiationException {
        int intValue = Integer.parseInt(value);
        return DBparameter.addNew(param, intValue);
    }

    public boolean delete(String param) throws InstantiationException {
        return DBparameter.delete(param);
    }

}
