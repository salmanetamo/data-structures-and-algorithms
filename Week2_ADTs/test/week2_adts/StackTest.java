/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_adts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
public class StackTest {
    
    private Stack<Integer> stack;
    
    
    @Before
    public void setUp() {
        stack = new Stack<Integer>();
    }
    
    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        for(int i = 0; i < 14; i++){
            stack.push(new Integer(i));
        }
        assertEquals(stack.innerArray[13], 13);
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        stack.pop();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(stack.innerArray[0], null);
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        stack.push(new Integer(1));
        assertEquals(stack.peek(), (new Integer(1)));
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        stack.push(new Integer(1));
        assertFalse(stack.isEmpty());
    }
    
}
