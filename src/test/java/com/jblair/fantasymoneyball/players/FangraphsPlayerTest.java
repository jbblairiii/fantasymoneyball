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
    
    String hit_stats = "\"JB Blair\",\"154\",\"685\",\"595\",\"165\",\"35\",\"8\",\"19\",\"96\",\"84\",\"77\",\"133\",\"5\",\"32\",\"5\",\".277\",\".361\",\".459\",\".819\",\".357\",\"-1.0\",\"3.8\",\"5.5\",\"9776\"";
    String pitch_stats = "\"Hugh Jack\",\"14\",\"8\",\"3.54\",\"31\",\"31\",\"0\",\"197.0\",\"186\",\"77\",\"21\",\"171\",\"52\",\"1.21\",\"7.81\",\"2.38\",\"3.57\",\"3.8\",\"15764\"";
    FangraphsPlayer testHitter = null;
    FangraphsPlayer testPitcher = null; 
    float[] projections = {4.0F, 1.0F, 55.0F, 0.99F};

    
    public FangraphsPlayerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String[] hit_stats_arr = hit_stats.split(",");
        String[] pitch_stats_arr = pitch_stats.split(",");
        testHitter = new FangraphsPlayer("JB Blair", hit_stats_arr, Position.THIRD);
        testPitcher = new FangraphsPlayer("Hugh Jack", pitch_stats_arr, Position.START);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getPrimaryPosition method, of class FangraphsPlayer.
     */
    public void testGetPrimaryPosition() {
        System.out.println("getPrimaryPosition");
        Position expResult = Position.FIRST;
        Position result = testHitter.getPrimaryPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSecondaryPosition method, of class FangraphsPlayer.
     */
    public void testGetSecondaryPosition() {
        System.out.println("getSecondaryPosition");
        Position expResult = Position.NONE;
        Position result = testHitter.getSecondaryPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        Position [] pos = {Position.FIRST, Position.THIRD};
        testHitter.setPositions(pos);
        
        expResult = Position.THIRD;
        result = testHitter.getSecondaryPosition();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getThirdPosition method, of class FangraphsPlayer.
     */
    public void testGetThirdPosition() {
        System.out.println("getThirdPosition");
        Position expResult = Position.NONE;
        Position result = testHitter.getThirdPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        Position [] pos = {Position.FIRST, Position.THIRD, Position.LEFT};
        testHitter.setPositions(pos);
        
        expResult = Position.LEFT;
        result = testHitter.getThirdPosition();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getStat method, of class FangraphsPlayer.
     */
    public void testGetStat_HitterStat() {
        System.out.println("getStat");
        double expAverage = .277;
        double expSteals = 32;
        double expRuns = 96;
        double expHR = 19;
        double expRBI = 84;
        double result = testHitter.getStat(HitterStat.AVG);
        assertEquals(expAverage, result);
        
        result = testHitter.getStat(HitterStat.R);
        assertEquals(expRuns, result);
       
        result = testHitter.getStat(HitterStat.RBI);
        assertEquals(expRBI, result);
       
        result = testHitter.getStat(HitterStat.HR);
        assertEquals(expHR, result);
       
        result = testHitter.getStat(HitterStat.SB);
        assertEquals(expSteals, result);
    }

    /**
     * Test of getStat method, of class FangraphsPlayer.
     */
    public void testGetStat_PitcherStat() {
        System.out.println("getStat");
        double wins =14;
        double K =171;
        double whip=1.21;
        double sv=0;
        double era=3.54;
        
        double result = testPitcher.getStat(PitcherStat.W);
        assertEquals(wins, result);
        
        result = testPitcher.getStat(PitcherStat.SV);
        assertEquals(sv, result);
        
        result = testPitcher.getStat(PitcherStat.SO);
        assertEquals(K, result);
        
        result = testPitcher.getStat(PitcherStat.WHIP);
        assertEquals(whip, result);
        
        result = testPitcher.getStat(PitcherStat.ERA);
        assertEquals(era, result);
    }

    /**
     * Test of getDraftProjection method, of class FangraphsPlayer.
     */
    public void testGetDraftProjection() {
        System.out.println("getDraftProjection");
        DraftProjection draft = null;
        FangraphsPlayer instance = null;
        
        testHitter.setDraftProjections(projections);
        
        float result = testHitter.getDraftProjection(DraftProjection.AVG_PICK);
        assertEquals(projections[0], result);
        
        result = testHitter.getDraftProjection(DraftProjection.AVG_ROUND);
        assertEquals(projections[1], result);
        
        result = testHitter.getDraftProjection(DraftProjection.AVG_COST);
        assertEquals(projections[2], result);
        
        result = testHitter.getDraftProjection(DraftProjection.PER_DRAFTED);
        assertEquals(projections[3], result);
    }

    /**
     * Test of getFirstName method, of class FangraphsPlayer.
     */
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "JB";
        String result = testHitter.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class FangraphsPlayer.
     */
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Jack";
        String result = testPitcher.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullName method, of class FangraphsPlayer.
     */
    public void testGetFullName() {
        System.out.println("getFullName");
        String expResult = "JB Blair";
        String result = testHitter.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of pricePerStat method, of class FangraphsPlayer.
     */
    public void testPricePerStat_HitterStat() {
        System.out.println("pricePerStat");
        testHitter.setDraftProjections(projections);
        double expResult = testHitter.getDraftProjection(DraftProjection.AVG_COST) /5/ testHitter.getStat(HitterStat.HR);
        double result = testHitter.pricePerStat(HitterStat.HR);
        assertEquals(expResult, result);
        
        expResult = testHitter.getDraftProjection(DraftProjection.AVG_COST) /5/testHitter.getStat(HitterStat.R); // testHitter.getDraftProjection(DraftProjection.AVG_COST);
        result = testHitter.pricePerStat(HitterStat.R);
        assertEquals(expResult, result);
        
        expResult = testHitter.getDraftProjection(DraftProjection.AVG_COST) /5/testHitter.getStat(HitterStat.RBI); // testHitter.getDraftProjection(DraftProjection.AVG_COST);
        result = testHitter.pricePerStat(HitterStat.RBI);
        assertEquals(expResult, result);
        
        expResult =testHitter.getDraftProjection(DraftProjection.AVG_COST) /5/ testHitter.getStat(HitterStat.AVG); // testHitter.getDraftProjection(DraftProjection.AVG_COST);
        result = testHitter.pricePerStat(HitterStat.AVG);
        assertEquals(expResult, result);
        
        expResult = testHitter.getDraftProjection(DraftProjection.AVG_COST) /5/testHitter.getStat(HitterStat.SB); // testHitter.getDraftProjection(DraftProjection.AVG_COST);
        result = testHitter.pricePerStat(HitterStat.SB);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of pricePerStat method, of class FangraphsPlayer.
     */
    public void testPricePerStat_PitcherStat() {
        System.out.println("pricePerStat");
        testPitcher.setDraftProjections(projections);
        
        double expResult = testPitcher.getDraftProjection(DraftProjection.AVG_COST)/5/testPitcher.getStat(PitcherStat.W); // testPitcher.getDraftProjection(DraftProjection.AVG_COST);
        double result = testPitcher.pricePerStat(PitcherStat.W);
        assertEquals(expResult, result);
        
        expResult = 0;
        result = testPitcher.pricePerStat(PitcherStat.SV);
        assertEquals(expResult, result);
        
        expResult = testPitcher.getDraftProjection(DraftProjection.AVG_COST)/5/testPitcher.getStat(PitcherStat.SO); // testPitcher.getDraftProjection(DraftProjection.AVG_COST);
        result = testPitcher.pricePerStat(PitcherStat.SO);
        assertEquals(expResult, result);
        
        expResult = testPitcher.getDraftProjection(DraftProjection.AVG_COST)/5/testPitcher.getStat(PitcherStat.ERA); // testPitcher.getDraftProjection(DraftProjection.AVG_COST);
        result = testPitcher.pricePerStat(PitcherStat.ERA);
        assertEquals(expResult, result);
        
        expResult = testPitcher.getDraftProjection(DraftProjection.AVG_COST)/5/testPitcher.getStat(PitcherStat.WHIP); // testPitcher.getDraftProjection(DraftProjection.AVG_COST);
        result = testPitcher.pricePerStat(PitcherStat.WHIP);
        assertEquals(expResult, result);
    }
}
