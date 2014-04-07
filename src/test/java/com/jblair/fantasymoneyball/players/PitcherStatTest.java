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
public class PitcherStatTest extends TestCase {
    
    public PitcherStatTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PitcherStatTest.class);
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
     * Test of values method, of class PitcherStat.
     */
    public void testValues() {
        System.out.println("values");
        PitcherStat[] expResult = null;
        PitcherStat[] result = PitcherStat.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class PitcherStat.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        PitcherStat expResult = null;
        PitcherStat result = PitcherStat.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
