/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.yahooadapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import junit.framework.TestCase;
import org.scribe.model.Response;
import org.scribe.model.Verb;

/**
 *
 * @author jb834r
 */
public class FantasyYahooServiceTest extends TestCase {
    
    
    public FantasyYahooService yahooService;
    public String authCode;
    
    public FantasyYahooServiceTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("Creating Yahoo Web Service");
        yahooService = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                            "bb740a758d4166a05d9f6ba23c982e7d96491e6a");
        yahooService.authorize();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Authorization Code:");
	authCode = in.readLine();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    /**
     * Test of verify method, of class FantasyYahooService.
     */
    public void testVerify() {
        System.out.println("verify");
        yahooService.verify(authCode);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(yahooService.isVerified());
    }

    /**
     * Test of request method, of class FantasyYahooService.
     */
    public void testRequest() {
        System.out.println("request");
        Verb type = Verb.GET;	
        String leagueKey = "mlb.l.67468";
        String requestURL =  "http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=SS";
        Response result = yahooService.request(type, requestURL);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(result.isSuccessful());
    }
}
