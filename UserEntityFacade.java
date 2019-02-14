/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import database.Tuser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JAVA
 */
@Stateless
public class UserEntityFacade extends AbstractFacade<Tuser> {
    @PersistenceContext(unitName = "StoreSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEntityFacade() {
        super(Tuser.class);
        
    }
    public Tuser find(String login){
        return(Tuser)em.createNamedQuery("find-user-by-login")
                .setParameter("login", login)
                .getSingleResult();
    }
}
