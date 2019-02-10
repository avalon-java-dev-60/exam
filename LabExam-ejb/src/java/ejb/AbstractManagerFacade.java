/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import ejb.DbManager;
import javax.inject.Inject;

/**
 *
 * @author Havok
 */
public abstract class AbstractManagerFacade<T> {
     @Inject
    DbManager dbmanager;
    private Class<T> entityClass;

    public AbstractManagerFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void addNewParam(T entity) {
        dbmanager.addNewParam(entity);
    }

    public void changeParam(T entity) {
        dbmanager.changeParam(entity);
    }

    public void deleteParam(T entity) {
        dbmanager.deleteParam(entity);
    }

    public T find(Object id) {
        return dbmanager.getEntityManager().find(entityClass, id);
    }

//    public List<T> findAll() {
//        try {
//            return dbmanager.findAll(entityClass).getResultList();
//        } catch (PersistenceException pe) {
//            pe.printStackTrace(System.err);
//            return null;
//        }
//    }
}
