/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.players;

import junit.framework.TestCase;

/**
 *
 * @author JB
 */
public class FangraphsPlayerTest extends TestCase {
    
    public FangraphsPlayerTest(String testName) {
        super(testName);
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
     * Test of setPositions method, of class FangraphsPlayer.
     */
    public void testSetPositions() {
        System.out.println("setPositions");
        Position[] _pos = null;
        FangraphsPlayer instance = null;
        instance.setPositions(_pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStats method, of class FangraphsPlayer.
     */
    public void testSetStats() {
        System.out.println("setStats");
        double[] _stats = null;
        FangraphsPlayer instance = null;
        instance.setStats(_stats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDraftProjections method, of class FangraphsPlayer.
     */
    public void testSetDraftProjections() {
        System.out.println("setDraftProjections");
        float[] _proj = null;
        FangraphsPlayer instance = null;
        instance.setDraftProjections(_proj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimaryPosition method, of class FangraphsPlayer.
     */
    public void testGetPrimaryPosition() {
        System.out.println("getPrimaryPosition");
        FangraphsPlayer instance = null;
        Position expResult = null;
        Position result = instance.getPrimaryPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondaryPosition method, of class FangraphsPlayer.
     */
    public void testGetSecondaryPosition() {
        System.out.println("getSecondaryPosition");
        FangraphsPlayer instance = null;
        Position expResult = null;
        Position result = instance.getSecondaryPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThirdPosition method, of class FangraphsPlayer.
     */
    public void testGetThirdPosition() {
        System.out.println("getThirdPosition");
        FangraphsPlayer instance = null;
        Position expResult = null;
        Position result = instance.getThirdPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStat method, of class FangraphsPlayer.
     */
    public void testGetStat_HitterStat() {
        System.out.println("getStat");
        HitterStat stat = null;
        FangraphsPlayer instance = null;
        double expResult = 0.0;
        double result = instance.getStat(stat);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStat method, of class FangraphsPlayer.
     */
    public void testGetStat_PitcherStat() {
        System.out.println("getStat");
        PitcherStat stat = null;
        FangraphsPlayer instance = null;
        double expResult = 0.0;
        double result = instance.getStat(stat);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDraftProjection method, of class FangraphsPlayer.
     */
    public void testGetDraftProjection() {
        System.out.println("getDraftProjection");
        DraftProjection draft = null;
        FangraphsPlayer instance = null;
        float expResult = 0.0F;
        float result = instance.getDraftProjection(draft);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class FangraphsPlayer.
     */
    public void testGetFirstName() {
        System.out.println("getFirstName");
        FangraphsPlayer instance = null;
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class FangraphsPlayer.
     */
    public void testGetLastName() {
        System.out.println("getLastName");
        FangraphsPlayer instance = null;
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFullName method, of class FangraphsPlayer.
     */
    public void testGetFullName() {
        System.out.println("getFullName");
        FangraphsPlayer instance = null;
        String expResult = "";
        String result = instance.getFullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pricePerStat method, of class FangraphsPlayer.
     */
    public void testPricePerStat_HitterStat() {
        System.out.println("pricePerStat");
        HitterStat stat = null;
        FangraphsPlayer instance = null;
        double expResult = 0.0;
        double result = instance.pricePerStat(stat);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pricePerStat method, of class FangraphsPlayer.
     */
    public void testPricePerStat_PitcherStat() {
        System.out.println("pricePerStat");
        PitcherStat stat = null;
        FangraphsPlayer instance = null;
        double expResult = 0.0;
        double result = instance.pricePerStat(stat);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class FangraphsPlayer.
     */
    public void testToString() {
        System.out.println("toString");
        FangraphsPlayer instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
