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
import model.Funcionario;

/**
 *
 * @author NunoM
 */
public class funcionarioBLL {
    
public static void create(Funcionario func)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(func);
        em.getTransaction().commit();
        
        em.clear(); 
    }
    
    public static Funcionario retrieve(int id)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Funcionario.findByIdFuncionario")
                      .setParameter("idFuncionario", id);
         if(!q.getResultList().isEmpty()){
            Funcionario func = (Funcionario)q.getResultList().get(0);
        return func;
        }
        return null;
        
    }

    public static void delete(Funcionario func)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.getTransaction().begin();
        func = em.merge(func);
        em.remove(func);
        em.getTransaction().commit();
        em.clear();       
    }
    
      public static List retrieveAll(){
        List<Funcionario> listafunc = new ArrayList<>();
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNamedQuery("Funcionario.findAll");
        listafunc = q.getResultList();
        return listafunc; 
    }
    
    public static void refreshEntity(Funcionario func)
    {
        EntityManager em = BLLEntityManager.getEntityManager();
        em.refresh(func);
    }
}
