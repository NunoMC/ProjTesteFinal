/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author NunoM
 */
class BLLEntityManager {
 private static final String PERSISTENCE_UNIT_NAME =
                                             "ProjectoIIPU";
    private static EntityManagerFactory factory;
    
    private static EntityManager em = null;
    
    public static EntityManager getEntityManager() 
    {
        if (em==null)
        {
            factory = Persistence
              .createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();
        }
        return em;
    }
    
    public static void beginUpdate()
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
    }

    public static void endUpdate()
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().commit();
        em.clear(); 
    }
}
