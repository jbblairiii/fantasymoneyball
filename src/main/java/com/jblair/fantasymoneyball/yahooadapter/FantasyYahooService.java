/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.yahooadapter;

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
