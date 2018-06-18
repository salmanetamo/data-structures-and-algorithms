/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_adts;

/**
 *
 * @author Student
 */
public class Week3_adts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for(int i = 0; i < 11; i++){
            queue.enqueue(i);
        }
        System.out.println(queue.peek());
        queue.dequeue();
        for(int i = 0; i < 11; i++){
            queue.dequeue();
        }
        System.out.println(queue.peek());
        
    }
    
}
