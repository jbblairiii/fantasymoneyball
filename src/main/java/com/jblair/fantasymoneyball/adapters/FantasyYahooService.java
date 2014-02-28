/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

/**
 *
 * @author jb834r
 */
public class FantasyYahooService {
    
    private String yahooKey, yahooSecret;
    private String authUrl;
    private OAuthService authService;
    private Token requestToken, accessToken;
    
    public FantasyYahooService(String key, String secret){
        yahooKey=key;
        yahooSecret=secret;
    }
    
    public static void main(String[] args) throws IOException, URISyntaxException{
        FantasyYahooService fantasyAPI = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                            "bb740a758d4166a05d9f6ba23c982e7d96491e6a");
        
        fantasyAPI.authorize();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Authorization Code:");
	String authCode = in.readLine();
        
        fantasyAPI.verify(authCode);
        
        Verb type = Verb.GET;	
        String leagueKey = "mlb.l.67468";
        String requestURL =  "http://fantasysports.yahooapis.com/fantasy/v2/league/"+leagueKey+"/players;position=1B/draft_analysis";
        Response result = fantasyAPI.request(type, requestURL);
        
        System.out.println(result.getBody());
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
    
    public void verify(String verification){
        Verifier v = new Verifier(verification);
	accessToken = authService.getAccessToken(requestToken, v);
    }
    
    public Response request(Verb type, String requestURL){
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
