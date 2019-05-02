/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taxi.metier.API_CLIENT1;

/**
 *
 * @author CASHCONVERTERS
 */
public class ClientDAOTest {
    
    public ClientDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ClientDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        API_CLIENT1 obj = null;
        ClientDAO instance = new ClientDAO();
        API_CLIENT1 expResult = null;
        API_CLIENT1 result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class ClientDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idclient = 0;
        ClientDAO instance = new ClientDAO();
        API_CLIENT1 expResult = null;
        API_CLIENT1 result = instance.read(idclient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        API_CLIENT1 obj = null;
        ClientDAO instance = new ClientDAO();
        API_CLIENT1 expResult = null;
        API_CLIENT1 result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        API_CLIENT1 obj = null;
        ClientDAO instance = new ClientDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readstring method, of class ClientDAO.
     */
    @Test
    public void testReadstring() throws Exception {
        System.out.println("readstring");
        String nom = "";
        ClientDAO instance = new ClientDAO();
        API_CLIENT1 expResult = null;
        API_CLIENT1 result = instance.readstring(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
