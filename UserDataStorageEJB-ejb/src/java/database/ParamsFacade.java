package database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 *
 * @author Ella
 */
@Stateless
public class ParamsFacade extends AbstractFacade<Params> {

    private Users user;

    public ParamsFacade() {
        super(Params.class);
        user = new Users();
    }

    public Params findParam(String name, long id) {
        user.setId(id);
        try {
            return (Params) manager
                    .getNamesQuery("Params.findByName")
                    .setParameter("name", name)
                    .setParameter("user_id", user)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Params> findByPattern(String pattern, long id) {
        user.setId(id);
        try {
            return manager
                    .getNamesQuery("Params.findByPattern")
                    .setParameter("pattern", pattern)
                    .setParameter("user_id", user)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return null;
        }
    }

    public List<Params> findAllByUser(long id) {
        user.setId(id);
        try {
            return manager
                    .getNamesQuery("Params.findAllByUser")
                    .setParameter("user_id", user)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return null;
        }
    }

    public List<Params> findByInterval(int start, int end, long id) {
        user.setId(id);
        try {
            return manager
                    .getNamesQuery("Params.findByRange")
                    .setParameter("min_value", start)
                    .setParameter("max_value", end)
                    .setParameter("user_id", user)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return null;
        }
    }

    public boolean addParam(String name, int value, long id) {
        Params existedParam = findParam(name, id);
        user.setId(id);
        if (existedParam == null) {
            try {
                Params param = (Params) getEntityClass().newInstance();
                param.setName(name);
                param.setValue(value);
                param.setUserId(user);
                try {
                    create(param);
                    return true;
                } catch (PersistenceException pe) {
                    pe.printStackTrace(System.err);
                    return false;
                }
            } catch (InstantiationException | IllegalAccessException ie) {
                ie.printStackTrace(System.err);
                return false;
            }
        } else {
            return updateParam(existedParam, value);
        }
    }

    public boolean updateParam(Params param, int value) {
        param.setValue(value);
        try {
            edit(param);
            return true;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return false;
        }
    }

    public boolean deleteParam(String name, long id) {
        Params param = findParam(name, id);
        if (param != null) {
            try {
                remove(param);
                return true;
            } catch (PersistenceException pe) {
                pe.printStackTrace(System.err);
                return false;
            }
        } else {
            return false;
        }
    }
}
