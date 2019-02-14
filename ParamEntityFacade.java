/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
import database.Tparameters;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MultatulyIM
 */
@Singleton
public class ParamEntityFacade extends AbstractFacade<Tparameters>{
@PersistenceContext(unitName = "StoreSystem-ejbPU")
    private EntityManager em;

    public ParamEntityFacade() {
        super(Tparameters.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
