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
import model.Venda;


/**
 *
 * @author NunoM
 */
public class VendaBLL {
    
 public static void create(Venda ve)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(ve);
        em.getTransaction().commit();
        
        em.clear(); 
    }
    
    public static Venda retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Venda.findByIdVenda")
                      .setParameter("idVenda", id);
         if(!q.getResultList().isEmpty()){
        Venda ve = (Venda)q.getResultList().get(0);
        return ve;
         }
         return null;
    }

      public static List retrieveAll(){
        List<Venda> vend = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Venda.findAll");
        vend = q.getResultList();
        return vend; 
    }
   
     
    public static void delete(Venda ve)
    {
         EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        ve = em.merge(ve);
        em.remove(ve);
        em.getTransaction().commit();
        em.clear();      
    }
    
    public static void refreshEntity(Venda ve)
    {
       EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        ve = em.merge(ve);
        em.flush();
        em.refresh(ve);
        
        em.getTransaction().commit();
        em.clear(); 
    }
}
