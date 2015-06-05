/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NunoM
 */
public class funcionarioBLLTest {
      private Funcionario func;
    private List<Funcionario> funcs;
   
    
    
    public funcionarioBLLTest() {
    }

    
   
     @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing funcionarioBLL");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Test completed");
    }
    
    @Before
    public void setUp() {
        func = new Funcionario();
        func.setNome("José");
        funcionarioBLL.create(func);
    }
    
    @After
    public void tearDown() {
        if(func!=null){
            funcionarioBLL.delete(func);
        }    
    }

    /**
     * Test of create method, of class ClienteBLL.
     */
     @Test
    public void testCreate() {
        System.out.println("Test Create Funcionario");
        
        Funcionario funcaux = funcionarioBLL.retrieve(func.getIdFuncionario());
        assertEquals(func, funcaux);
    }

    /**
     * Test of retrieve method, of class ClienteBLL.
     */
    @Test
    public void testRetrieve() {
        System.out.println("Test Retrieve Funcionario");
        
        assertEquals(func, funcionarioBLL.retrieve(func.getIdFuncionario()));
    }
    
    // Para fazer testRetrieve podemos criar um cliente que saibamos que exista na base de dados e ir comparar. Podemos fazer esse como adicional a cada classe e mais algum método adicional.
    // Devemos também criar novos testes para 3 destas classes, e arranjar forma de dar erro.
    // Se conseguires fazer amanhã melhor, podes ir falando e eu vou falando. Abraço
    
    @Test
    public void testRetrieveAll() {
        System.out.println("Test RetrieveAll Funcionario");
        
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNativeQuery("Select * from Funcionario",Funcionario.class);
        List<Funcionario> funcAuxiliar  = q.getResultList();
        
        funcs = funcionarioBLL.retrieveAll();
        assertEquals(funcAuxiliar, funcs);
        
    }

    /**
     * Test of delete method, of class ClienteBLL.
     */
     @Test
    public void testDelete() {
        System.out.println("Test Delete Funcionario");
        
        funcionarioBLL.delete(func);
        
        Funcionario result = funcionarioBLL.retrieve(func.getIdFuncionario());
        assertEquals(null, result);
    }

    /**
     * Test of refreshEntity method, of class ClienteBLL.
     */
    public void testRefreshEntity() {
        System.out.println("Test Refresh");
        
        func.setNome("José");
        funcionarioBLL.refreshEntity(func);
        
        Funcionario result = funcionarioBLL.retrieve(func.getIdFuncionario());
        assertEquals(func,result);
    }
    
}
