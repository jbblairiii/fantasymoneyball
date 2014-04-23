/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters.mock;

import com.jblair.fantasymoneyball.adapters.*;
import com.jblair.fantasymoneyball.players.DraftProjection;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
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
public class MockFantasyYahooService {

    private String yahooKey, yahooSecret, leagueKey;
    private String authUrl;
    private OAuthService authService;
    private Token requestToken, accessToken;
    private JAXBContext jaxbContext;
    private Unmarshaller unmarshaller;

    public MockFantasyYahooService(String key, String secret, String lkey) throws JAXBException {
        yahooKey = key;
        yahooSecret = secret;
        leagueKey = lkey;
        jaxbContext = JAXBContext.newInstance("com.yahooapis.fantasysports.fantasy.v2.base");
        unmarshaller = jaxbContext.createUnmarshaller();
    }

    public float[] getDraftProjectionsFor(String first, String last) {
        float[] projections = new float[4];

        List<Player> playersWithLast = getPlayersByName(last);

        Player searchingFor = null;
        for (Player player : playersWithLast) {
            if (player.getName().getFirst().equalsIgnoreCase(first)) {
                searchingFor = player;
                break;
            }
        }

        projections[DraftProjection.AVG_COST.ordinal()] = searchingFor.getDraftAnalysis().getAverageCost();
        projections[DraftProjection.AVG_PICK.ordinal()] = searchingFor.getDraftAnalysis().getAveragePick();
        projections[DraftProjection.AVG_ROUND.ordinal()] = searchingFor.getDraftAnalysis().getAverageRound();
        projections[DraftProjection.PER_DRAFTED.ordinal()] = searchingFor.getDraftAnalysis().getPercentDrafted();

        return projections;
    }

    private List<Player> getPlayers(String requestURL) {
        //Response result = request(Verb.GET, requestURL);
        //StringReader sr = new StringReader(result.getBody());

        File xmlFile=null;
        
        if(requestURL.equalsIgnoreCase("catcher")){
            xmlFile=new File("src/test/mock_xml/c.xml");
        }
        else if(requestURL.equalsIgnoreCase("pitcher")){
            xmlFile=new File("src/test/mock_xml/p.xml");
        }
        else if(requestURL.equalsIgnoreCase("first")){
            xmlFile=new File("src/test/mock_xml/1b.xml");
        }
        else if(requestURL.equalsIgnoreCase("second")){
            xmlFile=new File("src/test/mock_xml/2b.xml");
        }
        else if(requestURL.equalsIgnoreCase("third")){
            xmlFile=new File("src/test/mock_xml/3b.xml");
        }
        else if(requestURL.equalsIgnoreCase("short")){
            xmlFile=new File("src/test/mock_xml/ss.xml");
        }
        else if(requestURL.equalsIgnoreCase("out")){
            xmlFile=new File("src/test/mock_xml/of.xml");
        }

        FantasyContent response = null;
        try {
            response = (FantasyContent) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException ex) {
            Logger.getLogger(MockFantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return response.getLeague().getPlayers().getPlayer();
    }

    public List<Player> getPlayersByName(String last) {
        return getPlayers("yahh");
    }

    public List<Player> getCatchers() {
         return getPlayers("catcher");
    }

    public List<Player> getFirstBasemen() {
         return getPlayers("first");
    }

    public List<Player> getSecondBasemen() {
         return getPlayers("second");
    }

    public List<Player> getThirdBasemen() {
         return getPlayers("third");
    }

    public List<Player> getShortstops() {
         return getPlayers("short");
    }

    public List<Player> getOutfielders() {
         return getPlayers("out");
    }

    public List<Player> getPitchers() {
         return getPlayers("pitcher");
    }

    public void connectApi() {
        try {
            authorize();
        } catch (IOException ex) {
            Logger.getLogger(MockFantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MockFantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Authorization Code:");
        String authCode = "";
        try {
            //authCode = in.readLine();
            authCode = "AUTHCODE";
            
            if(false){throw new IOException();}
            
        } catch (IOException ex) {
            Logger.getLogger(MockFantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        }

        verify(authCode);
    }

    public void authorize() throws IOException, URISyntaxException {
        authService = new ServiceBuilder()
                .provider(YahooApi.class)
                .apiKey(yahooKey)
                .apiSecret(yahooSecret)
                .build();

        //requestToken = authService.getRequestToken();
        requestToken = new Token("i am" , "a request");

        //authUrl = authService.getAuthorizationUrl(requestToken);
        authUrl = "i am an auth url";

        //Desktop.getDesktop().browse(new URI(authUrl));
    }

    private void verify(String verification) {
        //Verifier v = new Verifier(verification);
        //accessToken = authService.getAccessToken(requestToken, v);
        accessToken = new Token("key","secret");
    }

    private Response request(Verb type, String requestURL) {
        OAuthRequest request = new OAuthRequest(type, requestURL);
        authService.signRequest(accessToken, request); // the access token from step 4
        Response response = request.send();
        return response;
    }

    public Boolean hasAuthUrl() {
        return (authUrl != null);
    }

    public Boolean isVerified() {
        return (!accessToken.isEmpty());
    }
}
