/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;
import model.Funcionario;
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
public class LinhaProdutoBLLTest {
    
    private Produto prod;
    private Venda venda;
    private Lote lote;
    private Funcionario func;
    private Cliente cli;
    private Linhaproduto lp;
    private List<Linhaproduto> lps;
    
    public LinhaProdutoBLLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
          System.out.println("Testing LinhaBLL");
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
           System.out.println("Test completed");
        
    }
    
    @Before
    public void setUp() {
        
        prod = new Produto();
        prod.setDescricao("Teste");
        prod.setPreco(new BigDecimal(100.3));
        
        ProdutoBLL.create(prod);
        
        
        lote = new Lote();
        lote.setPreco(new Double(10.4));
        lote.setQtdcompra(new Double(1));
        lote.setQtdlixo(new Double(2));
        lote.setQuantidade(new Double(10));
        lote.setIdProduto(prod);
        java.sql.Date  JavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Calendar calendar = new GregorianCalendar();	
	calendar.set(Calendar.YEAR, 2014);
	calendar.set(Calendar.MONTH, 10 - 1 );
	calendar.set(Calendar.DAY_OF_MONTH, 3);
        lote.setDataChegada(calendar.getTime());
         
        LoteBLL.create(lote);
      
        
        func = new Funcionario();
        func.setNome("Func");
        
        funcionarioBLL.create(func);
        
        
        cli = new Cliente();
        cli.setMorada("Moure");
        cli.setNome("Cliente");
        
        ClienteBLL.create(cli);
        
        
        venda = new Venda();
        java.sql.Date  JavaDateObject2 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Calendar calendar2 = new GregorianCalendar();	
	calendar2.set(Calendar.YEAR, 2014);
	calendar2.set(Calendar.MONTH, 10 - 1 );
	calendar2.set(Calendar.DAY_OF_MONTH, 3);
        venda.setDataVenda(calendar2.getTime());
        venda.setIdCliente(cli);
        venda.setIdFuncionario(func);
        venda.setPrcramo(20.4);
        venda.setPrecoTotal(12.2);
        venda.setValorServico(34.8);
        
        VendaBLL.create(venda);
        
        
        lp = new Linhaproduto();
        lp.setQuantidade(new BigDecimal(20));
        lp.setValor(new BigDecimal(31.4));
        lp.setIdLote(lote);
        lp.setIdVenda(venda);
        
        LinhaProdutoBLL.create(lp);
        
    }
    
    @After
    public void tearDown() {
        
            if(lp!=null){
            LinhaProdutoBLL.delete(lp);
        }  
            if(venda!=null){
            VendaBLL.delete(venda);
        }
         
          if(func!=null){
            funcionarioBLL.delete(func);
        } 
          if(lote!=null){
            LoteBLL.delete(lote);
        }
          if(prod!=null){
            ProdutoBLL.delete(prod);
        } 
            if(cli!=null){
            ClienteBLL.delete(cli);
        }
    }

    /**
     * Test of create method, of class LinhaProdutoBLL.
     */
    @Test
    public void testCreate() {
         System.out.println("Test Create Linha Produto");
        
        Linhaproduto lpAux = LinhaProdutoBLL.retrieve(lp.getIdLinhaproduto());
        assertEquals(lp, lpAux);   
    }

    /**
     * Test of retrieve method, of class LinhaProdutoBLL.
     */
    @Test
    public void testRetrieve() {
        System.out.println("Test Retrieve Linha Produto");
        
        assertEquals(lp, LinhaProdutoBLL.retrieve(lp.getIdLinhaproduto()));
    }

    /**
     * Test of delete method, of class LinhaProdutoBLL.
     */
    @Test
    public void testDelete() {
       System.out.println("Test Delete Linha Produto");
        
        LinhaProdutoBLL.delete(lp);
        
        Linhaproduto result = LinhaProdutoBLL.retrieve(lp.getIdLinhaproduto());
        assertEquals(null, result);
    }
/**
     * Test of RetrieveAll method, of class PercursoBLL.
     */
    @Test
    public void testRetrieveAll() {
        System.out.println("Test RetrieveAll Linha Produto");
        
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNativeQuery("Select * from linhaproduto",Linhaproduto.class); 
        List<Linhaproduto> linhaAux  = q.getResultList();
        
        lps = LinhaProdutoBLL.retrieveAll();
        assertEquals(linhaAux, lps);
      
    }
    /**
     * Test of refreshEntity method, of class LinhaProdutoBLL.
     */
    @Test
    public void testRefreshEntity() {
       System.out.println("Test Refresh Linha Produto");
        
        lp.setValor(new BigDecimal(1200.2));

        LinhaProdutoBLL.refreshEntity(lp);
        
        Linhaproduto result = LinhaProdutoBLL.retrieve(lp.getIdLinhaproduto());
        assertEquals(lp,result);
    }
    
}
