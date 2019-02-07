package beans;

import database.Params;
import database.ParamsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ella
 */
@Stateless
public class SelectBean implements SelectBeanLocal {
    
    @EJB
    ParamsFacade params;

    @Override
    public List<Params> findAll(long id) {
        return params.findAllByUser(id);
    }

    @Override
    public List<Params> findByPattern(String pattern, long id) {
        String SQLpattern = "%" + pattern + "%";
        return params.findByPattern(SQLpattern, id);
    }

    @Override
    public List<Params> findByInterval(int start, int end, long id) {
        return params.findByInterval(start, end, id);
    }
}
