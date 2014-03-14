/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball;

import com.jblair.fantasymoneyball.adapters.FantasyYahooService;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.util.List;
import java.util.Random;
import javax.xml.bind.JAXBException;

/**
 *
 * @author JB
 */
public class FantasyYahooServiceWhiteBox {
    public static void main(String[] args) throws JAXBException{
        FantasyYahooService yahooService = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                                "bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");
        
        yahooService.connectApi();        
              
        Random rand = new Random();
        
        List<Player> firstBasemen = yahooService.getFirstBasemen();  
        String pos = firstBasemen.get(rand.nextInt(firstBasemen.size())).getDisplayPosition();
        if(pos.contains("1B")){
            System.out.println("Got " + firstBasemen.size() + " first basemen");
        }
        else {
            System.err.println("Couldn't retrieve first basemen " + pos);
        }
        
        List<Player> secondBasemen = yahooService.getSecondBasemen();  
        pos = secondBasemen.get(rand.nextInt(secondBasemen.size())).getDisplayPosition();
        if(pos.contains("2B")){
            System.out.println("Got the second basemen");
        }
        else {
            System.err.println("Couldn't retrieve second basemen " + pos);
        }
        
        List<Player> thirdBasemen = yahooService.getThirdBasemen();  
        pos = thirdBasemen.get(rand.nextInt(thirdBasemen.size())).getDisplayPosition();
        if(pos.contains("3B")){
            System.out.println("Got the third basemen");
        }
        else {
            System.err.println("Couldn't retrieve third basemen " + pos);
        }
              
        List<Player> shortstops = yahooService.getShortstops();  
        pos = shortstops.get(rand.nextInt(shortstops.size())).getDisplayPosition();
        if(pos.contains("SS")){
            System.out.println("Got the shortstops");
        }
        else {
            System.err.println("Couldn't retrieve shortstops " + pos);
        }
        
        List<Player> outfield = yahooService.getOutfielders();  
        pos = outfield.get(rand.nextInt(outfield.size())).getDisplayPosition();
        if(pos.contains("OF")){
            System.out.println("Got the outfielders.");
        }
        else {
            System.err.println("Couldn't retrieve outfielders " + pos);
        }
        
        List<Player> catchers = yahooService.getCatchers();  
        pos = catchers.get(rand.nextInt(catchers.size())).getDisplayPosition();
        if(pos.contains("C")){
            System.out.println("Got the catchers");
        }
        else {
            System.err.println("Couldn't retrieve catchers " + pos);
        }
        
        List<Player> pitchers = yahooService.getPitchers();  
        pos = pitchers.get(rand.nextInt(pitchers.size())).getDisplayPosition();
        if(pos.contains("P")){
            System.out.println("Got the pitchers");
        }
        else {
            System.err.println("Couldn't retrieve pitchers " + pos);
        }
                     
    }
}
