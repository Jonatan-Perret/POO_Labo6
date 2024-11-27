package ch.heigvd.poo.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CCalculatorTest {

    private CCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CCalculator();
    }

    @Test
    public void testAddition() {
        calculator.input("1");
        calculator.input("2");
        calculator.input("+");
        assertEquals("3.0 []", calculator.toString());
    }

    @Test
    public void testSubtraction() {
        calculator.input("5");
        calculator.input("3");
        calculator.input("-");
        assertEquals("-2.0 []", calculator.toString());
    }

    @Test
    public void testMultiplication() {
        calculator.input("2");
        calculator.input("3");
        calculator.input("*");
        assertEquals("6.0 []", calculator.toString());
    }

    @Test
    public void testDivision() {
        calculator.input("8");
        calculator.input("2");
        calculator.input("/");
        assertEquals("4.0 []", calculator.toString());
    }

    @Test
    public void testSquareRoot() {
        calculator.input("9");
        calculator.input("sqrt");
        assertEquals("3.0 []", calculator.toString());
    }

    @Test
    public void testSquare() {
        calculator.input("3");
        calculator.input("^");
        assertEquals("9.0 []", calculator.toString());
    }

    @Test
    public void testMemoryStoreAndRecall() {
        calculator.input("5");
        calculator.input("MS");
        calculator.input("0");
        calculator.input("MR");
        assertEquals("5.0 [5.0]", calculator.toString());
    }

    @Test
    public void testInvalidInput() {
        assertFalse(calculator.input("invalid"));
    }

    @Test
    public void testExit() {
        assertFalse(calculator.input("exit"));
    }
}
