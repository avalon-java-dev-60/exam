package ejb;

import database.DBParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class SelectBean {

    @EJB
    static DBParameterFacade parameter;

    List<DBParameter> findAll() {

        return (List<DBParameter>) parameter.findAll();
    }

    List<DBParameter> findTemplate(String template) {
        String dbTemplate = "%" + template + "%";
        return (List<DBParameter>) parameter.findTemplate(dbTemplate);
    }

    List<DBParameter> findInterval(int begin, int end) {
        return (List<DBParameter>) parameter.findInterval(begin, end);
    }
}
