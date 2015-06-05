/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;
import model.Funcionario;
import model.Marcacao;
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
public class MarcacaoBLLTest {
    
    private Cliente cli;
    private Funcionario func;
    private Marcacao mar;
    private List<Marcacao> marc;
    
    public MarcacaoBLLTest() {
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
        
         mar = new Marcacao();
        java.sql.Date  JavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Calendar calendar = new GregorianCalendar();	
	calendar.set(Calendar.YEAR, 2014);
	calendar.set(Calendar.MONTH, 10 - 1 );
	calendar.set(Calendar.DAY_OF_MONTH, 3);
        mar.setDataMarcacao(calendar.getTime());
        java.sql.Date  JavaDateObject2 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Calendar calendar2 = new GregorianCalendar();	
	calendar2.set(Calendar.YEAR, 2014);
	calendar2.set(Calendar.MONTH, 10 - 1 );
	calendar2.set(Calendar.DAY_OF_MONTH, 4);
        mar.setDataServico(calendar2.getTime());
        mar.setDescricao("Casamento");
        mar.setLocal("Braga");
        mar.setIdCliente(cli);
        mar.setIdFuncionario(func);
        
        MarcacaoBLL.create(mar);
    }
    
    @After
    public void tearDown() {
        
        if(mar!=null){
        MarcacaoBLL.delete(mar);
        }
            
            if(func!=null){
            funcionarioBLL.delete(func);
        } 
             if(cli!=null){
            ClienteBLL.delete(cli);
        }
        
    }

    /**
     * Test of create method, of class MarcacaoBLL.
     */
    @Test
    public void testCreate() {
     System.out.println("Test Create Marcação");
        
        Marcacao marcAux = MarcacaoBLL.retrieve(mar.getIdMarcacao());
        assertEquals(mar, marcAux);   
    }

    /**
     * Test of retrieve method, of class MarcacaoBLL.
     */
    @Test
    public void testRetrieve() {
       System.out.println("Test Retrieve Marcação");
        
        assertEquals(mar, MarcacaoBLL.retrieve(mar.getIdMarcacao()));
    }
 /**
     * Test of retrieveAll method, of class VendaBLL.
     */
    @Test
    public void testRetrieveAll() {
        System.out.println("Test RetrieveAll Marcação");
        
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNativeQuery("Select * from Marcacao",Marcacao.class); 
        List<Marcacao> marcAux  = q.getResultList();
        
        marc = MarcacaoBLL.retrieveAll();
        assertEquals(marcAux, marc);
    }
    
    /**
     * Test of delete method, of class MarcacaoBLL.
     */
    @Test
    public void testDelete() {
          System.out.println("Test Delete Marcação");
        
        MarcacaoBLL.delete(mar);
        
        Marcacao result = MarcacaoBLL.retrieve(mar.getIdMarcacao());
        assertEquals(null, result);
    }

    /**
     * Test of refreshEntity method, of class MarcacaoBLL.
     */
    @Test
    public void testRefreshEntity() {
        System.out.println("Test Refresh Marcação");
        
        mar.setDescricao("Casa");

        MarcacaoBLL.refreshEntity(mar);
        
        Marcacao result = MarcacaoBLL.retrieve(mar.getIdMarcacao());
        assertEquals(mar,result);
    }
    
}
