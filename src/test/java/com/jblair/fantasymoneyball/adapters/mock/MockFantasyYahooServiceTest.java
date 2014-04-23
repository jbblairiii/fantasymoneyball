/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters.mock;

import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import junit.framework.TestCase;

/**
 *
 * @author jb834r
 */
public class MockFantasyYahooServiceTest extends TestCase {
    
    private Random rand;

    
    public MockFantasyYahooServiceTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();        
        rand = new Random();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getCatchers method, of class MockFantasyYahooService.
     */
    public void testGetCatchers() {
        System.out.println("getCatchers");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("error parsing xml");
        }
            instance.connectApi();  
        
        List<Player> catchers=instance.getCatchers();
        int expSize=25;
        int size = catchers.size();
        assertEquals(expSize, size);
        
        String expPos="C";
        String pos = catchers.get(rand.nextInt(expSize)).getDisplayPosition();
        if(!pos.contains(expPos)){   
            fail();
        }   
    }

    /**
     * Test of getFirstBasemen method, of class MockFantasyYahooService.
     */
    public void testGetFirstBasemen() {
        System.out.println("getFirstBasemen");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
            
        List<Player> first = instance.getFirstBasemen();
        int expSize=25;
        int size = first.size();
        assertEquals(expSize, size);
        
        String expPos="1B";
        String pos = first.get(rand.nextInt(expSize)).getDisplayPosition();
        if(!pos.contains(expPos)){   
            fail();
        }
    }

    /**
     * Test of getSecondBasemen method, of class MockFantasyYahooService.
     */
    public void testGetSecondBasemen() {
        System.out.println("getSecondBasemen");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
            
        List<Player> second = instance.getSecondBasemen();
        int expSize=25;
        int size = second.size();
        assertEquals(expSize, size);
        
        String expPos="2B";
        String pos = second.get(rand.nextInt(expSize)).getDisplayPosition();
        if(!pos.contains(expPos)){   
            fail();
        }
    }

    /**
     * Test of getThirdBasemen method, of class MockFantasyYahooService.
     */
    public void testGetThirdBasemen() {
        System.out.println("getThirdBasemen");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
            
        List<Player> third = instance.getThirdBasemen();
        int expSize=25;
        int size = third.size();
        assertEquals(expSize, size);
        
        String expPos="3B";
        String pos = third.get(rand.nextInt(expSize)).getDisplayPosition();
        if(!pos.contains(expPos)){   
            fail();
        }
        
    }

    /**
     * Test of getShortstops method, of class MockFantasyYahooService.
     */
    public void testGetShortstops() {
        System.out.println("getShortstops");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
            
        List<Player> shorts = instance.getShortstops();
        int expSize=25;
        int size = shorts.size();
        assertEquals(expSize, size);
        
        String expPos="SS";
        String pos = shorts.get(rand.nextInt(expSize)).getDisplayPosition();
        if(!pos.contains(expPos)){   
            fail();
        }
    }

    /**
     * Test of getOutfielders method, of class MockFantasyYahooService.
     */
    public void testGetOutfielders() {
        System.out.println("getOutfielders");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
            
        List<Player> out = instance.getOutfielders();
        int expSize=25;
        int size = out.size();
        assertEquals(expSize, size);
        
        String expPos="OF";
        String pos = out.get(rand.nextInt(expSize)).getDisplayPosition();
        if(!pos.contains(expPos)){   
            fail();
        }
    }

    /**
     * Test of getPitchers method, of class MockFantasyYahooService.
     */
    public void testGetPitchers() {
        System.out.println("getPitchers");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
            
        List<Player> pitch = instance.getPitchers();
        int expSize=25;
        int size = pitch.size();
        assertEquals(expSize, size);
        
        String expPos="P";
        String pos = pitch.get(rand.nextInt(expSize)).getDisplayPosition();
        if(!pos.contains(expPos)){   
            fail();
        }
    }

    /**
     * Test of connectApi method, of class MockFantasyYahooService.
     */
    public void testConnectApi() {
        System.out.println("connectApi");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
        instance.connectApi();
    }

    /**
     * Test of authorize method, of class MockFantasyYahooService.
     */
    public void testAuthorize() throws Exception {
        System.out.println("authorize");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
        instance.authorize();
    }

    /**
     * Test of hasAuthUrl method, of class MockFantasyYahooService.
     */
    public void testHasAuthUrl() {
        System.out.println("hasAuthUrl");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
        Boolean expResult = true;
        Boolean result = instance.hasAuthUrl();
        assertEquals(expResult, result);
    }

    /**
     * Test of isVerified method, of class MockFantasyYahooService.
     */
    public void testIsVerified() {
        System.out.println("isVerified");
        MockFantasyYahooService instance=null;
        try {
            instance = new MockFantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
"bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            instance.connectApi();
        Boolean expResult = true;
        Boolean result = instance.isVerified();
        assertEquals(expResult, result);
    }
}
