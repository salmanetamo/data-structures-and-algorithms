package week4_adts;

/**
 *
 * Salmane Tamo
 * 25/06/2018
 */
public interface IList<E> {
    void insert(E e);//Append element to the end of the list
    void insertAt(int index, E e);//Add element to specified index
    E get(int index);//Returns element at provided index
    int size();//Return numnber of elements currently stored in the list
    E removeFirst();//Removes the first element from the list and returns it
    E remove(int index);//Removes element at the specified index and returns it
}
