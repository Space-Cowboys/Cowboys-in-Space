/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Space.POJO;

import Space.POJO.Good.Goods;
import java.util.NoSuchElementException;
import org.omg.CORBA.DynAnyPackage.InvalidValue;


/** 
 * This is the inventory class. This class is standalone in the
 * fact that the controller that calls it does not have to throw
 * exceptions related to the inventory implementations. One of the
 * goals of this class is to make it as robust as possible for easy
 * debugging. 
 *
 *
 * @author Shari (CodeName: Sinister)
 * @version 1.0  Sept 29, 2014.
 */
public class Inventory {
	
	/** Maximum Capacity of the Inventory; Can be extended */
	private static int maxCapacity;

	/** The amount of stacks of items in the inventory */
	private static int occupation;

	/** The array of MarketItems */
	private static MarketItem [] stash; //Goods

	/** 
	 * Creates new inventory.
	 * IMPORTANT!!!!!
	 * DO NOT attempt to directly access stash
	 * DO NOT add/remove/edit/print stash[0], it should
	 * always remain empty;
	 * 
	 * @param maxCap the max capacity for the inventory
	 **/
	//public int getCapacity();
	public Inventory(int maxCap) {
		stash =  new MarketItem[maxCap];
		maxCapacity = maxCap;
		occupation = 0;
	}

        public int indexOf(MarketItem item) {
            int index = -1;
            for(int i = 0; i <= occupation; i++) {
                if(item.equals(stash[i])) {
                    index = i;
		}
            }
            return index;
        }
	
	/** 
	 * Stores Market item into the inventory stash
	 *
	 * 
	 * @param item that needs to be added to the stash
	 **/
	public void store(MarketItem  item) {
		if(hasSpace()) {
			stash[occupation + 1] = item;
		}
		/*if(!hasSpace()) {
			throw new IndexOutOfBoundsException("There is not "
                                + "space in Inventory");
		}*/

		/*int possibleIndex = getStore(item);
		if(possibleIndex != 0) {
			addToStack(possibleIndex, item);

		} else if (possibleIndex == 0) {
			
			stash[getEmptySlot()] = item;
			occupation++;
		}*/
                occupation++;

	}

	private int getEmptySlot() {
                for (int i = 1; i < occupation+1; i++) {
                    if(stash[i] == null) {
                        return i;
                    }
		}
		return 0;
        }
	/** 
	 * This store method is only used to create a MarketItem at the same
	 * instance it is being stored
	 * 
	 * @param item that needs to be added to the stash and
	 *  can be passed through as "new MarketItem(Resource good)"
	 *  for quick additions without the controller calling MarketItem
	 * @param amount of the item to be stored in inventory
	 **/
	public void store(MarketItem  item, int amount) {
		item.setAmount(amount);
		store(item);

	}
	/** 
	 * 
	 *
	 * 
	 * @param item that needs to be removed from the stash and
	 *  can be passed through as "new MarketItem(Resource good)"
	 *  for quick removals without the controller creating the item
	 *  to remove
	 * @param amount of the item to be removed from the inventory
	 * @return MarketItem removed which still holds the amount removed
	 **/
	public MarketItem remove(MarketItem  item, int amount) {
            int index = indexOf(item);
            stash[index].setAmount(totalItemCount(item) - amount);
            return item;
	}
	/** 
	 * Removes an item from the inventory. The method will not remove
	 * an item at the quantity that is more than what the inventory holds
	 * To check if a certain amount of the item exists, call the 
	 * totalItemCount method on the inventory before trying. Null items
	 * and items with no amount existing cannot be removed unless. 
	 * If need be this can easily changed by setting editing the 2nd
	 * conditional to simply "return item;"
	 *
	 * @param item that needs to be removed from the stash and
	 *  can be passed through as "new MarketItem(Resource good)"
	 *  for quick removals without the controller creating the item
	 *  to remove
	 * @return MarketItem removed which still holds the amount removed* 
         * @throws NullPointerException is item to remove is not valid
         * @throws NoSuchElementException if item has no amount, its not stored 
         * or an attempt to remove more than what is available to remove is made
	 **/
	public MarketItem remove(MarketItem  item) throws NullPointerException,
                NoSuchElementException {
		
		if (item == null) {
			throw new NullPointerException("Item is not a "
                                + "valid MarketItem");
		}
		if (item.getAmount() == 0) {
			throw new NoSuchElementException("There is not amount of the "
                                + "MarketItem to remove from the inventory");
		}
		if (!isStored(item)) {
			throw new NoSuchElementException("The item is not in "
                                + "the inventory");
		}

		if (item.getAmount() > totalItemCount(item)) {
			throw new NoSuchElementException("Cannot remove more "
                                + "of a resource than available");
		}/*
		int possibleIndex = getStore(item);
		int stackDeficit;

		if (possibleIndex != 0) {
			stackDeficit = stash[possibleIndex].getAmount() 
                                - item.getAmount();
		} else {
			for (int i = occupation; i > 1; i--) {
				if (stash[i].equals(item)) {
					possibleIndex = i;
				}
			}
			stackDeficit = stash[possibleIndex].getAmount() 
                                - item.getAmount();
		}

		
		if (stackDeficit == 0) { //then item was completely removed
			stash[possibleIndex] = null;
		} else if (stackDeficit > 0) { //still parts left in stash 
                                               //stack after remove
			stash[possibleIndex].setAmount(stackDeficit);
		} else if (stackDeficit < 0) {
			stash[possibleIndex] = null;
			stackDeficit = -1 * stackDeficit;
                        remove(item, stackDeficit);
		}*/
                

		occupation--;
                return item;
	
	}
	/** 
	 * Tracks the total amount of an item that exists in the inventory
	 * regardless of how many stacks of it exists. 
	 *
	 * 
	 * @param item to count
	 * @return amount of the item that exists in the inventory
	 **/
	//oest through entire inventory and counts the amount of a specific item
	public static int totalItemCount(MarketItem item) {
		int count = 0;
		for(int i = 0; i <= occupation; i++) {
			if(item.equals(stash[i])) {
				count = stash[i].getAmount();
			}
		}
		return count;
	}

        public static int[] quantityCount() {
            int[] quantity = new int[10];
            Goods[] planetGoods = Planet.getGoodsList();
            MarketItem[] marketItemList = new MarketItem[10];
            for(int i = 0; i < planetGoods.length;i++) {
                marketItemList[i] = new MarketItem(planetGoods[i],0,99); 
            }
            for (int i = 0;i < quantity.length;i++) {
                quantity[i] = totalItemCount(marketItemList[i]);
                System.out.println(quantity[i]);
            }
            return quantity;
        }
	/** 
	 * Used by the Add method to find empty space to add an item
	 *
	 * 
	 * @param item to store
	 * @return the index that the available space is
	 **/
	private int getStore(MarketItem item) { //gets next 
                                                //availible space 
                                                //to storE inventory
		if (item == null) {
			throw new NullPointerException("item imputted "
                                + "is not a valid MarketItem");
		}
		if (item.getAmount() == 0) {
			throw new NoSuchElementException("There is no "
                                + "amount of MarketItem to store");
		}
		if (isStored(item)) {
	 		for (int i = 1; i <= occupation; i++) {
				if(item.equals(stash[i]) 
                                        && !(stash[i].isMaxed()) ) {
					return i;
				}
			}
		} 

		return 0; //return 0 if the item is not currently in the stash
	}

	/** 
	 * Checks to see if the item is actually in the inventory
	 * 
	 * 
	 * @param item to reference the check
	 * @return true if MarketItem of the same type exists in the inventory
	 **/
	public boolean isStored(MarketItem item) {
		for(int i = 1; i <= occupation; i++) {
			if(item.equals(stash[1])) {
				return true;
			}
		}
		return false;
	}
	/** 
	 * Non-Accessible, used for adding.
	 * Direct adds not allowed.
	 * 
	 * @Param index to add the item on the stack
	 **/
	private void addToStack(int index, MarketItem item) {
		int totalItemCount = stash[index].getAmount() + item.getAmount();
		if(totalItemCount > stash[index].getCapacity()) {
			int stackDeficit = totalItemCount 
                                - stash[index].getCapacity();
			store(item, stackDeficit);
		} else {
			stash[index].setAmount(totalItemCount);
		}
	}
	
	/** 
	 * Increases the size of the inventory so that a new Inventory
	 * does not have to be instantiated with an item transfer.
	 *
	 * 
	 * @param addedSize to be added to the inventory
         * @throws InvalidValue if a negative value is passed in
	 **/
	public void increaseSize(int addedSize) throws InvalidValue {
		if (addedSize < 0) {
			throw new InvalidValue("Cannot decrease "
                                + "size of inventory");
		}
		maxCapacity = maxCapacity + addedSize;
		MarketItem[] newStash = new MarketItem[maxCapacity];
		if(isEmpty())

		for(int i = 1; i <= occupation; i++) {
			newStash[i] = stash[i];
			stash = newStash;
		}


	}
	/** 
	 * NOT IMPLEMENTED in Version 1.0
	 * Swaps two items in the stash stack
	 * 
	 **/
	public void swapItemSpace() {
		//OPTIONAL IMPLEMENTATION
	}

	/** 
	 * Checks if inventory is empty
	 *
	 * 
	 * @return true if inventory is empty
	 **/
	public boolean isEmpty() {
		return (occupation == 0);
	}

	/** 
	 * Returns how many items are in the inventory
	 *
	 * 
	 * @return the size of space occupied in the inventory
	 **/
	public int getOccupationSize() { 
		return occupation;
	}
	/** 
	 * Clears the whole inventory
	 *
	 **/
	public void emptyInventory() { 
		MarketItem[] clear = new MarketItem[maxCapacity];
		stash = clear;
		occupation = 0;
	}
	/** 
	 * Checks to see if the inventory has space
	 *
	 * 
	 * 
	 * @return true if there is additional space in the inventory
	 **/
	public boolean hasSpace() {
            return(occupation <= maxCapacity);
		
	}

        public void printInventory() {
            for(int i = 1; i <= occupation; i++) {
                System.out.println(stash[i]);
            }
            System.out.println();
        }

}