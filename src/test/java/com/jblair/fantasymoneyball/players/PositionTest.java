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
public class PositionTest extends TestCase {
    
    public PositionTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PositionTest.class);
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
     * Test of values method, of class Position.
     */
    public void testValues() {
        System.out.println("values");
        Position[] expResult = null;
        Position[] result = Position.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Position.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Position expResult = null;
        Position result = Position.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
