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
import model.VendaMarc;


/**
 *
 * @author NunoM
 */
public class VendaMarcBLL {
    
 public static void create(VendaMarc ve)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(ve);
        em.getTransaction().commit();
        
        em.clear(); 
    }
    
    public static VendaMarc retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("VendaMarc.findByIdVendamarc")
                      .setParameter("idVendamarc", id);
          if(!q.getResultList().isEmpty()){
        VendaMarc ve = (VendaMarc)q.getResultList().get(0);
        return ve;
          }
          return null;
    }

    public static List retrieveAll(){
        List<VendaMarc> vd = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("VendaMarc.findAll");
        vd = q.getResultList();
        return vd; 
    }

     
    public static void delete(VendaMarc ve)
    {
         EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        ve = em.merge(ve);
        em.remove(ve);
        em.getTransaction().commit();
        em.clear();  
    }
  
}
