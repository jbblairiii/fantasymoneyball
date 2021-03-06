/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.adapters.FantasyYahooService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import junit.framework.TestCase;
import org.scribe.exceptions.OAuthException;
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
        
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of authorize method, of class FantasyYahooService.
     */
    public void testAuthorize() {
        System.out.println("Creating Yahoo Web Service");
        try {
            yahooService = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                                "bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            fail("Failed to create JAXB context");
        }
        try{
            yahooService.authorize();
        }
        catch(IOException e){
            fail("Failed to connect to Yahoo! Authorization");
        }
        catch(URISyntaxException u){
            fail("Invalid URL for Yahoo! Authorization");
        }
        
        assertTrue(yahooService.hasAuthUrl());
        try {
            yahooService = new FantasyYahooService("BAAAD KEY",
                                "bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        } catch (JAXBException ex) {
            fail("Failed to create JAXB context");
        }
        try{
            yahooService.authorize();
        }
        catch(IOException e){
            fail("Failed to connect to Yahoo! Authorization");
        }
        catch(URISyntaxException u){
            fail("Invalid URL for Yahoo! Authorization");
        }
        catch(OAuthException o){
            System.out.println("Passed with bad key");
            assertTrue(!yahooService.hasAuthUrl());
        }
        try {
            yahooService = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                                "BAAAD SECRET", "mlb.l.67468");
        } catch (JAXBException ex) {
            fail("Failed to create JAXB context");
        }
        try{
            yahooService.authorize();
        }
        catch(IOException e){
            fail("Failed to connect to Yahoo! Authorization");
        }
        catch(URISyntaxException u){
            fail("Invalid URL for Yahoo! Authorization");
        }
        catch(OAuthException o){
            System.out.println("Passed with bad secret");
            assertTrue(!yahooService.hasAuthUrl());
        }     
    }
}

