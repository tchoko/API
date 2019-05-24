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
public class API_TAXI1DAOTest {
    static Connection dbConnect;
    public API_TAXI1DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
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
     * Test of create method, of class API_TAXI1DAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        API_TAXI1 obj = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        API_TAXI1DAO instance = new API_TAXI1DAO();
        instance.setConnection(dbConnect);
        API_TAXI1 expResult = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        API_TAXI1 result = instance.create(obj);
        assertEquals("Description différente", expResult.getDescription(), result.getDescription());
        assertEquals("Immatriculation différente", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("Prix km différents", expResult.getPrixkm(), result.getPrixkm(), 0);
        
        assertNotEquals("Idtaxi différent", result.getIdtaxi(), expResult.getIdtaxi());
        obj = new API_TAXI1(0, "TestImmatriculation", "TestCarburant2", 500, "TestDescription2");
        try {
            API_TAXI1 result2 = instance.create(obj);
            fail("Exception de doublon non générée");
            instance.delete(result2);
        } catch (SQLException e) {
            instance.delete(result);
        }

        //Test of creating an object with incorrect "Prixkm"
        obj = new API_TAXI1(0, "TestImmatriculation", "TestCarburant2", -200, "TestDescription2");
        try {
            API_TAXI1 result3 = instance.create(obj);
            fail("Exception prix km non déclanchée");
            instance.delete(result3);
        } catch (SQLException e) {

        }

    }
  
         

    /**
     * Test of read method, of class API_TAXI1DAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idtaxi = 0;
        API_TAXI1DAO instance = new API_TAXI1DAO();
        instance.setConnection(dbConnect);
        API_TAXI1 obj = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        API_TAXI1 expResult = instance.create(obj);
        idtaxi = expResult.getIdtaxi();
        API_TAXI1 result = instance.read(idtaxi);
        //assertEquals(expResult, result);
        assertEquals("Description différente", expResult.getDescription(), result.getDescription());
        assertEquals("Immatriculation différente", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("Prix km différents", expResult.getPrixkm(), result.getPrixkm(), 0);
        
        assertEquals("Idtaxi différent", expResult.getIdtaxi(), result.getIdtaxi());
        try {
            result = instance.read(0);
            fail("Exception id non générée! ");
        } catch (SQLException e) {
            instance.delete(result);
        }
    }

    /**
     * Test of update method, of class API_TAXI1DAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        API_TAXI1 obj = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        API_TAXI1DAO instance = new API_TAXI1DAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setImmatriculation("TestImmatriculation2");
        obj.setCarburant("TestCarburant2");
        obj.setPrixkm(200);
        obj.setDescription("TestDescription2");
        API_TAXI1 expResult = obj;
        API_TAXI1 result = instance.update(obj);
        assertEquals(expResult, result);
        assertEquals("Description différente", expResult.getDescription(), result.getDescription());
        assertEquals("Immatriculation différente", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Carburants différents", expResult.getCarburant(), result.getCarburant());
        assertEquals("Prix km différents", expResult.getPrixkm(), result.getPrixkm(), 0);
        
        instance.delete(obj);
        
        API_TAXI1 obj2 = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        obj2 = instance.create(obj2);
        API_TAXI1 obj3 = new API_TAXI1(0, "TestImmatriculation3", "TestCarburant", 50, "TestDescription");
        obj3 = instance.create(obj3);
        obj2.setDescription("TestDescription2");
         try {
            instance.update(obj2);
            fail("Exception de doublon non générée");
        } catch (SQLException e) {
            instance.delete(obj2);
            instance.delete(obj3);
        }
        assertEquals("Idtaxi différent", expResult.getIdtaxi(), result.getIdtaxi());
         // incorrecte description
        API_TAXI1 obj4 = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        obj4 = instance.create(obj4);
        obj4.setDescription("TestDescription4");

        try {
            instance.update(obj4);
            fail("Exception Description non déclanchée");
        } catch (SQLException e) {
            instance.delete(obj4);
        }
    }

    /**
     * Test of delete method, of class API_TAXI1DAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        API_TAXI1 obj = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        API_TAXI1DAO instance = new API_TAXI1DAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        int idtaxi = obj.getIdtaxi();
        instance.delete(obj);
        try {
            instance.read(idtaxi);
            fail("Exception de record introuvable non générée");
        } catch (SQLException e) {
            
        }
    }

    /**
     * Test of readstring method, of class API_TAXI1DAO.
     */
    @Test
    public void testReadstring() throws Exception {
        System.out.println("readstring");
        String immat = "TestImmatriculation";
        API_TAXI1 obj=  new API_TAXI1(0,"TestImmatriculation","TestCarburant",50,"TestDescription");
        API_TAXI1DAO instance = new API_TAXI1DAO();
        instance.setConnection(dbConnect);
       /* API_TAXI1 expResult = instance.create(obj);
        API_TAXI1 result = instance.readstring(immat);
        assertEquals(expResult, result);
        assertEquals("Immatriculation différentes",expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("Description différente",expResult.getDescription(),result.getDescription());
        assertEquals("Carburant différent",expResult.getCarburant(),result.getCarburant());
        assertEquals("prix différent",expResult.getPrixkm(),result.getPrixkm(),0);
        assertEquals("id différent",expResult.getIdtaxi(),result.getIdtaxi());
        try{
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        }
        catch(SQLException e){}
        instance.delete(result);*/
    }

    /**
     * Test of rechp method, of class API_TAXI1DAO.
     */
    @Test
    public void testRechp() throws Exception {
        System.out.println("rechp");
        String desc = "TestDescription";
        API_TAXI1DAO instance = new API_TAXI1DAO();
       /* instance.setConnection(dbConnect);
        API_TAXI1 obj = new API_TAXI1(0, "TestImmatriculation", "TestCarburant", 50, "TestDescription");
        List<API_TAXI1> expResult = null;
        obj = instance.create(obj);
        expResult.add(obj);
        List<API_TAXI1> result = instance.rechp(desc);
        assertEquals(expResult,result);*/
        
    }
    
}
