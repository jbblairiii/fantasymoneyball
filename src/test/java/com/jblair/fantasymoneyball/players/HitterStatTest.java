/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.players;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author JB
 */
public class HitterStatTest extends TestCase {
    
    public HitterStatTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(HitterStatTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of values method, of class HitterStat.
     */
    public void testValues() {
        System.out.println("values");
        HitterStat[] expResult = null;
        HitterStat[] result = HitterStat.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class HitterStat.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        HitterStat expResult = null;
        HitterStat result = HitterStat.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
