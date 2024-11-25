package ch.heigvd.poo.calculator;

import ch.heigvd.util.SimpleStack;

public class State {
    private SimpleStack<Double> stack = new SimpleStack<>();
    private int currentValue = 0;
    private String error = "";

    public void pushNumber(double number) {
        stack.push(number);
    }

    public double popNumber() throws Exception {
        if (stack.isEmpty()) throw new Exception("Empty stack");
        return stack.pop();
    }

    public int currentValue() {
        return currentValue;
    }

    public void setCurrentValue(int value) {
        currentValue = value;
    }

    public void setError(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Double[] getStackArray() {
        return (Double[]) stack.toArray();
    }

    public String[] getStackStringArray(){
        return stack.toString().split(",");
    }

    public void clear() {
        stack = new SimpleStack<>();
    }

    public void clearError() {
        error = "";
    }

    public void backspace() {
        try {
            popNumber();
        } catch (Exception e) {
            setError("Error: not enough numbers in the stack");
        }
    }

    public void negate() {
        try {
            double number = popNumber();
            pushNumber(-number);
        } catch (Exception e) {
            setError("Error: not enough numbers in the stack");
        }
    }


}
