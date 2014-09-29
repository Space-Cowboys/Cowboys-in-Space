package spacecowboys;

import economy.Good.Goods;
import spacecowboys.ConstantData.Government;
import spacecowboys.ConstantData.Moon;
import spacecowboys.ConstantData.Resource;
import spacecowboys.ConstantData.StarSystem;
import spacecowboys.ConstantData.TechLevel;
import economy.Good.Value;

public class Planet{
    private final String name;
    private final Resource res;
    private final TechLevel tech;
    private final Government gov;
    private final Moon moon;
    private final int pirates;
    private final int traders;
    private final int police;
    private final StarSystem sys;
    private final int X;
    private final int Y;
    private final Value[] goods;
    
    public Planet(String name, Resource res, TechLevel tech, Government gov, Moon moon, int pirates, int traders, int police, StarSystem sys, int X, int Y, Value[] good){
        this.name = name;
        this.res = res;
        this.tech = tech;
        this.gov = gov;
        this.moon = moon;
        this.pirates = pirates;
        this.traders = traders;
        this.police = police;
        this.sys = sys;
        this.X = X;
        this.Y = Y;
        this.goods = good;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public int getValue(Goods check){
    	return goods[(check).ordinal()].getV();
    }
    
    public int getQuantity(Goods check){
    	return goods[(check).ordinal()].getQ();
    }
    
    @Override
    public String toString(){
        return name + "\t" +
        res.toString() + "\t" + 
        tech.toString() + "\t" +
        gov.toString() + "\t" +
        moon.toString() + "\t" +
        "Pirates: " + Integer.toString(pirates) + "\t" +
        "Traders: " + Integer.toString(traders) + "\t" +
        "Police: " + Integer.toString(police) + "\t" +
        sys.toString() + "\t" +
        "X-coord: " + Integer.toString(X) + "\t" +
        "Y-coord: " + Integer.toString(Y);
    }
}