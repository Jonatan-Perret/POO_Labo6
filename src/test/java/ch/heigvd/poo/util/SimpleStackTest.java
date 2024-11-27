package ch.heigvd.poo.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SimpleStackTest {

    @Test
    public void testPushAndPop() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testIsEmpty() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testToString() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals("[3, 2, 1]", stack.toString());
    }

    @Test
    public void testToArray() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer[] expectedArray = {3, 2, 1};
        assertArrayEquals(expectedArray, stack.toArray());
    }
}
