package week2_adts;

/*
User plays the game
 */

/**
 *
 * @author Student
 */
import week2_adts.Stack;
import java.util.ArrayList;
import week2_adts.InputHelper;


public class HanoiGame {
    private int numberOfpieces;
    private ArrayList<Stack<Integer>> slots = new ArrayList<>();
    
    public HanoiGame(int numberOfpieces){
        this.numberOfpieces = numberOfpieces;
        
        //Adding 3 stacks to the slots arraylist, each stack is a slot
        for(int i = 0; i < 3; i++){
            Stack<Integer> stack = new Stack<Integer>();            
            this.slots.add(stack);
        }
        
        for(int i = numberOfpieces; i > 0 ; i--){
            this.slots.get(0).push(i);
        }
    }
    
    /**
     * @return the numberOfpieces
     */
    public int getNumberOfpieces() {
        return numberOfpieces;
    }

    /**
     * @return the slots
     */
    public ArrayList<Stack<Integer>> getSlots() {
        return slots;
    }
    
    public boolean move(int indexSlot1, int indexSlot2){
        Stack<Integer> slot1 = this.getSlots().get(indexSlot1); 
        Stack<Integer> slot2 = this.getSlots().get(indexSlot2);
        if(slot1.isEmpty()){
            System.out.println("There is nothing to move yo!");
            return false;
        }
        
        if(slot2.peek() != null){
            if(slot1.peek() > slot2.peek()){
                System.out.println("You cannot do that move yo!");
                return false;
            } else {
                slot2.push(slot1.peek());
                slot1.pop();
                System.out.println("That's a valid move yo!");
                return true;
            }
        } else {
            slot2.push(slot1.peek());
            slot1.pop();
            System.out.println("That's a valid move yo!");
            return true;
        }
    }

    public void playGame(){
        InputHelper inputHelper = new InputHelper();
        
        int indexSlot1;
        int indexSlot2;
        do{
            indexSlot1 = inputHelper.readInt("Which slot are you picking from 1 -  2 -  3 || or type -1 to finish") - 1;

            if(indexSlot1 == -2) {
                System.out.println("You terminated the game. Bye!");
                return;
            }
            
            indexSlot2 = inputHelper.readInt("Which slot are you adding to 1 -  2 -  3 || or type -1 to finish") - 1;
            
            if(indexSlot2 == -2) {
                System.out.println("You terminated the game. Bye!");
                return;
            } 
            
            this.move(indexSlot1, indexSlot2);
        }while(this.getSlots().get(2).size() < this.getNumberOfpieces());
        
        System.out.println("You have successfully completed the game!");
    }
    
    
    public static void main (String args[]){
        InputHelper inputHelper = new InputHelper();
        int numOfPieces = inputHelper.readInt("Welcome to the Hanoi Game!"
                + "\nYou have three slots, how many pieces do you want to play with");
        HanoiGame game = new HanoiGame(numOfPieces);
        game.playGame();
    }
    
}
