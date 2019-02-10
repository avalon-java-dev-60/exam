/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parambase;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 *
 * @author ulll
 */
@Stateless
public class ParametersFacade extends AbstractFacade<Parameters> {

    public ParametersFacade(Class<Parameters> entityClass) {
        super(Parameters.class);
    }

    public ParametersFacade() {
        super(Parameters.class);

    }

    public Parameters findParam(String name) {

        try {
            return (Parameters) manager
                    .getNamesQuery("Parameters.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Parameters> findByName(String pattern) {

        try {
            return manager
                    .getNamesQuery("Parameters.findByPattern")
                    .setParameter("pattern", pattern)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return null;
        }
    }

    public List<Parameters> findAllParams() {

        try {
            return manager
                    .getNamesQuery("Parameters.findAll")
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return null;
        }
    }

    public List<Parameters> findByValue(int start, int end) {

        try {
            return manager
                    .getNamesQuery("Parameters.findByValue")
                    .setParameter("min_value", start)
                    .setParameter("max_value", end)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return null;
        }
    }

    public boolean addParam(String name, int value) {
        Parameters existedParam = findParam(name);
        
        if (existedParam == null) {
            try {
                Parameters param = (Parameters) getEntityClass().newInstance();
                param.setName(name);
                param.setValue(value);
                
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

    public boolean updateParam(Parameters param, int value) {
        param.setValue(value);
        try {
            edit(param);
            return true;
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return false;
        }
    }

    public boolean deleteParam(String name) {
        Parameters param = findParam(name);
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
