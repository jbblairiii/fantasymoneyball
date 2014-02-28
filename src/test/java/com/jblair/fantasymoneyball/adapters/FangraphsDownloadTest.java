/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.players.Player;
import com.jblair.fantasymoneyball.players.Stat;
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
        Map<String, Player> firstBasemen = fgDown.load1B();
        Player cdavis = firstBasemen.get("Chris Davis");
        assertEquals(41.0, cdavis.getStat(Stat.HR));
    }
}
