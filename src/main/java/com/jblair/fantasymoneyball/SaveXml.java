/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball;

import com.jblair.fantasymoneyball.adapters.FangraphYahooMerge;
import com.jblair.fantasymoneyball.adapters.FantasyYahooService;
import com.jblair.fantasymoneyball.players.DraftProjection;
import com.jblair.fantasymoneyball.players.FangraphsPlayer;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.bind.JAXBException;

/**
 *
 * @author JB
 */
public class SaveXml {
    public static void main(String[] args) throws JAXBException, FileNotFoundException{
        
        FantasyYahooService yahooService = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                                "bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468", true);      
        yahooService.connectApi();
        
        yahooService.getFirstBasemen();
        yahooService.getSecondBasemen();
        yahooService.getThirdBasemen();
        yahooService.getShortstops();
        yahooService.getOutfielders();
        yahooService.getCatchers();
        yahooService.getPitchers();

    }
}
