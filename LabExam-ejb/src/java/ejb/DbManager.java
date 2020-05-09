package ejb;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Singleton
public class DbManager implements Serializable {

    @PersistenceContext(unitName = "LabExam-ejbPU")
    EntityManager em;

    public EntityManager getEntityManager() throws PersistenceException {
        return em;
    }

    public <T> void deleteParam(T entity) {
        em.merge(entity);
        em.remove(entity);
    }

    public Query getNamedQuery(String name) {
        return em.createNamedQuery(name);
    }

    public <T> void addNewParam(T entity) {
        getEntityManager().persist(entity);
    }

    public <T> void changeParam(T entity) throws PersistenceException {
        getEntityManager().merge(entity);
    }

}
