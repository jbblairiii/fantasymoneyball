/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.players.FangraphsPlayer;
import com.jblair.fantasymoneyball.players.HitterStat;
import com.jblair.fantasymoneyball.players.PitcherStat;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author JB
 */
public class FangraphsDownloadTest extends TestCase {
    
    public FangraphsDownloadTest(String testName) {
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

    public void testLoad1B() {
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, FangraphsPlayer> firstBasemen = fgDown.load1B();
        FangraphsPlayer cdavis = firstBasemen.get("Chris Davis");
        assertEquals(41.0, cdavis.getStat(HitterStat.HR));
    }
    public void testLoad2B() {
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, FangraphsPlayer> secBasemen = fgDown.load2B();
        FangraphsPlayer cutley = secBasemen.get("Chase Utley");
        assertEquals(18.0, cutley.getStat(HitterStat.HR));
    }
    public void testLoad3B() {
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, FangraphsPlayer> thirdBasemen = fgDown.load3B();
        FangraphsPlayer manny = thirdBasemen.get("Manny Machado");
        assertEquals(15.0, manny.getStat(HitterStat.HR));
    }
    public void testLoadSS() {
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, FangraphsPlayer> shorts = fgDown.loadSS();
        FangraphsPlayer hardy = shorts.get("J.J. Hardy");
        assertEquals(22.0, hardy.getStat(HitterStat.HR));
    }
    public void testLoadOF() {
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, FangraphsPlayer> out = fgDown.loadOF();
        FangraphsPlayer jonesy = out.get("Adam Jones");
        assertEquals(31.0, jonesy.getStat(HitterStat.HR));
    }
    public void testLoadP() {
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, FangraphsPlayer> pitch = fgDown.loadP();
        FangraphsPlayer tilly = pitch.get("Chris Tillman");
        assertEquals(13.0, tilly.getStat(PitcherStat.W));
    }
    public void testLoadC() {
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, FangraphsPlayer> catchs = fgDown.loadC();
        FangraphsPlayer wheaty = catchs.get("Matt Wieters");
        assertEquals(21.0, wheaty.getStat(HitterStat.HR));
    }
}
