package spacecowboys;

import java.util.Random;
import spacecowboys.ConstantData.Government;
import spacecowboys.ConstantData.Resource;
import spacecowboys.ConstantData.TechLevel;
import spacecowboys.ConstantData.Moon;
import spacecowboys.ConstantData.StarSystem;
public class Universe{
    private Planet[] universe;
    public final Random rand = new Random();
    public Universe(int numPlanets){
        this.universe = new Planet[numPlanets];
        for (int i = 0; i < numPlanets; i++){
            universe[i] = new Planet("Planet" + Integer.toString(i), 
            Resource.values()[(int)(rand.nextDouble()*Resource.values().length)],
            TechLevel.values()[(int)(rand.nextDouble()*TechLevel.values().length)],
            Government.values()[(int)(rand.nextDouble()*Government.values().length)],
            Moon.values()[(int)(rand.nextDouble()*Moon.values().length)],
            (int)(rand.nextDouble()*10),
            (int)(rand.nextDouble()*10),
            (int)(rand.nextDouble()*10),
            StarSystem.values()[(int)((i*StarSystem.values().length)/numPlanets)],
            (int)(rand.nextDouble()*200),
            (int)(rand.nextDouble()*200));
        }
    }
    
    public Planet[] getPlanets(){
        return this.universe;
    }
    
    public static void main(String[] args){
        Universe u = new Universe(39);
        for (int i = 0; i < u.getPlanets().length; i++){
            System.out.println(u.getPlanets()[i]);
        }
    }
}