/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jblair.fantasymoneyball.adapters;

import com.jblair.fantasymoneyball.players.Player;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public Map<String, Player> load1B() {
        Map<String, Player> firstBasemen = new HashMap<String, Player>();
        String projections_1b = "projections/fans_1b.csv";
        BufferedReader reader = null;
        
       
        try {
            reader = new BufferedReader(new FileReader(projections_1b));
            //while((reader.readLine()) != null){
                     
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(FangraphsDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return firstBasemen;
    }
    
    
}
