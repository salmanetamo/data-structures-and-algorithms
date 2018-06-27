package week4_adts;

/**
 *
 * Salmane Tamo
 */
public interface IQueue<T> {
    void enqueue(T t);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}
