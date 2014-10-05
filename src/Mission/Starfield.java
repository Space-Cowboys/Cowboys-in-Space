/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mission;
import java.util.Random;

/**
 *
 * @author Cameron
 */
public class Starfield {
    
    private final Random rand;
    private int maxX;
    private int maxY;
    private int maxsize;
    
    public Starfield(int maxX, int maxY, int maxsize){
        this.rand = new Random();
        this.maxsize = maxsize;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    
    private int randCoord(){
        return (int)rand.nextDouble()*maxY;
    }
    
    public Stardot createStar(double prob){
        if (prob < rand.nextDouble()){
            return new Stardot(this.randCoord());
        }
        else return null;
    }
}
