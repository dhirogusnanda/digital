package com.chocobo;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
//        String userInteract = "q";
//        new App();
//        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
//        App.main(null);
    }
    
    public void testAnswer1Case1() {
//    	String userInteract = "1\nstore\n\nkey1\n\nvalue1\n1\nad\nload\nq";
//        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
//        App.start();
        
    	// test case with one row on map and one index
        Map<Integer, Map<String, String>> storedMap = new HashMap<Integer, Map<String,String>>();
        Map<String, String> mapValue = new HashMap<String, String>();
        mapValue.put("key1", "value1");
        storedMap.put(1, mapValue);
        assertEquals("key1=value1", App.load(storedMap));
    }
    
    public void testAnswer1Case2() {
    	// test case with two rows on index zero and one row on index one
        Map<Integer, Map<String, String>> storedMap = new HashMap<Integer, Map<String,String>>();
        Map<String, String> mapValue = new HashMap<String, String>();
        mapValue.put("key1", "value1");
        mapValue.put("key2", "value2");
        Map<String, String> mapValue2 = new HashMap<String, String>();
        mapValue2.put("keyA", "valueA");
        storedMap.put(0, mapValue);
        storedMap.put(1, mapValue2);
        assertEquals("key1=value1;key2=value2\\nkeyA=valueA", App.load(storedMap));
    }
    
    public void testAnswer1Case3() {
    	// test case with one row on 3 different index
    	Map<Integer, Map<String, String>> storedMap = new HashMap<Integer, Map<String,String>>();
        Map<String, String> mapValue = new HashMap<String, String>();
        mapValue.put("key1", "value1");
        Map<String, String> mapValue2 = new HashMap<String, String>();
        mapValue2.put("keyA", "valueA");
        Map<String, String> mapValue3 = new HashMap<String, String>();
        mapValue3.put("keyS", "valueS");
        storedMap.put(0, mapValue);
        storedMap.put(1, mapValue2);
        storedMap.put(2, mapValue3);
        assertEquals("key1=value1\\nkeyA=valueA\\nkeyS=valueS", App.load(storedMap));
    }
    
    public void testAllAnswer2() {
//    	String userInteract = "2\nq";
//        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
//        App.start();
    	
        // there are no coverage for this since i dont know the answer
    }
    
    public void testAnswer3AffiliateCase1() {
//    	String userInteract = "a\n3\nemployee\no\na\n2\na\n900\nq";
//        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
//        App.start();
        
        // test case for user type as affiliate with the product is not groceries and the bought amount more than 100
        User user = new User();
        user.setAmount("900");
        user.setUserType("affiliate");
        user.setProductType("gro");
        user.setLongTimeJoined(2);
        assertEquals("765.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3AffiliateCase2() {
//    	String userInteract = "a\n3\nemployee\no\na\n2\na\n900\nq";
//        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
//        App.start();
        
        // test case for user type as affiliate with the product is not groceries and the bought amount less than 100
        User user = new User();
        user.setAmount("80");
        user.setUserType("affiliate");
        user.setProductType("gro");
        user.setLongTimeJoined(2);
        assertEquals("72.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3AffiliateCase3() {
        // test case for user type as affiliate but the product is groceries and the bought amount more than 100 
    	User user = new User();
        user.setAmount("900");
        user.setUserType("affiliate");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3AffiliateCase4() {
        // test case for user type as affiliate but the product is groceries and the bought amount less than 100 
    	User user = new User();
        user.setAmount("80");
        user.setUserType("affiliate");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("80.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3EmployeeCase1() {
        // test case for user type as employee with the product is not groceries and the bought amount more than 100
    	User user = new User();
        user.setAmount("900");
        user.setUserType("employee");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("585.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3EmployeeCase2() {
        // test case for user type as employee with the product is not groceries and the bought amount less than 100
    	User user = new User();
        user.setAmount("80");
        user.setUserType("employee");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("56.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3EmployeeCase3() {
        // test case for user type as employee with the product is groceries and the bought amount more than 100
    	User user = new User();
        user.setAmount("900");
        user.setUserType("employee");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3EmployeeCase4() {
        // test case for user type as employee with the product is groceries and the bought amount less than 100
    	User user = new User();
        user.setAmount("80");
        user.setUserType("employee");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("80.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase1() {
        // test case for user type as customer with the product is not groceries and long time joined >= 2 years and the bought amount more than 100
    	User user = new User();
        user.setAmount("900");
        user.setUserType("customer");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("810.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase2() {
        // test case for user type as customer with the product is not groceries and long time joined >= 2 years and the bought amount less than 100
    	User user = new User();
        user.setAmount("80");
        user.setUserType("customer");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("76.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase3() {
        // test case for user type as customer with the product is not groceries and long time joined <= 2 years and the bought amount more than 100
    	User user = new User();
        user.setAmount("900");
        user.setUserType("customer");
        user.setProductType("etc");
        user.setLongTimeJoined(1);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase4() {
        // test case for user type as customer with the product is not groceries and long time joined <= 2 years and the bought amount less than 100
    	User user = new User();
        user.setAmount("80");
        user.setUserType("customer");
        user.setProductType("etc");
        user.setLongTimeJoined(1);
        assertEquals("80.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase5() {
        // test case for user type as customer with the product is groceries and long time joined >= 2 years and the bought amount more than 100
    	User user = new User();
        user.setAmount("900");
        user.setUserType("customer");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase6() {
        // test case for user type as customer with the product is groceries and long time joined >= 2 years and the bought amount less than 100
    	User user = new User();
        user.setAmount("80");
        user.setUserType("customer");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("80.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase7() {
        // test case for user type as customer with the product is groceries and long time joined <= 2 years and the bought amount more than 100
    	User user = new User();
        user.setAmount("900");
        user.setUserType("customer");
        user.setProductType("groceries");
        user.setLongTimeJoined(1);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3CustomerCase8() {
        // test case for user type as customer with the product is groceries and long time joined <= 2 years and the bought amount less than 100
    	User user = new User();
        user.setAmount("80");
        user.setUserType("customer");
        user.setProductType("groceries");
        user.setLongTimeJoined(1);
        assertEquals("80.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3Case9() {
        // test case for user type nor employee, customer, affiliate with the amount more than 100
    	User user = new User();
        user.setAmount("900");
        user.setUserType("alien");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3Case10() {
        // test case for user type nor employee, customer, affiliate with the amount less than 100
    	User user = new User();
        user.setAmount("80");
        user.setUserType("alien");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("80.0", App.geneatePayableAmount(user));
    }
}
