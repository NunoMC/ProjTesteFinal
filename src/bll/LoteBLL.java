/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Lote;


/**
 *
 * @author NunoM
 */
public class LoteBLL {
    
 public static void create(Lote lt)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(lt);
        em.getTransaction().commit();
        
        em.clear(); 
        
        
    }
    
    public static Lote retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Lote.findByIdLote")
                      .setParameter("idLote", id);
         if(!q.getResultList().isEmpty()){
           Lote lt = (Lote)q.getResultList().get(0);
        return lt;
        }
        return null;
        
    }
    
    
      public static List<Lote> retrieveAll(){
        List<Lote> lts = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Lote.findAll");
        lts = q.getResultList();
        return lts; 
    }
   
     
    public static void delete(Lote lt)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        lt = em.merge(lt);
        em.remove(lt);
        em.getTransaction().commit();
        em.clear();   
    }
    
    public static void refreshEntity(Lote lt)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        lt = em.merge(lt);
        em.flush();
        em.refresh(lt);
        
        em.getTransaction().commit();
        em.clear(); 
    }
}

