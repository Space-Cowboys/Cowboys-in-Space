/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package economy;

/**
 *
 * @author Cameron
 */
public class MarketItem {
    
    private final Object type;
    private final int height;
    
    public MarketItem(Object typ, int stackHeight){
        this.type = typ;
        this.height = stackHeight;
    }
    
    public Object getType(){
        return type;
    }
    
    public int getHeight(){
        return height;
    }
}
