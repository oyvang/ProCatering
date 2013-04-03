/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procatering;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GM
 */
public class EmployeeTest {
    Employee instance = new Employee("konge","13 March", "Geir Morten", "Larsen", "12345678", "gml@procatering.com");
    
    public EmployeeTest() {
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
     * Test of getEmployee_id method, of class Employee.
     */
//    @Test
//    public void testGetEmployee_id() {
//        System.out.println("getEmployee_id");
//        int employee_id = 0;
//        Employee expResult = null;
//        Employee result = Employee.getEmployee_id(employee_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of getType method, of class Employee.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        String expResult = "KONGE";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Employee.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "dassvasker";
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Employee.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Employee{type=KONGE Person{DOB=13 March, firstName=Geir Morten, lastName=Larsen, phoneNumber=12345678, email=gml@procatering.com}}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
