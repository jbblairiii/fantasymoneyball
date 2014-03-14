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
    private boolean isPitcher, isHitter;
  
    public FangraphsPlayer(String name, String[] strStats, Position primary){
        fullName = name;
        positions = new Position[3]; 
        draftProjections = new float[4];
        positions[0] = primary;
        
        if(primary == primary.START || primary == primary.CLOSER || primary == primary.RELIEF){
            stats = new double[17];
            isPitcher=true;
            isHitter=false;
        }
        else {
            stats = new double[22];
            isHitter=true;
            isPitcher=false;
        }
               
        for(int stat=1; stat<=stats.length; stat++){ //might be a pitcher, less stats
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
    
    public double getStat(HitterStat stat){
        return stats[stat.ordinal()];
    }
    
    public double getStat(PitcherStat stat){
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
    public double pricePerStat(HitterStat stat){
        return getDraftProjection(DraftProjection.AVG_COST) / 5 / stats[stat.ordinal()];
    }
    public double pricePerStat(PitcherStat stat){
        return getDraftProjection(DraftProjection.AVG_COST) / 5 / stats[stat.ordinal()];
    }
    
    public String toString(){
        if(isHitter){
            return getFullName() + "|" + getDraftProjection(DraftProjection.AVG_COST) + 
                    "|"+ getStat(HitterStat.AVG) +
                    "|"+ getStat(HitterStat.R)+"|" + pricePerStat(HitterStat.R) +
                    "|"+ getStat(HitterStat.RBI) +"|" + pricePerStat(HitterStat.RBI) +
                    "|"+ getStat(HitterStat.HR) +"|" + pricePerStat(HitterStat.HR) +
                    "|"+ getStat(HitterStat.SB) +"|" + pricePerStat(HitterStat.SB) +
                    "|" + getStat(HitterStat.WAR)+"|"+pricePerStat(HitterStat.WAR);
        }
        else if (isPitcher){
            return getFullName() + "|" + getDraftProjection(DraftProjection.AVG_COST) + 
                    "|"+ getStat(PitcherStat.ERA) +
                    "|"+ getStat(PitcherStat.WHIP)+
                    "|"+ getStat(PitcherStat.W) +"|" + pricePerStat(PitcherStat.W) +
                    "|"+ getStat(PitcherStat.SO) +"|" + pricePerStat(PitcherStat.SO) +
                    "|"+ getStat(PitcherStat.SV) +"|" + pricePerStat(PitcherStat.SV) +
                    "|" + getStat(PitcherStat.WAR)+"|"+pricePerStat(PitcherStat.WAR);
        }
        return "";
    }
}
