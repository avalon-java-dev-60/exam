package ejb;

import database.DBParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SelectBean {

    @EJB
    DBParameterFacade parameter;

    public List<DBParameter> findAll() {
        return parameter.findAll();
    }

    public List<DBParameter> findTemplate(String template) {
        String dbTemplate = "%" + template + "%";
        return parameter.findTemplate(dbTemplate);
    }

    public List<DBParameter> findInterval(String begin, String end) {
        int intBegin = Integer.parseInt(begin);
        int intEnd = Integer.parseInt(end);
        return parameter.findInterval(intBegin, intEnd);
    }
}
