/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;
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
public class ClienteBLLTest {
    
    
    private Cliente cliente;
    private List<Cliente> clientes;
    
    public ClienteBLLTest() {
    }
    
   @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing ClienteBLL");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Test completed");
    }
    
    @Before
    public void setUp() {
        cliente = new Cliente();
        cliente.setNome("José");
        cliente.setMorada("rua sdds");
        ClienteBLL.create(cliente);
    }
    
    @After
    public void tearDown() {
        if(cliente!=null){
            ClienteBLL.delete(cliente);
        }    
    }

    /**
     * Test of create method, of class ClienteBLL.
     */
     @Test
    public void testCreate() {
        System.out.println("Test Create Cliente");
        
        Cliente clienteAuxiliar = ClienteBLL.retrieve(cliente.getIdCliente());
        assertEquals(cliente, clienteAuxiliar);
    }

    /**
     * Test of retrieve method, of class ClienteBLL.
     */
    @Test
    public void testRetrieve() {
        System.out.println("Test Retrieve Cliente");
        
        assertEquals(cliente, ClienteBLL.retrieve(cliente.getIdCliente()));
    }
    
    // Para fazer testRetrieve podemos criar um cliente que saibamos que exista na base de dados e ir comparar. Podemos fazer esse como adicional a cada classe e mais algum método adicional.
    // Devemos também criar novos testes para 3 destas classes, e arranjar forma de dar erro.
    // Se conseguires fazer amanhã melhor, podes ir falando e eu vou falando. Abraço
    
    @Test
    public void testRetrieveAll() {
        System.out.println("Test RetrieveAll Cliente");
        
        EntityManager em = BLLEntityManager.getEntityManager();
        Query q = em.createNativeQuery("Select * from Cliente",Cliente.class);
        List<Cliente> clienteAuxiliar  = q.getResultList();
        
        clientes = ClienteBLL.retrieveALL();
        assertEquals(clienteAuxiliar, clientes);
        
    }

    /**
     * Test of delete method, of class ClienteBLL.
     */
     @Test
    public void testDelete() {
        System.out.println("Test Delete Cliente");
        
        ClienteBLL.delete(cliente);
        
        Cliente result = ClienteBLL.retrieve(cliente.getIdCliente());
        assertEquals(null, result);
    }

    /**
     * Test of refreshEntity method, of class ClienteBLL.
     */
    public void testRefreshEntity() {
        System.out.println("Test Refresh ");
        
        cliente.setNome("José");
        ClienteBLL.refreshEntity(cliente);
        
        Cliente result = ClienteBLL.retrieve(cliente.getIdCliente());
        assertEquals(cliente,result);
    }
    
}
