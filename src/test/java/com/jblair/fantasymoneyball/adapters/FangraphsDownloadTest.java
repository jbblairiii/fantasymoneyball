/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.players.Player;
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
        // TODO review the generated test code and remove the default call to fail.
        FangraphsDownload fgDown = new FangraphsDownload();     
        Map<String, Player> firstBasement = fgDown.load1B();
        Player cdavis = firstBasement.get("Chris Davis");
        fail("The test case is a prototype.");
    }
}
