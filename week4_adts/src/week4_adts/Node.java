package week4_adts;

/**
 *
 * Salmane Tamo
 * 25/06/2018
 */
public class Node<E> {
    private E object;
    private Node<E> next;
    private Node<E> previous;//Only relevant for the DoublyLinkedList
    
    public Node(E object){
        this.object = object;
        this.next = null;
        this.previous = null;
    }
    
    public E getObject(){
        return this.object;
    }
    
    public void setObject(E newObject){
        this.object = newObject;
    }
    
    public Node<E> getNext(){
        return this.next;
    }
    
    public void setNext(Node<E> newNext){
        this.next = newNext;
    }
    
    public Node<E> getPrevious(){
        return this.previous;
    }
    
    public void setPrevious(Node<E> newPrevious){
        this.previous = newPrevious;
    }
    
    @Override
    public boolean equals(Object compareObject){
        if(!(compareObject instanceof Node)){ return false; }
        Node<E> node = (Node<E>) compareObject;
        return this.object.equals(node.getObject());
    }
}
