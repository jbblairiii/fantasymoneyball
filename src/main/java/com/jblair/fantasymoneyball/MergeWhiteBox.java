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
public class MergeWhiteBox {
    public static void main(String[] args) throws JAXBException, FileNotFoundException{
        
        FangraphYahooMerge allStats = new FangraphYahooMerge();
        Map<String, FangraphsPlayer> firstBasemen = allStats.getFirstBasemen();
         
        PrintWriter writer = new PrintWriter("hitters.txt");
        PrintWriter writer2 = new PrintWriter("pitchers.txt");
        
        for(Map.Entry<String, FangraphsPlayer> entry : firstBasemen.entrySet()){         
            writer.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> catchers = allStats.getCatchers();
        for(Map.Entry<String, FangraphsPlayer> entry : catchers.entrySet()){         
            writer.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> sec = allStats.getSecondBasemen();
        for(Map.Entry<String, FangraphsPlayer> entry : sec.entrySet()){         
            writer.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> third = allStats.getThirdBasemen();
        for(Map.Entry<String, FangraphsPlayer> entry : third.entrySet()){         
            writer.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> shorts = allStats.getShortstops();
        for(Map.Entry<String, FangraphsPlayer> entry : shorts.entrySet()){         
            writer.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> out = allStats.getOutfielders();
        for(Map.Entry<String, FangraphsPlayer> entry : out.entrySet()){         
            writer.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> pitch = allStats.getPitchers();
        for(Map.Entry<String, FangraphsPlayer> entry : pitch.entrySet()){         
            writer2.println(entry.getValue());
        }
        
        writer.close();
        writer2.close();
    }
}
