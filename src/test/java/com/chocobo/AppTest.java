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
        
    	// test case with one row on map
        Map<String, String> storedMap = new HashMap<String, String>();
        storedMap.put("key1", "value1");
        assertEquals("key1=key1\\nvalue1=key1", App.load(storedMap));
    }
    
    public void testAnswer1Case2() {
    	// test case with two rows on map
    	Map<String, String> storedMap = new HashMap<String, String>();
        storedMap.put("key1", "value1");
        storedMap.put("key2", "value2");
        assertEquals("key1=key1;key2=key2\\nvalue1=key1\\nvalue2=key2", App.load(storedMap));
    }
    
    public void testAnswer1Case3() {
    	// test case with three rows on map
    	Map<String, String> storedMap = new HashMap<String, String>();
        storedMap.put("key1", "value1");
        storedMap.put("key2", "value2");
        storedMap.put("key3", "value3");
        assertEquals("key1=key1;key2=key2;key3=key3\\nvalue1=key1\\nvalue2=key2\\nvalue3=key3", App.load(storedMap));
    }
    
    public void testAllAnswer2() {
//    	String userInteract = "2\nq";
//        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
//        App.start();
    	
        // there are no coverage for this since i dont know the answer
    }
    
    public void testAnswer3Case1() {
//    	String userInteract = "a\n3\nemployee\no\na\n2\na\n900\nq";
//        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
//        App.start();
        
        // test case for user type as affiliate
        User user = new User();
        user.setAmount("900");
        user.setUserType("affiliate");
        user.setProductType("gro");
        user.setLongTimeJoined(2);
        assertEquals("765.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3Case2() {
        // test case for user type as affiliate but the product is groceries
    	User user = new User();
        user.setAmount("900");
        user.setUserType("affiliate");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3Case3() {
        // test case for user type as customer with long time joined >= 2 years
    	User user = new User();
        user.setAmount("900");
        user.setUserType("customer");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("810.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3Case4() {
        // test case for user type as customer with long time joined less than 2 years
    	User user = new User();
        user.setAmount("900");
        user.setUserType("customer");
        user.setProductType("etc");
        user.setLongTimeJoined(1);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3Case5() {
        // test case for user type as employee
    	User user = new User();
        user.setAmount("900");
        user.setUserType("employee");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("585.0", App.geneatePayableAmount(user));
    }
    
    public void testAnswer3Case6() {
        // test case for user type nor employee, customer, affiliate
    	User user = new User();
        user.setAmount("900");
        user.setUserType("alien");
        user.setProductType("etc");
        user.setLongTimeJoined(2);
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
}
