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
public class Stardot {
    
    private final Random rand = new Random();
    private int size;
    private int axisPos;
    private final int maxSize = 10;
    
    public Stardot(int axis){
        this.size = (int)rand.nextDouble()*maxSize;
        this.axisPos = axis;
        
    }
    
}
