package Space.POJO;

import Space.POJO.Good.Goods;
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
		return randRange(good.getMin(), good.getMax())*getGoodValue(good);
	}
        
        public int showSalePrice(Goods good) {
            return randRange(good.getMin(), good.getMax())*getGoodValue(good) / 2;
        }
	
	public int showQuantity(Goods good){
		return randRange(good.getMin(), good.getMax())*getGoodQuantity(good);
	}
}