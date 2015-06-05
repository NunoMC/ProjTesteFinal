/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Linhaproduto;
import model.Lote;
import model.Produto;
import model.Venda;
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
public class LoteBLLTest {
    private Produto prod;
    private Lote lt;
    private List<Lote> lts;
    
    public LoteBLLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         System.out.println("Testing LoteBLL");
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
        
        lt = new Lote();
        lt.setPreco(1.1);
        lt.setQtdcompra(new Double(1));
        lt.setQtdlixo(new Double(2));
        lt.setQuantidade(new Double(10));
        lt.setIdProduto(prod);
        java.sql.Date  JavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Calendar calendar = new GregorianCalendar();	
	calendar.set(Calendar.YEAR, 2014);
	calendar.set(Calendar.MONTH, 10 - 1 );
	calendar.set(Calendar.DAY_OF_MONTH, 3);
        lt.setDataChegada(calendar.getTime());
                        
        LoteBLL.create(lt);
    }
    
    @After
    public void tearDown() {
         if(lt!=null){
            LoteBLL.delete(lt);
        }
        if(prod!=null){
            ProdutoBLL.delete(prod);
        } 
    }

    /**
     * Test of create method, of class LoteBLL.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
         System.out.println("Test Create Lote");
        
        Lote percursoAuxiliar = LoteBLL.retrieve(lt.getIdLote());
        assertEquals(lt, percursoAuxiliar);   
    }

    /**
     * Test of retrieve method, of class LoteBLL.
     */
    @Test
    public void testRetrieve() {
       System.out.println("Test Retrieve Lote");
        
        assertEquals(lt, LoteBLL.retrieve(lt.getIdLote()));
    }

    /**
     * Test of delete method, of class LoteBLL.
     */
    @Test
    public void testDelete() {
       System.out.println("Test Delete Lote");
        
        LoteBLL.delete(lt);
        
        Lote result = LoteBLL.retrieve(lt.getIdLote());
        assertEquals(null, result);
    }
   
    /**
     * Test of RetrieveAll method, of class PercursoBLL.
     */
    @Test
    public void testRetrieveAll() {
        System.out.println("Test RetrieveAll Lote");
        
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNativeQuery("Select * from Lote",Lote.class);
        List<Lote> loteAuxiliar  = q.getResultList();
        
        lts = LoteBLL.retrieveAll();
        assertEquals(loteAuxiliar, lts);
      
    }
    /**
     * Test of refreshEntity method, of class LoteBLL.
     */
    @Test
    public void testRefreshEntity() {
         System.out.println("Test Refresh Lote");
        
        lt.setPreco(12.12);
       
      
                        
     
        LoteBLL.refreshEntity(lt);
        
        Lote result = LoteBLL.retrieve(lt.getIdLote());
        assertEquals(lt,result);
    }
    
}
