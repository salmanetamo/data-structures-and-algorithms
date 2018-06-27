package week4_adts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Contains tests for the the implementation of the SinglyLinkedList class
 * 
 * @author Salmane Tamo
 * 26/06/2018
 */
public class SinglyLinkedListTest {
    
    private SinglyLinkedList<Integer> linkedList;
    
    
    @Before
    public void setUp() {
        linkedList = new SinglyLinkedList<>();
    }
    
    @After
    public void tearDown() {
        linkedList = new SinglyLinkedList<>();
    }

    /**
     * Test of insert method when list is empty.
     */
    @Test
    public void testInsertEmpty() {
        linkedList.insert(1);
        assertEquals(1, linkedList.size());
    }
    
    /**
     * Test of insert method when list is not empty.
     */
    @Test
    public void testInsertNotEmpty() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertEquals(2, linkedList.size());
    }

    /**
     * Test of insertAt method with an negative index.
     */
    @Test
    public void testInsertAtNegativeIndex() {
        assertFalse(linkedList.insertAt(-2, 8));
    }
    
    /**
     * Test of insertAt method with index bigger than size.
     */
    @Test
    public void testInsertAtIndexOutOfBounds() {
        assertFalse(linkedList.insertAt(2, 8));
    }
    
    /**
     * Test of insertAt method with index 0.
     */
    @Test
    public void testInsertAtIndex0() {
        assertTrue(linkedList.insertAt(0, 8));
    }
    
    /**
     * Test of insertAt method with index size.
     */
    @Test
    public void testInsertAtIndexSize() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertTrue(linkedList.insertAt(2, 8));
    }
    
    /**
     * Test of insertAt method, of class SinglyLinkedList.
     */
    @Test
    public void testInsertAtValidIndex() {
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        assertTrue((linkedList.insertAt(1, 8)) 
                 && linkedList.size() == 4
                 && linkedList.get(1).equals((Integer)8)) ;
    }

    /**
     * Test of get method with an invalid index, should return null.
     */
    @Test
    public void testGetInvalidIndex() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(5));
    }
    
    /**
     * Test of get method with valid index provided.
     */
    @Test
    public void testGetValidIndex() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertEquals(linkedList.get(1), (Integer) 2);
    }

    /**
     * Test of size method, of class SinglyLinkedList.
     */
    @Test
    public void testSize() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertEquals(2, linkedList.size());
    }

    /**
     * Test of removeFirst method when the list is empty, should return null.
     */
    @Test
    public void testRemoveFirstEmpty() {
        assertNull(linkedList.removeFirst());
    }
    
    /**
     * Test of removeFirst method when list is not empty.
     */
    @Test
    public void testRemoveFirstNotEmpty() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertEquals(linkedList.removeFirst(), (Integer)1);
        assertEquals(linkedList.size(), 1);
    }

    /**
     * Test of remove method when list is empty, should return null.
     */
    @Test
    public void testRemoveEmpty() {
        assertNull(linkedList.remove(2));
    }
    
    /**
     * Test of remove method with invalid index, should return null.
     */
    @Test
    public void testRemoveInvalidIndex() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertNull(linkedList.remove(-2));
        assertNull(linkedList.remove(4));
    }
    
    /**
     * Test of remove method at index 0.
     */
    @Test
    public void testRemoveIndex0() {
        linkedList.insert(1);
        linkedList.insert(2);
        assertEquals(linkedList.remove(0), (Integer)1);
    }
    
    /**
     * Test of remove method at any valid index.
     */
    @Test
    public void testRemoveValidIndex() {
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        assertEquals(linkedList.remove(1), (Integer)2);
        assertEquals(linkedList.size(), 2);
    }
    
}
