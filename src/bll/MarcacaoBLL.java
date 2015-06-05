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
import model.Marcacao;


/**
 *
 * @author NunoM
 */
public class MarcacaoBLL {
    
 public static void create(Marcacao marc)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(marc);
        em.getTransaction().commit();
        
        em.clear(); 
    }
    
    public static Marcacao retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Marcacao.findByIdMarcacao")
                      .setParameter("idMarcacao", id);
        if(!q.getResultList().isEmpty()){
        Marcacao marc = (Marcacao)q.getResultList().get(0);
        return marc;
        }
        return null;
    }

   

     
    public static void delete(Marcacao marc)
    {
         EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        marc = em.merge(marc);
        em.remove(marc);
        em.getTransaction().commit();
        em.clear();      
    }
    
    public static void refreshEntity(Marcacao marc)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        marc = em.merge(marc);
        em.flush();
        em.refresh(marc);
        
        em.getTransaction().commit();
        em.clear(); 
    }
    
      public static List retrieveAll(){
        List<Marcacao> marc = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Marcacao.findAll");
        marc = q.getResultList();
        return marc; 
    }
}
