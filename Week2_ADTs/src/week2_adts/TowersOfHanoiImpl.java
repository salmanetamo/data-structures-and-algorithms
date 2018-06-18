/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_adts;
import java.util.ArrayList;
import week2_adts.Stack;

/**
 *
 * @author Student
 */
public class TowersOfHanoiImpl {
    private int numberOfPieces;
    private ArrayList<Stack<Integer>> slots = new ArrayList<>();
    
    public TowersOfHanoiImpl(int numberOfpieces){
        this.numberOfPieces = numberOfpieces;
        
        //Adding 3 stacks to the slots arraylist, each stack is a slot
        for(int i = 0; i < 3; i++){
            Stack<Integer> stack = new Stack<Integer>();            
            this.slots.add(stack);
        }
        
        for(int i = numberOfpieces; i > 0 ; i--){
            this.slots.get(0).push(i);
        }
    }
    
    public boolean move(int indexSlotFrom, int indexSlotTo){
        Stack<Integer> slotFrom = this.getSlots().get(indexSlotFrom); 
        Stack<Integer> slotTo = this.getSlots().get(indexSlotTo);
        if(slotFrom.isEmpty()){
            return false;
        }
        
        if(slotTo.peek() != null){
            if(slotFrom.peek() > slotTo.peek()){
                return false;
            } else {
                slotTo.push(slotFrom.peek());
                slotFrom.pop();
                return true;
            }
        } else {
            slotTo.push(slotFrom.peek());
            slotFrom.pop();
            return true;
        }
    }
    
    public void solve(){
        do{
            
        }while(this.getSlots().get(2).size() < this.getNumberOfpieces());
    }
    
    /**
     * @return the numberOfpieces
     */
    public int getNumberOfpieces() {
        return numberOfPieces;
    }

    /**
     * @return the slots
     */
    public ArrayList<Stack<Integer>> getSlots() {
        return slots;
    }
}
