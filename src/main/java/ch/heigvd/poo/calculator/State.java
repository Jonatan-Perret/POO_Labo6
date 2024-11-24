package ch.heigvd.poo.calculator;

import ch.heigvd.util.SimpleStack;

public class State {
    private SimpleStack<Double> stack = new SimpleStack<>();
    private String error = "";

    public void pushNumber(double number) {
        stack.push(number);
    }

    public double popNumber() throws Exception {
        if (stack.isEmpty()) throw new Exception("Empty stack");
        return stack.pop();
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

    public Object[] getStackArray() {
        return stack.toArray();
    }
}
