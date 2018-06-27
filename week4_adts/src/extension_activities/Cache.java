package extension_activities;

/**
 *Instructions:  
 * You have been asked to design and implement a cache using a LinkedList. 
 * The list is self-organised based on the frequency an element is accessed. 
 * Remember that in a Singly Linked List, retrieval of the last item is O(n), 
 * but if the n element is the frequently accessed, then this is inefficient. 
 * It would be better for the element to tend to the head of the list. 
 * Document and justify the algorithm chosen for self-organisation. 
 * 
 * 
 * @author Salmane Tamo
 * 26/06/2018
 */

import week4_adts.SinglyLinkedList;

public class Cache {
    private SinglyLinkedList<CacheItem> list;
    
    public Cache(){
        list = new SinglyLinkedList<>();
    }
    
    public void addCashItem(CacheItem itemToAdd){
        //Loop through the existing cacheItem objects in 
        //the list until it finds an object with a smaller frequency
        //Add my new item at that index
        for(int i = 0; i < this.list.size(); i++){
            if(this.list.get(i).getFrequency() <= itemToAdd.getFrequency()){
                this.list.insertAt(i, itemToAdd);
                return;
            }
        }
        //If we get here, then itemToAdd has a smaller frequency than
        //all currently stored items, then it will just be appended to the list
        this.list.insert(itemToAdd);
        
    }
    
    public CacheItem getCacheItem(CacheItem itemToReturn){
        //Getting the an item is still O(n), but given the addCacheItem() method,
        //the items with the highest frequency will always be quicker to retrieve
        for(int i = 0; i < this.list.size(); i++){
            if(this.list.get(i).equals(itemToReturn)){
                CacheItem objectToReturn = this.list.remove(i);
                //After item is found, its frequency is incremented and 
                //added back to the list before being returned
                //This ensures the list always has frequently retrieved items at the top
                objectToReturn.setFrequency(objectToReturn.getFrequency() + 1);
                this.addCashItem(objectToReturn);
                return objectToReturn;
            }
        }
        return null;
    }
    
    public CacheItem removeCacheItem(CacheItem itemToAdd){
        //Removing an item will not affect the order of the items
        //Therefore, we could simply use the remove method of the list
        for(int i = 0; i < this.list.size(); i++){
            if(this.list.get(i).equals(itemToAdd)){
                CacheItem objectToReturn = this.list.remove(i);

                return objectToReturn;
            }
        }
        return null;
    }
    
    public void printCacheItems(){
        for(int i = 0; i < this.list.size(); i++){
            System.out.println(this.list.get(i));
        }
    }
    
    public static void main (String[] args){
        CacheItem item1 = new CacheItem("Cache Item 1", 1);
        CacheItem item2 = new CacheItem("Cache Item 2", 2);
        CacheItem item3 = new CacheItem("Cache Item 3", 3);
        
        Cache cache = new Cache();
        
        cache.addCashItem(item1);
        cache.addCashItem(item2);
        cache.addCashItem(item3);
        
        System.out.println("Should be printed in order of frequency");
        cache.printCacheItems();
        
        CacheItem newItem = item2;
        cache.getCacheItem(item2);
        cache.getCacheItem(item2);
        
        System.out.println("Item has been retrieved twice, it should be at the top");
        cache.printCacheItems();
        
    }
}
