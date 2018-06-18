/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_adts;
import week2_adts.Stack;

/**
 *
 * @author Student
 */
public class PostfixCalculator {
    Stack<Integer> numbers;
    Stack<Character> operators;
    
    private final char PLUS = '+';
    private final char MINUS = '-';
    private final char TIMES = '*';
    private final char DIVIDE = '/';
    
    public PostfixCalculator(){
        this.numbers = new Stack<>();
        this.operators = new Stack<>();
    }
    
    public Integer calculate(String postfix){
        String[] postfixArray = postfix.split(" "); 
        invertArray(postfixArray);
        for(String element : postfixArray){
            if(isOperator(element)){
                operators.push(element.charAt(0));
            } else {
                if(numbers.isEmpty() || operators.isEmpty()){
                    numbers.push(Integer.parseInt(element));
                } else {
                    int number1;
                    if(numbers.size() == 1){
                        number1 = Integer.parseInt(element);
                    } else {
                        number1 = numbers.peek();
                        numbers.pop();
                    }
                    int number2 = numbers.peek();
                    numbers.pop();
                    char operator = operators.peek();
                    operators.pop();
                    numbers.push(performOperations(number1, number2, operator));
                }
            }
        }
        return numbers.peek();
    }
    
    private Integer performOperations(int number1, int number2, char operator){
        switch(operator){
            case PLUS:
                return number1 + number2;
            case MINUS:
                return number1 - number2;
            case TIMES:
                return number1 * number2;
            case DIVIDE:
                return number2 / number1;
        }
        return null;
    }
    
    private boolean isOperator(String character){
        return character.equals(Character.toString(PLUS)) 
                || character.equals(Character.toString(MINUS))
                || character.equals(Character.toString(TIMES))
                || character.equals(Character.toString(DIVIDE));
    }
    
    
    
    private void invertArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
    
    public static void main (String[] args){
        PostfixCalculator pfc = new PostfixCalculator();
        PostfixCalculator pfc1 = new PostfixCalculator();
        
        System.out.println(pfc.calculate("1 2 +"));//Should be 3
        System.out.println();
        System.out.println(pfc1.calculate("3 4 5 + *"));//Should be 27
        System.out.println();

    }
}
