package beans;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Ella
 */
@Singleton
public class DbManager  implements Serializable {
    
    @PersistenceContext(unitName = "Applicataion_PU")
    EntityManager em;
    
    public EntityManager getEntityManager() throws PersistenceException {
        return em;
    }
    
    public <T> void remove(T entity) {
        em.merge(entity);
        em.remove(entity);
    }
    
    public Query getNamesQuery(String name) {
        return em.createNamedQuery(name);
    }
    
    public <T> void create(T entity) {
        getEntityManager().persist(entity);
    }
    
    public <T> void edit(T entity) throws PersistenceException {
        getEntityManager().merge(entity);
    }
    
    public Query findAll(Class entity) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entity));
        return getEntityManager().createQuery(cq);
    }
}
