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
public class Stack<T> implements IStack<T> {

    Object[] innerArray;
    int currentSize;
    final int INITIAL_SIZE = 10;
    
    public Stack(){
        this.currentSize = 0;
        innerArray = new Object[this.INITIAL_SIZE];
    }
    
    
    @Override
    public void push(Object objectToAdd) {
        if(this.innerArray.length <= this.currentSize) {//Check if array is full
            Object[] newArray = new Object[this.innerArray.length * 2];//Double array size
           
            for(int i = 0; i < this.currentSize; i++){
                newArray[i] = this.innerArray[i];
            }
            this.innerArray = newArray;
            
        }
        
        this.innerArray[this.currentSize] = objectToAdd;
        this.currentSize++;
    }

    @Override
    public void pop() {
        if(this.isEmpty()) return;//If empty, do nothing
        
        this.innerArray[this.currentSize--] = null;
    }

    @Override
    public T peek() {
        if(this.isEmpty()) return null;//Nothing to return
        
        return (T) this.innerArray[this.currentSize - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }
    
    @Override
    public void removeAll() {
        if(this.isEmpty()) return;
        for(int i = 0; i <= this.currentSize; i++){
            this.pop();
        }
    }
    
    @Override
    public int size(){
        return this.currentSize;
    }
    
}
