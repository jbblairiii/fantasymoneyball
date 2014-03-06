/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jblair.fantasymoneyball.players;

/**
 *
 * @author JB
 */
public class FangraphsPlayer {
    private String fullName;
    private Position[] positions;
    private double[] stats;
    private float[] draftProjections;
  
    public FangraphsPlayer(String name, String[] strStats){
        fullName = name;
        positions = new Position[3]; 
        draftProjections = new float[4];
        
        stats = new double[22];
        for(int stat=1; stat<stats.length; stat++){ //might be a pitcher, less stats
            //removes "" around stats
            stats[stat-1] = Double.parseDouble(strStats[stat].replaceAll("\"", "")); 
        }
    }
    
    public void setPositions(Position[] _pos){
        positions = _pos;
    }
    
    public void setStats(double[] _stats){
        stats = _stats;
    }
    
    public void setDraftProjections(float[] _proj){
        draftProjections = _proj;
    }
    
    public Position getPrimaryPosition(){
        return positions[0];
    }
    
    public Position getSecondaryPosition(){
        return positions[1] != null ? positions[1] : Position.NONE;
    }
    
    public Position getThirdPosition(){
        return positions[2] != null ? positions[2] : Position.NONE;
    }
    
    public double getStat(Stat stat){
        return stats[stat.ordinal()];
    }
    
    public float getDraftProject(DraftProjection draft){
        return draftProjections[draft.ordinal()];
    }
    
    public String getFirstName(){
        return fullName.split(" ")[0];
    }
    
    public String getLastName(){
        return fullName.split(" ")[1];
    }
    
    public String getFullName(){
        return fullName;
    }
}
