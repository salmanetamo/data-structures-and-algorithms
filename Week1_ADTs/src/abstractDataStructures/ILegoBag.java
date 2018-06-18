/*
 * Authors: Bernard, Emmanuel Kabeya, and Salmane
 */
package abstractDataStructures;



public interface ILegoBag<T>{
    void add(T objectToAdd);
    void add(int index, T objectToAdd);
    void remove(int index);
    void remove(T objectToRemove);
    void removeAll();
    boolean isEmpty();
    boolean contains(T object);
}
