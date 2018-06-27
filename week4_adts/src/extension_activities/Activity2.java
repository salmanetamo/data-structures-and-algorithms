package extension_activities;

/**
 *Instructions:
 * Place n objects, where n is in the order of millions in your CircularListQueue
 * Do the same for you array-based implementation from last week. 
 * Measure the time taken to execute selected operations on your list. 
 * Explore which implementation is faster
 * 
 * @author Salmane Tamo
 */

import week4_adts.CircularListQueue;
import week4_adts.Queue;

public class Activity2 {
    
    static CircularListQueue<Integer> listQueue = new CircularListQueue<>();
    static Queue<Integer> arrayQueue = new Queue<>();
    
    public void enqueueMethod(){
        long startTimeInsertListQueue = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){
            listQueue.enqueue(i);
        }
        long endTimeInsertListQueue = System.currentTimeMillis();
        long totalTimeInsertListQueue = endTimeInsertListQueue - startTimeInsertListQueue;
        
        
        long startTimeInsertArrayQueue = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){
            arrayQueue.enqueue(i);
        }
        long endTimeInsertArrayQueue = System.currentTimeMillis();
        long totalTimeInsertArrayQueue = endTimeInsertArrayQueue - startTimeInsertArrayQueue;
        
        System.out.println("Time taken to enqueue 10million elements: ");
        System.out.println("List-based Queue: "+ totalTimeInsertListQueue);
        System.out.println("Array-based Queue: "+ totalTimeInsertArrayQueue);
    }
    
    public void dequeueMethod(){
        long startTimeDequeueListQueue = System.currentTimeMillis();
        
        listQueue.dequeue();
        
        long endTimeDequeueListQueue = System.currentTimeMillis();
        long totalTimeDequeueListQueue = endTimeDequeueListQueue - startTimeDequeueListQueue;
        
        
        long startTimeDequeueArrayQueue = System.currentTimeMillis();
        
        arrayQueue.dequeue();
        
        long endTimeDequeueArrayQueue = System.currentTimeMillis();
        long totalTimeDequeueArrayQueue = endTimeDequeueArrayQueue - startTimeDequeueArrayQueue;
        
        System.out.println("Time taken to dequeue a single element: ");
        System.out.println("List-based Queue: "+ totalTimeDequeueListQueue);
        System.out.println("Array-based Queue: "+ totalTimeDequeueArrayQueue);
    }
    
    public static void main (String[] args){
        Activity2 activity = new Activity2();  
        activity.enqueueMethod();
        activity.dequeueMethod();    
    }
}
