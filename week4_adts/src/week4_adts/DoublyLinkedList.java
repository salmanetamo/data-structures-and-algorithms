/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_adts;

/**
 *
 * @author Student
 */
public class DoublyLinkedList<E> implements IList<E> {
    private Node<E> head;
    private int size;
    
    public DoublyLinkedList(){
        this.head = null;
        this.size = 0;
    }
    @Override
    public void insert(E e) {
        Node<E> newNode = new Node(e);
        if(this.head == null){
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrevious(current);
        }
        this.size++;
    }

    @Override
    public boolean insertAt(int index, E e) {
        if(0 > index || index > this.size){ return false; }
        
        Node<E> newNode = new Node(e);
        int count = 0;
        Node<E> current = this.head;
        while(count < index - 1){
            current = current.getNext();
            count++;
        }
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        current.setNext(newNode);
        
        this.size++;
        return true;
    }

    @Override
    public E get(int index) {
        if(0 > index || index > this.size){ return null; }
        int count = 0;
        Node<E> current = this.head;
        while(count < index){
            current = current.getNext();
            count++;
        }
        return current.getObject();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E removeFirst() {
        if(this.head == null){ return null; }
        E object = this.head.getObject();
        this.head = this.head.getNext();
        this.head.setPrevious(null);
        
        this.size--;
        return object;
    }

    @Override
    public E remove(int index) {
        if(0 > index || index > this.size){ return null; }
        int count = 0;
        Node<E> current = this.head;
        while(count < index - 1){
            current = current.getNext();
            count++;
        }
        E object = current.getNext().getObject();
        current.setNext(current.getNext().getNext());
        current.getNext().setPrevious(current);
        
        this.size--;
        return object;
    }
    
}
