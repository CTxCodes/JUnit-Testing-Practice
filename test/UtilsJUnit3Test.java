/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sample.Utils;

/**
 *
 * @author cjt1496
 */
public class UtilsJUnit3Test {
    
    public UtilsJUnit3Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        
        System.out.println("* UtilsJUnit3Test: setUp() method");
    }
    
    @After
    public void tearDown() throws Exception {
        
        System.out.println("* UtilsJUnit3Test: setUp() method");
    }

    /**
     * Test of concatWords method, of class Utils.
     */
    @Test
    public void testHelloWorld() {
        System.out.println("* UtilsJUnit3Test: test method 1 - testHelloWorld()");
        assertEquals("Hello, world!", Utils.concatWords("Hello",",","world","!"));
    }

    /**
     * Test of computeFactorial method, of class Utils.
     */
    @Test
    public void testWithTimeout() throws InterruptedException, TimeoutException {
        System.out.println("* UtilsJUnit3Test: test method 2 - testWithTimeout()");
        final int factorialOf = 1 + (int) (30000 * Math.random());
        System.out.println("Computing " + factorialOf + "!");
        
        Thread testThread = new Thread(){
            public void run() {
                System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
            }
        };
        
        testThread.start();
        Thread.sleep(1000);
        testThread.interrupt();
        
        if (testThread.isInterrupted()){
            throw new TimeoutException("The test took too long to complete");
        }
    }
    
    @Test
    public void testExpectedException(){
        System.out.println("* UtilsJUnit3Test: test method 3 - testExcpectedException()");
        try{
            final int factorialOf = -5;
            System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
            fail("IllegalArgumentException was expected");
            
        } catch (IllegalArgumentException ex){}
        
        
        }
    

    /**
     * Test of normalizeWord method, of Utility class.
     * @throws java.lang.Exception
     */
    @Test
    public void DISABLED_testTemporarilyDisabled() throws Exception {
        System.out.println("* UtilsJUnit3Test: test method 4 - checkExpectedException()");
        assertEquals("Malm\u00f6", Utils.normalizeWord("Malm\u0308"));
    }
    
}
