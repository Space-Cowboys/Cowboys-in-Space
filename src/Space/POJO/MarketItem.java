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
public class MarketItem {

    private final Object type;
    private int current;
    private final int maximum;

    public MarketItem(Object typ, int cur, int max){
        this.type = typ;
        this.current = cur;
        this.maximum = max;
    }
    
    public Object getType(){
        return type;
    }
    
    public int getAmount(){
        return current;
    }
    

    public boolean isMaxed(){
        return current == maximum;
    }


    
    public void setAmount(int amount){
        this.current = amount;
    }


   
    public int getCapacity() {
        return maximum;
    }



    public boolean equals(MarketItem item) {
        if( item != null) {
            return this.type.equals(item.type);
        }
        return false;
    }


    
    @Override
    public String toString() {
        return type.toString() + "\t" + Integer.toString(current);
    }

    

    
}
