package ejb;

import database.DBParameter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

@Stateless
public class DBParameterFacade extends AbstractManagerFacade<DBParameter> {

    public DBParameterFacade() {
        super(DBParameter.class);
    }

    public DBParameter findParam(String param) {
        try {
            return (DBParameter) dbmanager
                    .getNamedQuery("parameter.findParam")
                    .setParameter("param", param)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<DBParameter> findAll() {
        try {
            return dbmanager
                    .getNamedQuery("parameter.findAll")
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
        return null;
        }
    }

    public List<DBParameter> findTemplate(String template) {
        try {
            return dbmanager
                    .getNamedQuery("parameter.findTemplate")
                    .setParameter("template", template)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
        return null;
        }
    }

    public List<DBParameter> findInterval(int begin, int end) {
        try {
            return dbmanager
                    .getNamedQuery("parameter.findInterval")
                    .setParameter("begin", begin)
                    .setParameter("end", end)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
        return null;
        }
    }

    public boolean addNew(String param, int value) {
        DBParameter findDbParam = findParam(param);
        if (findDbParam == null) {
            try {
                DBParameter DbParam = (DBParameter) getEntityClass().newInstance();
                DbParam.setParam(param);
                DbParam.setValue(value);
                try {

                    addNewParam(DbParam);
                    return true;

                } catch (PersistenceException pe) {
                    return false;
                }
            } catch (InstantiationException | IllegalAccessException ie) {
                return false;
            }
        } else {
            findDbParam.setValue(value);
            changeParam(findDbParam);
            return false;
        }

    }

    public boolean delete(String param) {
        DBParameter DbParam = findParam(param);
        if (DbParam != null) {
            try {
                deleteParam(DbParam);
                return true;
            } catch (PersistenceException pe) {
                return false;
            }
        } else {
            return false;
        }

    }
}
