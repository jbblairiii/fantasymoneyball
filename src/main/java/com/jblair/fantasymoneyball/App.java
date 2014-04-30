package com.jblair.fantasymoneyball;

import com.jblair.fantasymoneyball.adapters.FangraphYahooMerge;
import com.jblair.fantasymoneyball.adapters.FantasyYahooService;
import com.yahooapis.fantasysports.fantasy.v2.base.FantasyContent.League.Players.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, JAXBException, URISyntaxException
    {
        FantasyYahooService yahooService = new FantasyYahooService("dj0yJmk9U3pwQVJ2QmdNUzJNJmQ9WVdrOWJuTkphbk50TjJjbWNHbzlOall5TURBME9UWXkmcz1jb25zdW1lcnNlY3JldCZ4PWVl",
                                "bb740a758d4166a05d9f6ba23c982e7d96491e6a", "mlb.l.67468");         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        yahooService.connectApi();
        System.out.println("Player name");
        
        String last = in.readLine();
        
        while(!last.equalsIgnoreCase("q")){
            List<Player> players = yahooService.getPlayersByName(last);
             
            if(!players.isEmpty()){
                for(Player player : players){
                    System.out.println(player.getName().getFull());
                }
            }
            else{
                System.out.println(last + "not found");
            }
               
            
            last = in.readLine();
        }
    }
}
