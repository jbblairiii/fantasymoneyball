/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.players.DraftProjection;
import com.jblair.fantasymoneyball.players.FangraphsPlayer;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBException;

/**
 *
 * @author JB
 */
public class FangraphYahooMerge {
    private FantasyYahooService yahooService;
    private FangraphsDownload fgDownload;
    private Map<String, FangraphsPlayer> firstBasemen, secondBasemen, thirdBasemen, shortstops, outfielders, catchers, pitchers;
    
    public FangraphYahooMerge() throws JAXBException{
        yahooService = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                                "bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");      
        yahooService.connectApi();
         
        
        fgDownload = new FangraphsDownload();
        
        loadAllPlayers();
        mergeEm();
    }

    private void loadAllPlayers(){
        System.out.println("Loading Fangraphs first basemen");
        firstBasemen=fgDownload.load1B();
        
        System.out.println("Loading Fangraphs second basemen");
        secondBasemen=fgDownload.load2B();
        
        System.out.println("Loading Fangraphs third basemen");
        thirdBasemen=fgDownload.load3B();
        
        System.out.println("Loading Fangraphs shortstops");
        shortstops=fgDownload.loadSS();
        
        System.out.println("Loading Fangraphs catchers");
        catchers=fgDownload.loadC();
        
        System.out.println("Loading Fangraphs outfielders");
        outfielders=fgDownload.loadOF();
        
        System.out.println("Loading Fangraphs pitchers");
        pitchers=fgDownload.loadP();
        
        System.out.println("DONE");
            
    }
    
    
    private void mergeEm(){
        System.out.println("Merging Fangraphs and Yahoo projections");
        mergePlayers(yahooService.getCatchers(), catchers);
        mergePlayers(yahooService.getFirstBasemen(), firstBasemen);
        mergePlayers(yahooService.getSecondBasemen(), secondBasemen);
        mergePlayers(yahooService.getThirdBasemen(), thirdBasemen);
        mergePlayers(yahooService.getShortstops(), shortstops);
        mergePlayers(yahooService.getOutfielders(), outfielders);
        mergePlayers(yahooService.getPitchers(), pitchers);
        System.out.println("DONE");
    }
    
    private void mergePlayers(List<Player> yplayers, Map<String, FangraphsPlayer> fplayers){
            
        for(Player player : yplayers){
            String fullName = player.getName().getAsciiFirst() + " " + player.getName().getAsciiLast();
            
            float[] projections = new float[4];
            
            float cost = player.getDraftAnalysis().getAverageCost();
            if(cost == 0){
                projections[DraftProjection.AVG_COST.ordinal()] = 1;
            }
            else {
                projections[DraftProjection.AVG_COST.ordinal()] = cost;  
            }
                   
            projections[DraftProjection.AVG_PICK.ordinal()] = player.getDraftAnalysis().getAveragePick();
            projections[DraftProjection.AVG_ROUND.ordinal()] = player.getDraftAnalysis().getAverageRound();
            projections[DraftProjection.PER_DRAFTED.ordinal()] = player.getDraftAnalysis().getPercentDrafted();
                
            FangraphsPlayer fgplayer = fplayers.get(fullName);
                      
            if(fgplayer != null){
                fgplayer.setDraftProjections(projections);
            }                       
        }
    }  
    
    public Map<String, FangraphsPlayer> getFirstBasemen() {
        return firstBasemen;
    }

    public Map<String, FangraphsPlayer> getSecondBasemen() {
        return secondBasemen;
    }

    public Map<String, FangraphsPlayer> getThirdBasemen() {
        return thirdBasemen;
    }

    public Map<String, FangraphsPlayer> getShortstops() {
        return shortstops;
    }


    public Map<String, FangraphsPlayer> getOutfielders() {
        return outfielders;
    }


    public Map<String, FangraphsPlayer> getCatchers() {
        return catchers;
    }


    public Map<String, FangraphsPlayer> getPitchers() {
        return pitchers;
    }
}
