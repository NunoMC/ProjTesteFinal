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
import model.Linhaproduto;
import model.Lote;


/**
 *
 * @author NunoM
 */
public class LinhaProdutoBLL {
    
public static void create(Linhaproduto lt)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(lt);
        em.getTransaction().commit();
        
        em.clear(); 
    }
    
    public static Linhaproduto retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Linhaproduto.findByIdLinhaproduto")
                      .setParameter("idLinhaproduto", id);
        
         if(!q.getResultList().isEmpty()){
        Linhaproduto lp = (Linhaproduto)q.getResultList().get(0);
        return lp;
    }
         return null;
    }
   
     
    public static void delete(Linhaproduto lp)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        lp = em.merge(lp);
        em.remove(lp);
        em.getTransaction().commit();
        em.clear();   
    }
    
    public static void refreshEntity(Linhaproduto lp)
    {
         EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        lp = em.merge(lp);
        em.flush();
        em.refresh(lp);
        
        em.getTransaction().commit();
        em.clear(); 
    }
    
     public static List retrieveAll(){
        List<Linhaproduto> lts = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Linhaproduto.findAll");
        lts = q.getResultList();
        return lts; 
    }
}

