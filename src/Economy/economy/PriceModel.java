package economy;

import java.util.Random;
import spacecowboys.ConstantData.Good;
import spacecowboys.Planet;

public class PriceModel{
	private final Planet location;
	private final Random rand = new Random();
	
	public PriceModel(Planet location){
		this.location = location;
	}
	
	private int getGoodValue(Good good){
		return location.getValue(good);
	}
	
	private int getGoodQuantity(Good good){
		return location.getQuantity(good);
	}
	
	private int randRange(int min, int max){
		return (int)((rand.nextDouble()*(max-min))+min);
	}
	
	public int showPrice(Good good){
		return randRange(good.getMin(), good.getMax())*getGoodValue(good);
	}
	
	public int showQuantity(Good good){
		return randRange(good.getMin(), good.getMax())*getGoodQuantity(good);
	}
}