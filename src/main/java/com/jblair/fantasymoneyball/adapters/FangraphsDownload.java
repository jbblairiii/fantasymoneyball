/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.players.FangraphsPlayer;
import com.jblair.fantasymoneyball.players.Position;
import com.jblair.fantasymoneyball.players.Stat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JB
 */
public class FangraphsDownload {
    private static final String COMMA = ",";

    public Map<String, FangraphsPlayer> loadC(){
        String[] filenames = {"projections/fans_c.csv"};
        return loadStats(filenames);
    }
    
    public Map<String, FangraphsPlayer> load1B(){
        String[] filenames = {"projections/fans_1b.csv"};
        return loadStats(filenames);
    }
    
    public Map<String, FangraphsPlayer> load2B(){
        String[] filenames = {"projections/fans_2b.csv"};
        return loadStats(filenames);
    }
    
    public Map<String, FangraphsPlayer> load3B(){
        String[] filenames = {"projections/fans_3b.csv"};
        return loadStats(filenames);
    }
    
    public Map<String, FangraphsPlayer> loadSS(){
        String[] filenames = {"projections/fans_ss.csv"};
        return loadStats(filenames);
    }
    
    public Map<String, FangraphsPlayer> loadOF(){
        String[] filenames = {"projections/fans_of1.csv"};
        return loadStats(filenames);
    }
    
    public Map<String, FangraphsPlayer> loadP(){
        String[] filenames = {"projections/fans_p1.csv"};
        return loadStats(filenames);
    }
    
    //helper for all of the load by specific position
    private Map<String, FangraphsPlayer> loadStats(String[] filenames) {
        Map<String, FangraphsPlayer> playerMap = new HashMap<String, FangraphsPlayer>();
        BufferedReader reader = null;
        String line = "";
        
        for(String file : filenames){
            Boolean header=true;
            try {
                reader = new BufferedReader(new FileReader(file));   
                             
                while((line = reader.readLine()) != null){
                    if(header){header=false; continue;} // skips the header line
                    
                    // splits the file on commas and remove quotes
                    String[] projections = line.split(COMMA); 
                    String fullName = projections[0]
                                        .replaceAll("\"", "");
                    
                    FangraphsPlayer newPlayer = new FangraphsPlayer(fullName, projections); 
                    playerMap.put(fullName, newPlayer);
                }
            } 
            catch (IOException io){

            }
        }
               
        return playerMap;
    }
    
    
}
