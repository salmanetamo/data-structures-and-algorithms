package week4_adts;

/**
 *
 * Salmane and Fatuma
 */
public class Queue<T> implements IQueue<T> {

    Object[] innerArray;
    int head;
    int tail;
    int currentSize;
    final int INITIAL_SIZE = 10;
    
    public Queue(){
        this.innerArray = new Object[INITIAL_SIZE];
        this.currentSize = 0;
        this.head = 0;
        this.tail = 0;
    }
    
    @Override
    public void enqueue(T t) {
        
        if(this.currentSize == this.innerArray.length){
            Object[] newArray = new Object[this.innerArray.length * 2];
            int i = head;
            while( i < this.innerArray.length){
                newArray[i] = this.innerArray[i % this.innerArray.length];
                i++;
            }
            this.innerArray = newArray;
            this.tail = i;
        }       
        
        this.innerArray[this.tail] = t; 
        this.tail++;
        if(this.tail == this.innerArray.length){
            this.tail = 0;
        }
        
        this.currentSize++;
    }
    
    
    @Override
    public T dequeue() {
        if(this.isEmpty()) return null;
        T objectToRemove = (T)this.innerArray[this.head];
        this.innerArray[this.head] = null;
        
        this.head++;
        if(this.head == this.innerArray.length){
            this.head = 0;
        }
        this.currentSize--;
        return objectToRemove;
        
    }

    @Override
    public T peek() {
        if(this.isEmpty()) return null;
        return (T) this.innerArray[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public int size() {
        return this.currentSize;
    }
    
}
