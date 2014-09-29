package player;

import spacecowboys.Planet;

public class Player{
    private final String name;
    private Planet location;
	
    private int water;
    private int fur;
    private int food;
    private int ore;
    private int games;
    private int firearms;
    private int medicine;
    private int machines;
    private int narcotics;
    private int robots;
	
    private int pilot;
    private int engineering;
    private int charisma;
    private int luck;
    private int xp;
    private int level;
    private int credits;
    private int rep;
    private int skillPoints;
    private int fuel;
    
    public Player(String name){
    	this.name = name;
    }
    
    public Planet getLocation(){
        return location;
    }
    
    public void setLocation(Planet p){
        this.location = p;
    }
}