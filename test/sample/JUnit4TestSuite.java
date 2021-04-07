/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author cjt1496
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({sample.UtilsJUnit3Test.class, sample.VectorsJUnit3Test.class, sample.UtilsJUnit4Test.class, sample.VectorsJUnit4Test.class, sample.JUnit3TestSuite.class})
public class JUnit4TestSuite extends TestCase{

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
     public JUnit4TestSuite(String testName) {
        super(testName);
    }
    
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("JUnit3TestSuite");
        suite.addTest(new TestSuite(sample.VectorsJUnit3Test.class));
        suite.addTest(new TestSuite(sample.UtilsJUnit3Test.class));
        return suite;
    }
    
}
