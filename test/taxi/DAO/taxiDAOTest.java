/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import myconnnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taxi.metier.API_TAXI1;

/**
 *
 * @author CASHCONVERTERS
 */
public class taxiDAOTest {
    static Connection dbConnect;
    
    public taxiDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
        System.out.println("connection invalide");
        System.exit(1);
        }
        System.out.println("Connexion établie!");
    }
    
    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class taxiDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        API_TAXI1 obj = new API_TAXI1(0,"TestImmatriculation","TestCarburant",50,"TestDescription");
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI1 expResult = new API_TAXI1(0,"TestImmatriculation","TestCarburant",50,"TestDescription");
        API_TAXI1 result = instance.create(obj);
        
        assertEquals("Immatriculations différentes",expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents",expResult.getCarburant(), result.getCarburant());
        assertEquals("Descriptions différentes",expResult.getDescription(), result.getDescription());
        assertNotEquals("id non généré",expResult.getIdtaxi(),result.getIdtaxi());
        int idtaxi = result.getIdtaxi();
        obj=new API_TAXI1(0,"TestImmatriculation","TestCarburant2",500,"TestDescription2");
        try{
        API_TAXI1 result2 = instance.create(obj);
        fail("exception de doublon non déclenchée");
        instance.delete(result2);
        }
        catch(SQLException e){}
        instance.delete(result);
        obj=new API_TAXI1(0,"TestImmatriculation","TestCarburant2",5,"TestDescription2");
        try{
        API_TAXI1 result3 = instance.create(obj);
        fail("exception de code postal non déclenchée");
        instance.delete(result3);
}
catch(SQLException e){}
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class taxiDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idtaxi = 61;
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        API_TAXI1 expResult = new API_TAXI1(61,"TestImmatriculation","TestCarburant",50,"TestDescription");
        API_TAXI1 result = instance.read(idtaxi);
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of update method, of class taxiDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        API_TAXI1 obj = new API_TAXI1(61,"TestImmatriculation","TestCarburant",50,"TestDescription");
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setImmatriculation("TestImmatriculation2");

        API_TAXI1 expResult = obj;
        API_TAXI1 result = instance.update(obj);
        assertEquals(expResult.getDescription(), result.getDescription());
        assertEquals(expResult.getCarburant(), result.getCarburant());
        
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class taxiDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        API_TAXI1 obj = new API_TAXI1(0,"TestImmatriculation","TestCarburant",50,"TestDescription");
        taxiDAO instance = new taxiDAO();
        instance.delete(obj);
        
    }

    /**
     * Test of readstring method, of class taxiDAO.
     */
    @Test
    public void testReadstring() throws Exception {
        System.out.println("readstring");
        String immat = "TestImmatriculation";
        taxiDAO instance = new taxiDAO();
        API_TAXI1 expResult = new API_TAXI1(0,"TestImmatriculation","TestCarburant",50,"TestDescription");
        API_TAXI1 result = instance.readstring(immat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rechp method, of class taxiDAO.
     */
    @Test
    public void testRechp() throws Exception {
        System.out.println("rechp");
        API_TAXI1 obj1 = new API_TAXI1(0,"TestImmatriculation2","TestCarburant2",50,"TestDescription2");
        API_TAXI1 obj2 = new API_TAXI1(0,"TestImmatriculation3","TestCarburant3",100,"TestDescription3");
        String desc = "TestDescription2";
        taxiDAO instance = new taxiDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);
        //List<API_TAXI1> expResult = instance.rechp(desc);
        List<API_TAXI1> result = instance.rechp(desc);
        if(result.indexOf(obj1.getDescription())<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2.getDescription())<0) fail("record introuvable"+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
        
    }

    /**
     * Test of suppression method, of class taxiDAO.
     */
    //@Test
    /*
    public void testSuppression() throws Exception {
        System.out.println("suppression");
        API_TAXI1 obj = null;
        taxiDAO instance = new taxiDAO();
        instance.suppression(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
