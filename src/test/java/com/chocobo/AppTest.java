package com.chocobo;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        String userInteract = "q";
        new App();
        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
        App.main(null);
    }
    
    public void testAllAnswer1() {
    	String userInteract = "1\nstore\n\nkey1\n\nvalue1\n1\nad\nload\nq";
        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
        App.start();
    }
    
    public void testAllAnswer2() {
    	String userInteract = "2\nq";
        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
        App.start();
        
        Map<String, String> storedMap = new HashMap<String, String>();
        storedMap.put("key1", "value1");
        storedMap.put("key2", "value2");
        storedMap.put("key3", "value3");
        assertEquals("key1=key1;key2=key2;key3=key3\\nvalue1=key1\\nvalue2=key2\\nvalue3=key3", App.load(storedMap));
    }
    
    public void testAllAnswer3() {
    	String userInteract = "a\n3\nemployee\no\na\n2\na\n900\nq";
        System.setIn(new ByteArrayInputStream(userInteract.getBytes()));
        App.start();
        
        User user = new User();
        user.setAmount("900");
        user.setUserType("affiliate");
        user.setProductType("groceries");
        user.setLongTimeJoined(2);
        assertEquals("855.0", App.geneatePayableAmount(user));
        
        user.setUserType("customer");
        assertEquals("855.0", App.geneatePayableAmount(user));
        user.setLongTimeJoined(1);
        assertEquals("855.0", App.geneatePayableAmount(user));
        user.setUserType("asd");
        assertEquals("855.0", App.geneatePayableAmount(user));
    }
    
}
