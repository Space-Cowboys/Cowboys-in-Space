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
    
    /*
    IMPORTANT
    In order for the Inventory class to work,
    MarketItem must have several things.
    */

    public boolean isMaxed(){
        //TO-DO returns true if the Amount == the Capcity
        return false;
    }



    public int getAmount() {
        //TO-DO: gets the amount of the item in the stack
        return 0;
    }


    
    public void setAmount(int amount){
        //TO-DO: sets the amoutn of the items stack
    }


   
    public int getCapacity() {
        //TO-DO: returns max capacity of item's stack
        return 0;
    }



    public boolean equals(MarketItem item) {
        //TO-DO: checks to see if two items are the same regardless of items
        // in the stack
        return false;
    }


    
    @Override
    public String toString() {
        //TO-DO: Returns the item name and the amount in the stack
        return "";
    }

    

    
}
