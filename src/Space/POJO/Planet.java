package Space.POJO;

import Space.POJO.ConstantData.Government;
import Space.POJO.ConstantData.Moon;
import Space.POJO.ConstantData.Resource;
import Space.POJO.ConstantData.StarSystem;
import Space.POJO.ConstantData.TechLevel;
import Space.POJO.Good.Goods;
import static Space.POJO.Good.Goods.FIREARMS;
import static Space.POJO.Good.Goods.FOOD;
import static Space.POJO.Good.Goods.FUR;
import static Space.POJO.Good.Goods.GAMES;
import static Space.POJO.Good.Goods.MACHINES;
import static Space.POJO.Good.Goods.MEDICINE;
import static Space.POJO.Good.Goods.NARCOTICS;
import static Space.POJO.Good.Goods.ORE;
import static Space.POJO.Good.Goods.ROBOTS;
import static Space.POJO.Good.Goods.WATER;
import Space.POJO.Good.Value;
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
    private final Value[] goodValues;
    private GoodTracker[] shopGT = new GoodTracker[10];
    private GoodTracker[] playerGT = new GoodTracker[10];

    
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
        this.goodValues = good;
        getListOfGoods(); 
    }
    
    public String getName(){
    	return this.name;
    }
    public Value[] getGoods() {
        return goodValues; 
    }
    public int getValue(Goods check){
    	return goodValues[(check).ordinal()].getV();
    }
    
    public int getQuantity(Goods check){
    	return goodValues[(check).ordinal()].getQ();
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
    
        public void getListOfGoods() {
        
        Goods[] goodTypes = {WATER, FUR, FOOD, ORE, GAMES, FIREARMS, MEDICINE, MACHINES, NARCOTICS, ROBOTS};
        int count = 0;
        int otherCount = 0;
        for(int i = 0; i < 10; i++) {
            if(goodValues[i].getQ() > 0) {
                shopGT[count] = new GoodTracker(goodTypes[i], goodValues[i]);
                count++;
            }
            if (goodValues[i].getV() > 0) {
                playerGT[otherCount] = new GoodTracker(goodTypes[i], goodValues[i]);
                otherCount++;
            }
        }
    }
        public Goods[] getGoodsList() {
            Goods[] goodTypes = {WATER, FUR, FOOD, ORE, GAMES, FIREARMS, MEDICINE, MACHINES, NARCOTICS, ROBOTS};
            return goodTypes;
        }
     public GoodTracker[] getGT() {
        return shopGT; 
    }
     
    public GoodTracker[] getPlayerGT() {
        return playerGT;
    }
    public class GoodTracker {
    

        private final Goods type;
        private final Value v;

        public GoodTracker(Goods type, Value v) {
            this.type = type;
            this.v = v;
    }
        public Goods getType() {
            return type; 
        }
    
}
}