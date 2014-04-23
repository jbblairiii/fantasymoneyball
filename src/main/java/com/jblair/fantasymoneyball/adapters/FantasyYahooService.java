/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.players.DraftProjection;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    private PrintWriter xmlWriter;
    private boolean saveXml;
    private int savedXmlCount=0;

    public FantasyYahooService(String key, String secret, String lkey) throws JAXBException {
        this(key, secret, lkey, false);
    }

    
    public FantasyYahooService(String key, String secret, String lkey, boolean save) throws JAXBException {
        yahooKey = key;
        yahooSecret = secret;
        leagueKey = lkey;
        jaxbContext = JAXBContext.newInstance("com.yahooapis.fantasysports.fantasy.v2.base");
        unmarshaller = jaxbContext.createUnmarshaller();
        
        if(save){
            saveXml=true;
            initXmlWriter();
        }
    }

    private void initXmlWriter(){
       try {
            savedXmlCount++;
            xmlWriter = new PrintWriter("saved_xml_"+savedXmlCount+".xml");
        } catch (IOException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        } 
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
        Response result = request(Verb.GET, requestURL);
        if(saveXml){
            xmlWriter.print(result.getBody());
            xmlWriter.close();
            initXmlWriter();
        }
        StringReader sr = new StringReader(result.getBody());

        FantasyContent response = null;
        try {
            response = (FantasyContent) unmarshaller.unmarshal(sr);
        } catch (JAXBException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return response.getLeague().getPlayers().getPlayer();
    }

    public List<Player> getPlayersByName(String last) {
        return getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;search=" + last.toLowerCase() + ";sort=OR;count=50/draft_analysis");
    }

    public List<Player> getCatchers() {
        List<Player> players25 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=C;sort=OR;count=25;/draft_analysis");
        List<Player> players50 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=C;sort=OR;start=25;count=25;/draft_analysis");
        List<Player> players75 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=C;sort=OR;start=50;count=25;/draft_analysis");
        List<Player> players100 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=C;sort=OR;start=75;count=25;/draft_analysis");


        players25.addAll(players50);
        players25.addAll(players75);
        players25.addAll(players100);

        return players25;
    }

    public List<Player> getFirstBasemen() {
        List<Player> players25 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=1B;sort=OR;count=25;/draft_analysis");
        List<Player> players50 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=1B;sort=OR;start=25;count=25;/draft_analysis");
        List<Player> players75 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=1B;sort=OR;start=50;count=25;/draft_analysis");
        List<Player> players100 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=1B;sort=OR;start=75;count=25;/draft_analysis");

        players25.addAll(players50);
        players25.addAll(players75);
        players25.addAll(players100);

        return players25;
    }

    public List<Player> getSecondBasemen() {
        List<Player> players25 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=2B;sort=OR;count=25;/draft_analysis");
        List<Player> players50 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=2B;sort=OR;start=25;count=25;/draft_analysis");
        List<Player> players75 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=2B;sort=OR;start=50;count=25;/draft_analysis");
        List<Player> players100 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=2B;sort=OR;start=75;count=25;/draft_analysis");

        players25.addAll(players50);
        players25.addAll(players75);
        players25.addAll(players100);

        return players25;
    }

    public List<Player> getThirdBasemen() {
        List<Player> players25 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=3B;sort=OR;count=25;/draft_analysis");
        List<Player> players50 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=3B;sort=OR;start=25;count=25;/draft_analysis");
        List<Player> players75 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=3B;sort=OR;start=50;count=25;/draft_analysis");
        List<Player> players100 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=3B;sort=OR;start=75;count=25;/draft_analysis");

        players25.addAll(players50);
        players25.addAll(players75);
        players25.addAll(players100);

        return players25;
    }

    public List<Player> getShortstops() {
        List<Player> players25 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=SS;sort=OR;count=25;/draft_analysis");
        List<Player> players50 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=SS;sort=OR;start=25;count=25;/draft_analysis");
        List<Player> players75 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=SS;sort=OR;start=50;count=25;/draft_analysis");
        List<Player> players100 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=SS;sort=OR;start=75;count=25;/draft_analysis");

        players25.addAll(players50);
        players25.addAll(players75);
        players25.addAll(players100);

        return players25;
    }

    public List<Player> getOutfielders() {
        List<Player> players25 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=OF;sort=OR;count=25;/draft_analysis");
        List<Player> players50 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=OF;sort=OR;start=25;count=25;/draft_analysis");
        List<Player> players75 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=OF;sort=OR;start=50;count=25;/draft_analysis");
        List<Player> players100 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=OF;sort=OR;start=75;count=25;/draft_analysis");

        players25.addAll(players50);
        players25.addAll(players75);
        players25.addAll(players100);

        return players25;
    }

    public List<Player> getPitchers() {
        List<Player> players25 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=P;sort=OR;count=25;/draft_analysis");
        List<Player> players50 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=P;sort=OR;start=25;count=25;/draft_analysis");
        List<Player> players75 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=P;sort=OR;start=50;count=25;/draft_analysis");
        List<Player> players100 = getPlayers("http://fantasysports.yahooapis.com/fantasy/v2/league/" + leagueKey + "/players;position=P;sort=OR;start=75;count=25;/draft_analysis");

        players25.addAll(players50);
        players25.addAll(players75);
        players25.addAll(players100);

        return players25;
    }

    public void connectApi() {
        try {
            authorize();
        } catch (IOException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Authorization Code:");
        String authCode = "";
        try {
            authCode = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FantasyYahooService.class.getName()).log(Level.SEVERE, null, ex);
        }

        verify(authCode);
    }

    public void authorize() throws IOException, URISyntaxException {
        authService = new ServiceBuilder()
                .provider(YahooApi.class)
                .apiKey(yahooKey)
                .apiSecret(yahooSecret)
                .build();

        requestToken = authService.getRequestToken();

        authUrl = authService.getAuthorizationUrl(requestToken);

        Desktop.getDesktop().browse(new URI(authUrl));
    }

    private void verify(String verification) {
        Verifier v = new Verifier(verification);
        accessToken = authService.getAccessToken(requestToken, v);
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
