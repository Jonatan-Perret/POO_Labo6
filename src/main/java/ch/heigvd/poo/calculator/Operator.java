package ch.heigvd.poo.calculator;

abstract class Operator {

    protected State state;

    public Operator(State state) {
        this.state = state;
    }

    abstract void execute();
}

class Add extends Operator {

    public Add(State state) {
        super(state);
    }

    void execute() {
        try {
            double number1 = this.state.popNumber();
            double number2 = this.state.popNumber();
            this.state.pushNumber(number1 + number2);
            System.err.println("Add: " + number1 + " + " + number2 + " = " + (number1 + number2));
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Sub extends Operator {

    public Sub(State state) {
        super(state);
    }

    void execute() {
        try {
            double number1 = this.state.popNumber();
            double number2 = this.state.popNumber();
            this.state.pushNumber(number1 - number2);
            System.out.println("Sub: " + number1 + " - " + number2 + " = " + (number1 - number2));
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Mul extends Operator {

    public Mul(State state) {
        super(state);
    }

    void execute() {
        try {
            double number1 = this.state.popNumber();
            double number2 = this.state.popNumber();
            this.state.pushNumber(number1 * number2);
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Div extends Operator {

    public Div(State state) {
        super(state);
    }

    void execute() {
        try {
            double number1 = this.state.popNumber();
            double number2 = this.state.popNumber();
            this.state.pushNumber(number1 / number2);
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Point extends Operator {

    public Point(State state) {
        super(state);
    }

    void execute() {
        System.out.println("Point");
    }
}

class Enter extends Operator {

    public Enter(State state) {
        super(state);
    }

    void execute() {
        System.out.println("Enter");
    }
}

class Sqrt extends Operator {

    public Sqrt(State state) {
        super(state);
    }

    void execute() {
        try {
            double number = this.state.popNumber();
            this.state.pushNumber(Math.sqrt(number));
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Square extends Operator {

    public Square(State state) {
        super(state);
    }

    void execute() {
        try {
            double number = this.state.popNumber();
            this.state.pushNumber(number * number);
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Inverse extends Operator {

    public Inverse(State state) {
        super(state);
    }

    void execute() {
        try {
            double number = this.state.popNumber();
            this.state.pushNumber(1 / number);
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Sign extends Operator {

    public Sign(State state) {
        super(state);
    }

    void execute() {
        try {
            double number = this.state.popNumber();
            this.state.pushNumber(-number);
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Clear extends Operator {

    public Clear(State state) {
        super(state);
    }

    void execute() {
        this.state.clear();
    }
}

class ClearError extends Operator {

    public ClearError(State state) {
        super(state);
    }

    void execute() {
        System.out.println("ClearError");
    }
}

class Backspace extends Operator {

    public Backspace(State state) {
        super(state);
    }

    void execute() {
        try {
            this.state.popNumber();
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class Number extends Operator {

    public Number(State state) {
        super(state);
    }

    private int value;

    Number(State state, int value) {
        super(state);
        this.value = value;
    }

    void execute() {
        try{
            this.state.pushNumber(this.value);
        } catch (Exception e) {
            this.state.setError("Error: not enough numbers in the stack");
        }
    }
}

class MemoryRecall extends Operator {

    public MemoryRecall(State state) {
        super(state);
    }

    void execute() {
        System.out.println("MemoryRecall");
    }
}

class MemoryStore extends Operator {

    public MemoryStore(State state) {
        super(state);
    }

    void execute() {
        System.out.println("MemoryStore");
    }
}
