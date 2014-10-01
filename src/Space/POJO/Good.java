/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Space.POJO;

/**
 *
 * @author Cameron
 */
public class Good extends MarketItem {
    
        
    public enum Goods{
        WATER("Water", 10, 20),
        FUR("Fur", 25, 45),
        FOOD("Food", 30, 50),
        ORE("Ore", 150, 800),
        GAMES("Games", 50, 200),
        FIREARMS("Firearms", 1500, 3000),
        MEDICINE("Medicine", 500, 2500),
        MACHINES("Machines", 900, 4000),
        NARCOTICS("Narcotics", 2000, 5000),
        ROBOTS("Robots", 1500, 6000);
        
        private final String name;
        private final int min;
        private final int max;
        
        Goods(String n, int min, int max){
            this.name = n;
            this.min = min;
            this.max = max;
        }
        
        @Override
        public String toString(){
            return name;
        }
        
        public int getMin(){
        	return min;
        }
        
        public int getMax(){
        	return max;
        }
    }
    public enum Value{
    	N(0,0),
    	S(5,0),
    	R(3,1),
    	C(1,3);
    	
    	private final int value;
    	private final int available;
    	
    	Value(int v, int a){
    		this.value = v;
    		this.available = a;
    	}
    	
    	public int getV(){
    		return value;
    	}
    	
    	public int getQ(){
    		return available;
    	}
    }

    public Good(Object typ, int stackHeight, int max) {
        super(typ, stackHeight, max);
    }
    
}
