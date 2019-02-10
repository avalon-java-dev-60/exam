/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parambase;

import beans.DbManager;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author ulll
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    @Inject
    DbManager manager;
    
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    

 

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void create(T entity) {
        manager.create(entity);
    }

    public void edit(T entity) {
        manager.edit(entity);
    }

    public void remove(T entity) {
        manager.remove(entity);
    }

//    public T find(Object id) {
//        return manager.getEntityManager().find(entityClass, id);
//    }

    public List<T> findAll() {
        try {
            return manager.findAll(entityClass).getResultList();
        } catch (PersistenceException pe) {
            pe.printStackTrace(System.err);
            return null;
        }
    }
}
