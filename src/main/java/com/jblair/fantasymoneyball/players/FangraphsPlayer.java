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
    private final String DELIM=",";
  
    public FangraphsPlayer(String name, String[] strStats, Position primary){
        fullName = name;
        positions = new Position[3]; 
        draftProjections = new float[4];
        draftProjections[DraftProjection.AVG_COST.ordinal()] = 1; //no yahoo
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
        if(getStat(stat) == 0){
            return 0;
        }
        return getDraftProjection(DraftProjection.AVG_COST) / 5 / getStat(stat);
    }
    public double pricePerStat(PitcherStat stat){
        if(getStat(stat) == 0){
            return 0;
        }
        return getDraftProjection(DraftProjection.AVG_COST) / 5 / getStat(stat);
    }
    
    public String toString(){
        if(isHitter){
            return getFullName() + DELIM + getDraftProjection(DraftProjection.AVG_COST) + 
                    DELIM+ getStat(HitterStat.AVG) +
                    DELIM+ getStat(HitterStat.R)+DELIM + pricePerStat(HitterStat.R) +
                    DELIM+ getStat(HitterStat.RBI) +DELIM + pricePerStat(HitterStat.RBI) +
                    DELIM+ getStat(HitterStat.HR) +DELIM + pricePerStat(HitterStat.HR) +
                    DELIM+ getStat(HitterStat.SB) +DELIM + pricePerStat(HitterStat.SB) +
                    DELIM + getStat(HitterStat.WAR)+DELIM+pricePerStat(HitterStat.WAR);
        }
        else if (isPitcher){
            return getFullName() + DELIM + getDraftProjection(DraftProjection.AVG_COST) + 
                    DELIM+ getStat(PitcherStat.ERA) +
                    DELIM+ getStat(PitcherStat.WHIP)+
                    DELIM+ getStat(PitcherStat.W) +DELIM + pricePerStat(PitcherStat.W) +
                    DELIM+ getStat(PitcherStat.SO) +DELIM + pricePerStat(PitcherStat.SO) +
                    DELIM+ getStat(PitcherStat.SV) +DELIM + pricePerStat(PitcherStat.SV) +
                    DELIM + getStat(PitcherStat.WAR)+DELIM+pricePerStat(PitcherStat.WAR);
        }
        return "";
    }
}
