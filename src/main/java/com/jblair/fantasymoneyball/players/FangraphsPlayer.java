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
    private final int NUM_STATS=5; //only the stats that cost money
  
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
    
    public float getDraftProjection(DraftProjection draft){
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
    
    //pricing only matters for AVG, R, RBI, HR, SB
    public double pricePerStat(Stat stat){
        return getDraftProjection(DraftProjection.AVG_COST) / 5 / stats[stat.ordinal()];
    }
    
    public String toString(){
        return getFullName() + " $" + getDraftProjection(DraftProjection.AVG_COST) + " " +
                "\nPrice per R ("+ stats[Stat.R.ordinal()] +") :\t" + pricePerStat(Stat.R) +
                "\nPrice per RBI("+ stats[Stat.RBI.ordinal()] +"):\t" + pricePerStat(Stat.RBI) +
                "\nPrice per HR("+ stats[Stat.HR.ordinal()] +"):\t" + pricePerStat(Stat.HR) +
                "\nPrice per SB("+ stats[Stat.SB.ordinal()] +"):\t" + pricePerStat(Stat.SB) + "\n";
    }
}
