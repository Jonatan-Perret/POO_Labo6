package ch.heigvd.poo.calculator;

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The abstract class Operator
 * represents a mathematical operator in a calculator. It holds a reference to
 * the current state of the calculator and provides an abstract method execute()
 * that must be implemented by subclasses to perform the specific operation.
 */
abstract class Operator {

    protected State state;

    Operator(State state) {
        this.state = state;
    }

    abstract void execute();
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The UnaryOperator class is an
 * abstract class that extends the Operator class. It represents an operator
 * that performs an operation on a single operand.
 *
 * @param state the state of the calculator
 */
abstract class UnaryOperator extends Operator {

    UnaryOperator(State state) {
        super(state);
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * Abstract class representing a binary
 * operator in a calculator. A binary operator performs an operation on two
 * operands. This class extends the Operator class and requires a State object
 * to be passed to its constructor.
 */
abstract class BinaryOperator extends Operator {

    BinaryOperator(State state) {
        super(state);
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Backspace class represents a
 * unary operator that removes the last digit from the current state.
 *
 * <p>
 * This class extends the UnaryOperator class and overrides the execute method
 * to perform the backspace operation by calling the popDigit method on the
 * state.
 * </p>
 *
 * @see UnaryOperator
 * @see State#popDigit()
 */
class Backspace extends UnaryOperator {

    Backspace(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.popDigit();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The CE class represents a unary
 * operator that clears the current value in the calculator state. It extends
 * the UnaryOperator class and overrides the execute method to set the current
 * value to 0.
 */
class CE extends UnaryOperator {

    CE(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.setCurrentValue(0);
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The C class represents a unary
 * operator that clears the state. It extends the UnaryOperator class and
 * overrides the execute method to clear the state.
 */
class C extends UnaryOperator {

    C(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.clear();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Number class represents a unary
 * operator that appends a digit to the current state. It extends the
 * UnaryOperator class and overrides the execute method to append the specified
 * number.
 */
class Number extends UnaryOperator {

    int number;

    Number(State s, int number) {
        super(s);
        this.number = number;
    }

    @Override
    void execute() {
        state.appendDigit(number);
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The ChangeSign class is a type of
 * UnaryOperator that changes the sign of the current value in the calculator
 * state. It appends the current value to the stack, sets the current value to
 * -1, and then multiplies the heads of the stack.
 */
class ChangeSign extends UnaryOperator {

    ChangeSign(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.appendCurrentValueInStack();
        state.setCurrentValue(-1);
        state.multiplyHeads();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Point class represents a unary
 * operator that appends a decimal point to the current state. It extends the
 * UnaryOperator class and overrides the execute method to perform the specific
 * operation.
 */
class Point extends UnaryOperator {

    Point(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.appendPoint();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Div class represents a division
 * operation in a calculator. It extends the BinaryOperator class and overrides
 * the execute method to perform the division operation on the calculator's
 * state. If an ArithmeticException occurs (e.g., division by zero), the current
 * value in the state is set to 0.
 */
class Div extends BinaryOperator {

    Div(State state) {
        super(state);
    }

    @Override
    void execute() {
        try {
            state.dividedHeads();
        } catch (ArithmeticException e) {
            state.setCurrentValue(0);
        }
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Multi class represents a
 * multiplication operation in the calculator. It extends the BinaryOperator
 * class and overrides the execute method to perform the multiplication of the
 * heads of the state.
 */
class Multi extends BinaryOperator {

    Multi(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.multiplyHeads();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Sub class represents a
 * subtraction operation in the calculator. It extends the BinaryOperator class
 * and overrides the execute method to perform the subtraction operation on the
 * calculator's state.
 */
class Sub extends BinaryOperator {

    Sub(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.subtractHeads();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Add class represents a binary
 * operator that performs an addition operation. It extends the BinaryOperator
 * class and overrides the execute method to perform the addition by calling the
 * addHeads method on the state object.
 */
class Add extends BinaryOperator {

    Add(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.addHeads();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Inv class represents a unary
 * operator that performs the inversion operation. It extends the UnaryOperator
 * class and overrides the execute method to perform the inversion of the
 * current value in the calculator's state.
 *
 * The execute method saves the current value, sets the current value to 1,
 * appends the current value to the stack, restores the saved value, and then
 * performs the division operation. If an ArithmeticException occurs (e.g.,
 * division by zero), it sets the current value to 0.
 */
class Inv extends UnaryOperator {

    Inv(State s) {
        super(s);
    }

    @Override
    void execute() {
        double tmp = state.getCurrentValue();
        state.setCurrentValue(1);
        state.appendCurrentValueInStack();
        state.setCurrentValue(tmp);
        try {
            state.dividedHeads();
        } catch (ArithmeticException e) {
            state.setCurrentValue(0);
        }
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Square class represents a unary
 * operator that squares the current value in the calculator's state. It extends
 * the UnaryOperator class.
 */
class Square extends UnaryOperator {

    Square(State state) {
        super(state);
    }

    @Override
    void execute() {
        double tmp = state.getCurrentValue();
        state.appendCurrentValueInStack();
        state.setCurrentValue(tmp);
        state.multiplyHeads();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Sqrt class represents a unary
 * operator that calculates the square root of the current value in the
 * calculator's state. It extends the UnaryOperator class and overrides the
 * execute method to perform the square root operation.
 */
class Sqrt extends UnaryOperator {

    Sqrt(State s) {
        super(s);
    }

    @Override
    void execute() {
        double tmp = state.getCurrentValue();
        tmp = Math.sqrt(tmp);
        state.setCurrentValue(tmp);
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The Enter class represents a unary
 * operator that appends the current value in the state to the stack when
 * executed.
 *
 * This class extends the UnaryOperator class and overrides the execute method
 * to perform the specific operation of appending the current value in the state
 * to the stack.
 *
 * @see UnaryOperator
 */
class Enter extends UnaryOperator {

    Enter(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.appendCurrentValueInStack();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The MemoryStore class is a type of
 * UnaryOperator that stores the current state into memory when executed.
 *
 * <p>
 * This class extends the UnaryOperator class and overrides the execute method
 * to perform the memory store operation using the provided State object.</p>
 *
 * <p>
 * Usage example:</p>
 * <pre>
 *     State state = new State();
 *     MemoryStore memoryStore = new MemoryStore(state);
 *     memoryStore.execute(); // Stores the current state into memory
 * </pre>
 *
 * @see UnaryOperator
 * @see State
 */
class MemoryStore extends UnaryOperator {

    MemoryStore(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.memoryStore();
    }
}

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * The MemoryRecall class represents a
 * unary operator that recalls the value stored in memory. It extends the
 * UnaryOperator class and overrides the execute method to perform the memory
 * recall operation.
 *
 * Constructor: - MemoryRecall(State s): Initializes the MemoryRecall operator
 * with the given state.
 *
 * Methods: - void execute(): Executes the memory recall operation by invoking
 * the memoryRecall method on the state.
 */
class MemoryRecall extends UnaryOperator {

    MemoryRecall(State s) {
        super(s);
    }

    @Override
    void execute() {
        state.memoryRecall();
    }
}
