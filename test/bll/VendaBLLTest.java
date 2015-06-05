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
public class VendaBLLTest {
    
    private Cliente cli;
    private Funcionario func;
    private Venda venda;
    private List<Venda> vends;
    
    public VendaBLLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
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
        
    }
    
    @After
    public void tearDown() {
        
            if(venda!=null){
            VendaBLL.delete(venda);
        }
         
          if(func!=null){
            funcionarioBLL.delete(func);
        } 
             if(cli!=null){
            ClienteBLL.delete(cli);
        }
    }

    /**
     * Test of create method, of class VendaBLL.
     */
    @Test
    public void testCreate() {
       System.out.println("Test Create Venda");
        
        Venda vendAux = VendaBLL.retrieve(venda.getIdVenda());
        assertEquals(venda, vendAux);   
    }

    /**
     * Test of retrieve method, of class VendaBLL.
     */
    @Test
    public void testRetrieve() {
      System.out.println("Test Retrieve Venda");
        
        assertEquals(venda, VendaBLL.retrieve(venda.getIdVenda()));
    }

    /**
     * Test of retrieveAll method, of class VendaBLL.
     */
    @Test
    public void testRetrieveAll() {
        System.out.println("Test RetrieveAll Venda");
        
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNativeQuery("Select * from Venda",Venda.class); 
        List<Venda> vendAux  = q.getResultList();
        
        vends = VendaBLL.retrieveAll();
        assertEquals(vendAux, vends);
    }

    /**
     * Test of delete method, of class VendaBLL.
     */
    @Test
    public void testDelete() {
         System.out.println("Test Delete Venda");
        
        VendaBLL.delete(venda);
        
        Venda result = VendaBLL.retrieve(venda.getIdVenda());
        assertEquals(null, result);
    }

    /**
     * Test of refreshEntity method, of class VendaBLL.
     */
    @Test
    public void testRefreshEntity() {
      System.out.println("Test Refresh Venda");
        
        venda.setPrcramo(1.0);

        VendaBLL.refreshEntity(venda);
        
        Venda result = VendaBLL.retrieve(venda.getIdVenda());
        assertEquals(venda,result);
    }
    
}
