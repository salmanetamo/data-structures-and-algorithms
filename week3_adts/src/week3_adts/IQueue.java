/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_adts;

/**
 *
 * Salmane and Fatuma
 */
public interface IQueue<T> {
    void enqueue(T t);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}
