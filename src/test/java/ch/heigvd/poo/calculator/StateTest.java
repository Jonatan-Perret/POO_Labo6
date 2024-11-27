package ch.heigvd.poo.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class StateTest {

    @Test
    public void testAppendDigit() {
        State state = new State();
        state.appendDigit(5);
        assertEquals("5", state.getStringCurrentValue());
        state.appendDigit(3);
        assertEquals("53", state.getStringCurrentValue());
    }

    @Test
    public void testPopDigit() {
        State state = new State();
        state.appendDigit(5);
        state.appendDigit(3);
        state.popDigit();
        assertEquals("5", state.getStringCurrentValue());
    }

    @Test
    public void testGetCurrentValue() {
        State state = new State();
        state.appendDigit(5);
        state.appendDigit(3);
        assertEquals(53, state.getCurrentValue());
    }

    @Test
    public void testSetCurrentValue() {
        State state = new State();
        state.setCurrentValue(42.0);
        assertEquals(42.0, state.getCurrentValue());
    }

    @Test
    public void testGetArrayStack() {
        State state = new State();
        state.appendDigit(5);
        state.appendCurrentValueInStack();
        state.appendDigit(3);
        state.appendCurrentValueInStack();
        String[] stackArray = state.getArrayStack();
        assertEquals(2, stackArray.length);
        assertEquals("3.0", stackArray[0]);
        assertEquals("5.0", stackArray[1]);
    }

    @Test
    public void testClear() {
        State state = new State();
        state.appendDigit(5);
        state.appendCurrentValueInStack();
        state.clear();
        assertEquals(0, state.getStack().toArray().length);
        assertEquals("", state.getStringCurrentValue());
    }

    @Test
    public void testAddHeads() {
        State state = new State();
        state.appendDigit(5);
        state.appendCurrentValueInStack();
        state.appendDigit(3);
        state.addHeads();
        assertEquals(8.0, state.getCurrentValue());
    }

    @Test
    public void testSubtractHeads() {
        State state = new State();
        state.appendDigit(5);
        state.appendCurrentValueInStack();
        state.appendDigit(3);
        state.subtractHeads();
        assertEquals(-2.0, state.getCurrentValue());
    }

    @Test
    public void testMultiplyHeads() {
        State state = new State();
        state.appendDigit(5);
        state.appendCurrentValueInStack();
        state.appendDigit(3);
        state.multiplyHeads();
        assertEquals(15.0, state.getCurrentValue());
    }

    @Test
    public void testDividedHeads() {
        State state = new State();
        state.appendDigit(6);
        state.appendCurrentValueInStack();
        state.appendDigit(3);
        state.dividedHeads();
        assertEquals(2.0, state.getCurrentValue());
    }

    @Test
    public void testDividedHeadsByZero() {
        State state = new State();
        state.appendDigit(6);
        state.appendCurrentValueInStack();
        state.appendDigit(0);
        assertThrows(ArithmeticException.class, () -> {
            state.dividedHeads();
        });
    }

    @Test
    public void testAppendPoint() {
        State state = new State();
        state.appendDigit(5);
        state.appendPoint();
        state.appendDigit(3);
        assertEquals("5.3", state.getStringCurrentValue());
    }

    @Test
    public void testMemoryStoreAndRecall() {
        State state = new State();
        state.appendDigit(5);
        state.memoryStore();
        state.appendDigit(3);
        state.memoryRecall();
        assertEquals(5.0, state.getCurrentValue());
    }
}
