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
public class DraftProjectionTest extends TestCase {
    
    public DraftProjectionTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(DraftProjectionTest.class);
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
     * Test of values method, of class DraftProjection.
     */
    public void testValues() {
        System.out.println("values");
        DraftProjection[] expResult = null;
        DraftProjection[] result = DraftProjection.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class DraftProjection.
     */
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        DraftProjection expResult = null;
        DraftProjection result = DraftProjection.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
