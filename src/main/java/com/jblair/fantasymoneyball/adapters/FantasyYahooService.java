/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author jb834r
 */
public class FantasyYahooService {
    
    private String yahooKey, yahooSecret, leagueKey;
    private String authUrl;
    private OAuthService authService;
    private Token requestToken, accessToken;
    private JAXBContext jaxbContext;
    private Unmarshaller unmarshaller;
    
    public FantasyYahooService(String key, String secret, String lkey) throws JAXBException{
        yahooKey=key;
        yahooSecret=secret;
        leagueKey=lkey;
        jaxbContext = JAXBContext.newInstance("com.yahooapis.fantasysports.fantasy.v2.base");
        unmarshaller = jaxbContext.createUnmarshaller();
    }
     
    private List<Player> getPlayers(String requestURL){
        Response result = request(Verb.GET, requestURL);
        StringReader sr = new StringReader(result.getBody());
             
        FantasyContent response=null;
        try {
            response = (FantasyContent) unmarshaller.unmarshal(sr);
        } catch (JAXBException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return response.getLeague().getPlayers().getPlayer();
    }
      
    public List<Player> getCatchers(){
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=C/draft_analysis");
    }
    
    public List<Player> getFirstBasemen(){
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=1B/draft_analysis");
    }
    
    public List<Player> getSecondBasemen(){
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=2B/draft_analysis");
    }
    
    public List<Player> getThirdBasemen(){
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=3B/draft_analysis");
    }
    
    public List<Player> getShortstops(){
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=SS/draft_analysis");
    }
    
    public List<Player> getOutfielders(){
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=OF/draft_analysis");
    }
    
    public List<Player> getPitchers(){
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=P/draft_analysis");
    }
       
    
    public void connectApi(){
        try {
            authorize();
        } catch (IOException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Authorization Code:");
        String authCode="";
        try {
            authCode = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        verify(authCode);
    }
    
    public void authorize() throws IOException, URISyntaxException{
        authService = new ServiceBuilder()
			.provider(YahooApi.class)
			.apiKey(yahooKey)
			.apiSecret(yahooSecret)
			.build();
		
        requestToken = authService.getRequestToken();

        authUrl = authService.getAuthorizationUrl(requestToken);
 
        Desktop.getDesktop().browse(new URI(authUrl));
    }
    
    private void verify(String verification){
        Verifier v = new Verifier(verification);
	accessToken = authService.getAccessToken(requestToken, v);
    }
    
    private Response request(Verb type, String requestURL){
        OAuthRequest request = new OAuthRequest(type, requestURL);
        authService.signRequest(accessToken, request); // the access token from step 4
        Response response = request.send();
        return response;
    }
    
    public Boolean hasAuthUrl(){
        return (authUrl!=null);
    }
    
    public Boolean isVerified(){
        return (!accessToken.isEmpty());
    }
}
