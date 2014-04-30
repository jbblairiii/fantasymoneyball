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
         
        PrintWriter hitters = new PrintWriter("hitters.txt");
        PrintWriter pitchers = new PrintWriter("pitchers.txt");
        PrintWriter wfirst = new PrintWriter("first.txt");
        PrintWriter wsecond = new PrintWriter("second.txt");
        PrintWriter wthird = new PrintWriter("third.txt");
        PrintWriter wshort = new PrintWriter("short.txt");
        PrintWriter wcatcher = new PrintWriter("catchers.txt");
        PrintWriter woutfielder = new PrintWriter("outfielders.txt");
        
        System.out.println("Writing results out");
        
        Map<String, FangraphsPlayer> firstBasemen = allStats.getFirstBasemen();
        for(Map.Entry<String, FangraphsPlayer> entry : firstBasemen.entrySet()){         
            hitters.println(entry.getValue());
            wfirst.println(entry.getValue());
        }
        
                
        Map<String, FangraphsPlayer> catchers = allStats.getCatchers();
        for(Map.Entry<String, FangraphsPlayer> entry : catchers.entrySet()){         
            hitters.println(entry.getValue());
            wcatcher.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> sec = allStats.getSecondBasemen();
        for(Map.Entry<String, FangraphsPlayer> entry : sec.entrySet()){         
            hitters.println(entry.getValue());
            wsecond.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> third = allStats.getThirdBasemen();
        for(Map.Entry<String, FangraphsPlayer> entry : third.entrySet()){         
            hitters.println(entry.getValue());
            wthird.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> shorts = allStats.getShortstops();
        for(Map.Entry<String, FangraphsPlayer> entry : shorts.entrySet()){         
            hitters.println(entry.getValue());
            wshort.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> out = allStats.getOutfielders();
        for(Map.Entry<String, FangraphsPlayer> entry : out.entrySet()){         
            hitters.println(entry.getValue());
            woutfielder.println(entry.getValue());
        }
        
        Map<String, FangraphsPlayer> pitch = allStats.getPitchers();
        for(Map.Entry<String, FangraphsPlayer> entry : pitch.entrySet()){         
            pitchers.println(entry.getValue());
        }
        
        hitters.close();
        pitchers.close();
        wfirst.close();
        wsecond.close();
        wthird.close();
        wshort.close();
        wcatcher.close();
        woutfielder.close();
        
        System.out.println("COMPLETE");
    }
}
