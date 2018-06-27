package week4_adts;

/**
 *
 * @author Salmane Tamo
 * 26/06/2018
 */
import week4_adts.CircularLinkedList;

public class CircularListQueue<E> implements IQueue<E>{
    
    private CircularLinkedList<E> list;
    
    public CircularListQueue(){
        this.list = new CircularLinkedList<>();
    }
            
    @Override
    public void enqueue(E e) {
        this.list.insert(e);
    }

    @Override
    public E dequeue() {
        return this.list.removeFirst();
    }

    @Override
    public E peek() {
        return this.list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public int size() {
        return this.list.size();
    }
    
}
