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
import model.Cliente;


/**
 *
 * @author NunoM
 */
public class ClienteBLL {
    
    
    public static void create(Cliente cli)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
        
        em.clear(); 
    }
    
    public static Cliente retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Cliente.findByIdCliente").setParameter("idCliente", id);
         if(!q.getResultList().isEmpty()){
            Cliente cli = (Cliente)q.getResultList().get(0);
            return cli;
        }
        return null;
    }

     public static List<Cliente> retrieveALL()
    {
         List<Cliente> listaCliente = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Cliente.findAll");
        listaCliente= q.getResultList();
        return listaCliente; 
    }

     
    public static void delete(Cliente cli)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        cli = em.merge(cli);
        em.remove(cli);
        em.getTransaction().commit();
        em.clear();     
    }
    
    public static void refreshEntity(Cliente cli)
    {
         EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        cli = em.merge(cli);
        em.flush();
        em.refresh(cli);
        
        em.getTransaction().commit();
        em.clear(); 
    }
    
      public static Cliente retrieveDesc(String desc){
        EntityManager em = BLLEntityManager.getEntityManager();
        
        Query q = em.createNativeQuery("Select * from Cliente where NOME = ?",Cliente.class);
        q.setParameter (1,desc) ; 
         if(!q.getResultList().isEmpty()){
             Cliente cli = (Cliente)q.getResultList().get(0);
        return cli;
         }
        
        return null; 
    }
    
}
