/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_adts;

/**
 *
 * @author Student
 */
public interface IStack<T> {
    //Add something to the TOP stack
    void push(T t);

    //Remove the top element of the stack
    void pop();

    //Return the top element of the stack
    T peek();

    //Check whether or not the stack is empty
    boolean isEmpty();

    //Remove all elements from the stack
    void removeAll();
    
    //Returns the size of the Stack
    int size();
}
