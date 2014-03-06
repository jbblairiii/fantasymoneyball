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
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.bind.JAXBException;

/**
 *
 * @author JB
 */
public class MergeWhiteBox {
    public static void main(String[] args) throws JAXBException{
        
        FangraphYahooMerge allStats = new FangraphYahooMerge();
        Map<String, FangraphsPlayer> firstBasemen = allStats.getFirstBasemen();
        
        System.out.println(firstBasemen.get("Chris Davis").getDraftProject(DraftProjection.AVG_PICK));
    }
}
