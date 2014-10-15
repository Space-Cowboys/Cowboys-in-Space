package Space.POJO;

import Space.POJO.Good.Goods;
import Space.controller.RootLayoutController;
import java.util.Random;


public class PriceModel{
	private final Planet location;
	private final Random rand = new Random();
	
	public PriceModel(Planet location){
		this.location = location;
	}
	
	private int getGoodValue(Goods good){
		return location.getValue(good);
	}
	
	private int getGoodQuantity(Goods good){
		return location.getQuantity(good);
	}
	
	private int randRange(int min, int max){
		return (int)((rand.nextDouble()*(max-min))+min);
	}
	
	public int showPrice(Goods good){
            int initial = randRange(good.getMin(), good.getMax())*getGoodValue(good);
            int change = (int) ((int) initial * (RootLayoutController.getCharismaSkill() * .005));        
            return initial - change; 
	} 
        
        public int showSalePrice(Goods good) {
            int initial = randRange(good.getMin(), good.getMax())*getGoodValue(good) /2;
            int change = (int) ((int) initial * (RootLayoutController.getCharismaSkill() * .005));        
            return initial + change; 
        }
	
	public int showQuantity(Goods good){
		return randRange(good.getMin(), good.getMax())*getGoodQuantity(good);
	}
}