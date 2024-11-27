package ch.heigvd.poo.calculator;

import java.util.EmptyStackException;

import ch.heigvd.poo.util.SimpleStack;

/**
 * @author Marcuard Adrien, Perret Jonatan
 * The State class represents the state of a calculator, including the current value,
 * a stack of values, and a memory value. It provides methods to manipulate these values,
 * perform arithmetic operations, and manage the state of the calculator.
 * 
 * The class includes methods to append digits to the current value, perform arithmetic
 * operations using the stack, and manage the memory value. It also provides methods to
 * clear the state, convert the stack to an array, and retrieve the current value and stack.
 * 
 * The class uses a SimpleStack to manage the stack of values and a ValueBuilder to manage
 * the current and memory values. The flagResult boolean is used to indicate if the current
 * value is a result of an arithmetic operation.
 * 
 * Methods:
 * - appendDigit(int digit): Appends a digit to the current value.
 * - popDigit(): Removes the last digit from the current value.
 * - getStringCurrentValue(): Returns the string representation of the current value.
 * - getCurrentValue(): Returns the current value as a double.
 * - setCurrentValue(double currentValue): Sets the current value.
 * - getArrayStack(): Converts the stack to an array of strings.
 * - getStack(): Returns the current stack.
 * - clear(): Clears the current value and empties the stack.
 * - addHeads(): Adds the value at the top of the stack to the current value.
 * - subtractHeads(): Subtracts the top value of the stack from the current value.
 * - multiplyHeads(): Multiplies the current value by the value at the top of the stack.
 * - dividedHeads(): Divides the value on top of the stack by the current value.
 * - appendPoint(): Appends a decimal point to the current value.
 * - appendCurrentValueInStack(): Appends the current value to the stack if it is not zero.
 * - memoryStore(): Stores the current value into memory.
 * - memoryRecall(): Recalls the value stored in memory and sets it as the current value.
 */
public class State {

    private SimpleStack<Double> stack = new SimpleStack<>();
    private ValueBuilder currentValue = new ValueBuilder();
    private ValueBuilder memoryValue = new ValueBuilder();
    private boolean flagResult = false; //indique si la currentValue est un résultat

    /**
     * Appends a digit to the current value. If the flagResult is set to true,
     * it first appends the current value to the stack and resets the flagResult.
     *
     * @param digit the digit to be appended to the current value
     */
    public void appendDigit(int digit) {
        if (flagResult) {
            this.appendCurrentValueInStack();
            flagResult = false;
        }
        currentValue.appendDigit(digit);
    }

    /**
     * Removes the last digit from the current value.
     * This method modifies the current value by popping the last digit.
     */
    public void popDigit() {
        currentValue.popDigit();
    }

    /**
     * Returns the string representation of the current value.
     *
     * @return the string representation of the current value
     */
    public String getStringCurrentValue() {
        return this.currentValue.toString();
    }

    /**
     * Returns the current value stored in the state.
     *
     * @return the current value as a double
     */
    public double getCurrentValue() {
        return this.currentValue.getValue();
    }

    /**
     * Sets the current value of the calculator.
     *
     * @param currentValue the new value to be set
     */
    public void setCurrentValue(double currentValue) {
        this.currentValue.setValue(currentValue);
    }

    /**
     * Converts the stack to an array of strings.
     *
     * @return an array of strings representing the elements in the stack.
     *         If the stack is empty, returns an empty array.
     */
    public String[] getArrayStack() {

        int len;

        if (!stack.isEmpty()) {
            len = stack.toArray().length;
        } else {
            len = 0;
        }

        String[] tmp = new String[len];

        for (int i = 0; i < len; ++i) {
            tmp[i] = stack.toArray()[i].toString();
        }

        return tmp;
    }

    /**
     * Returns the current stack of the calculator.
     *
     * @return a SimpleStack containing Double values representing the current state of the stack.
     */
    public SimpleStack<Double> getStack() {
        return this.stack;
    }

    /**
     * Clears the current value and empties the stack.
     * Resets the flagResult to false.
     */
    public void clear() {
        currentValue.clear();
        while (!stack.isEmpty()) {
            stack.pop();
        }
        flagResult = false;
    }

    /**
     * Adds the value at the top of the stack to the current value.
     * If the stack is empty, it adds 0 to the current value.
     * Sets the flagResult to true after the operation.
     *
     * @throws IllegalStateException if the stack is empty when attempting to pop a value.
     */
    public void addHeads() {
        try {
            currentValue.setValue(currentValue.getValue() + stack.pop());
        } catch (IllegalStateException e) {
            currentValue.setValue(currentValue.getValue() + 0);
        }
        flagResult = true;
    }

    /**
     * Subtracts the top value of the stack from the current value.
     * The result is stored back in the current value.
     * Sets the flagResult to true indicating that a result has been computed.
     */
    public void subtractHeads() {
        currentValue.setValue(currentValue.getValue() - stack.pop());
        flagResult = true;
    }

    /**
     * Multiplies the current value by the value at the top of the stack.
     * The result is stored back in the current value.
     * Sets the flagResult to true to indicate that a result has been computed.
     *
     * @throws EmptyStackException if the stack is empty when attempting to pop a value.
     */
    public void multiplyHeads() {
        currentValue.setValue(currentValue.getValue() * stack.pop());
        flagResult = true;
    }

    /**
     * Divides the value on top of the stack by the current value.
     * 
     * This method pops the top value from the stack and divides it by the current value.
     * If the current value is zero, an ArithmeticException is thrown to prevent division by zero.
     * The result of the division is then set as the new current value.
     * 
     * @throws ArithmeticException if the current value is zero.
     */
    public void dividedHeads() {
        double stackValue = stack.pop();
        double currentValueValue = currentValue.getValue();

        if (currentValueValue == 0) {
            throw new ArithmeticException("Division by zero");
        }
        currentValue.setValue(stackValue / currentValueValue);
        flagResult = true;
    }

    /**
     * Appends a decimal point to the current value.
     * This method delegates the operation to the currentValue object.
     */
    public void appendPoint() {
        currentValue.appendPoint();
    }

    /**
     * Appends the current value to the stack if it is not zero.
     * If the current value is zero, the method returns without modifying the stack.
     * After appending the current value to the stack, the current value is cleared.
     */
    public void appendCurrentValueInStack() {
        if (currentValue.getValue() == 0) {
            return;
        }
        stack.push(currentValue.getValue());
        currentValue.clear();
    }

    /**
     * Stores the current value into memory without clearing the current value.
     * This method mimics the behavior of Texas Instruments calculators where
     * the current value remains unchanged after storing it in memory.
     */
    public void memoryStore() {
        memoryValue.setValue(currentValue.getValue());
        // dont clear currentValue as TexaxInstruments calculator does
    }

    /**
     * Recalls the value stored in memory and sets it as the current value.
     * This method does not clear the memory value, similar to the behavior of Texas Instruments calculators.
     */
    public void memoryRecall() {
        currentValue.setValue(memoryValue.getValue());
        // dont clear memoryValue as TexaxInstruments calculator does
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan
 * The ValueBuilder class is responsible for constructing and managing a numeric value
 * represented as a string. It provides methods to append digits, append a decimal point,
 * pop the last digit, and clear the current value. The class also maintains the current
 * value as a double for easy numerical operations.
 */
class ValueBuilder {

    private int indexPoint;
    private StringBuilder string;
    private double value;

    public ValueBuilder() {
        indexPoint = 0;
        string = new StringBuilder();
    }

    @Override
    public String toString() {
        return string.toString();
    }

    public void setValue(double newValue) {
        this.clear();
        string.append(newValue);
        value = newValue;
    }

    public double getValue() {
        return value;
    }

    public void appendDigit(int newDigit) {

        double digit = newDigit;

        if (indexPoint != 0) {
            digit *= Math.pow(10.0, -(double) indexPoint);
            indexPoint++;
        } else {
            value *= 10;
        }

        value += digit;
        string.append(newDigit);
    }

    public void popDigit() {

        string.deleteCharAt(string.length() - 1);

        if (indexPoint != 0) {
            indexPoint--;
            value *= Math.pow(10.0, indexPoint);
        }

        int tmp = (int) (value / 10);
        value = (double) tmp;

        if (indexPoint != 0) {
            value *= Math.pow(10.0, -(double) indexPoint);
            indexPoint--;
        }

        System.out.println(value);

    }

    public void appendPoint() {
        indexPoint = 1;
        string.append(".");
    }

    public void clear() {
        string = new StringBuilder();
        indexPoint = 0;
        value = 0;
    }
}
