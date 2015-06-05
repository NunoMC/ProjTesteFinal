/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Produto;
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
public class ProdutoBLLTest {
    private Produto prod;
    private List<Produto> prods;
    public ProdutoBLLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         System.out.println("Testing ProdutoBLL");
    }
    
    @AfterClass
    public static void tearDownClass() {
         System.out.println("Test completed");
    }
    
    @Before
    public void setUp() {
        prod = new Produto();
        prod.setDescricao("rosas");
        prod.setPreco(new BigDecimal(1.1));
        ProdutoBLL.create(prod);
    }
    
    @After
    public void tearDown() {
        if(prod!=null){
            ProdutoBLL.delete(prod);
        } 
    }

   /**
     * Test of create method, of class ClienteBLL.
     */
     @Test
    public void testCreate() {
        System.out.println("Test Create Produto");
        
        Produto clienteAuxiliar = ProdutoBLL.retrieve(prod.getIdProduto());
        assertEquals(prod, clienteAuxiliar);
    }

    /**
     * Test of retrieve method, of class ClienteBLL.
     */
    @Test
    public void testRetrieve() {
        System.out.println("Test Retrieve Produto");
        
        assertEquals(prod, ProdutoBLL.retrieve(prod.getIdProduto()));
    }
    
    // Para fazer testRetrieve podemos criar um cliente que saibamos que exista na base de dados e ir comparar. Podemos fazer esse como adicional a cada classe e mais algum método adicional.
    // Devemos também criar novos testes para 3 destas classes, e arranjar forma de dar erro.
    // Se conseguires fazer amanhã melhor, podes ir falando e eu vou falando. Abraço
    
    @Test
    public void testRetrieveAll() {
        System.out.println("Test RetrieveAll Produto");
        
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNativeQuery("Select * from Produto",Produto.class);
        List<Produto> clienteAuxiliar  = q.getResultList();
        
        prods = ProdutoBLL.retrieveALL();
        assertEquals(clienteAuxiliar, prods);
        
    }

    /**
     * Test of delete method, of class ClienteBLL.
     */
     @Test
    public void testDelete() {
        System.out.println("Test Delete Produto");
       
        ProdutoBLL.delete(prod);
       
        Produto result = ProdutoBLL.retrieve(prod.getIdProduto());
        assertEquals(null, result);
       
        
    }

    /**
     * Test of refreshEntity method, of class ClienteBLL.
     */
    public void testRefreshEntity() {
        System.out.println("Test Refresh ");
        
        prod.setDescricao("ross");
        ProdutoBLL.refreshEntity(prod);
        
        Produto result = ProdutoBLL.retrieve(prod.getIdProduto());
        assertEquals(prod,result);
    }
    
}
