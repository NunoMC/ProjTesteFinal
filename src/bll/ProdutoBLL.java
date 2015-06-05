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
import model.Produto;


/**
 *
 * @author NunoM
 */
public class ProdutoBLL {
    
 public static void create(Produto prod)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();
        
        em.clear(); 
    }
        
    public static void delete(Produto prod)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        prod = em.merge(prod);
        em.remove(prod);
        em.getTransaction().commit();
        em.clear();     
    }
    
    public static Produto retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Produto.findByIdProduto")
                      .setParameter("idProduto", id);
       
        
          if(!q.getResultList().isEmpty()){

             Produto prod = (Produto)q.getResultList().get(0);
        return prod;
        }
        return null;
    }
    
           public static Produto retrieveDesc(String desc){
        EntityManager em = BLLEntityManager.getEntityManager();
        
        Query q = em.createNativeQuery("Select * from Produto where DESCRICAO = ?",Produto.class);
        q.setParameter (1,desc) ; 
         if(!q.getResultList().isEmpty()){
             Produto prod = (Produto)q.getResultList().get(0);
        return prod;
         }
        
        return null; 
    }
    

   
   public static List<Produto> retrieveALL()
    {
        List<Produto> listaprod = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Produto.findAll");
        listaprod = q.getResultList();
        return listaprod; 
    }
   
 
    public static void refreshEntity(Produto prod)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        prod = em.merge(prod);
        em.flush();
        em.refresh(prod);
        
        em.getTransaction().commit();
        em.clear(); 
    }
}
