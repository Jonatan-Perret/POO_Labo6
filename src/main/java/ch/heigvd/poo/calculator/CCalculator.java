package ch.heigvd.poo.calculator;

/**
 * @author Marcuard Adrien, Perret Jonatan
 * The CCalculator class represents a simple calculator that can perform basic arithmetic operations,
 * memory operations, and handle square root and power functions. It maintains a state and processes
 * input operators to execute corresponding operations.
 * 
 * Supported operators are:
 * - Arithmetic: "+", "-", "*", "/"
 * - Functions: "sqrt", "^"
 * - Memory: "MR" (Memory Recall), "MS" (Memory Store)
 * - Numbers: "0" to "9"
 * - Special: "exit" to terminate the calculator
 * 
 * The calculator maintains a stack and a current value, which can be retrieved as a string representation.
 * 
 * Example usage:
 * <pre>
 *     CCalculator calculator = new CCalculator();
 *     calculator.input("5");
 *     calculator.input("+");
 *     calculator.input("3");
 *     calculator.input("=");
 *     System.out.println(calculator); // Outputs the current state of the calculator
 * </pre>
 */
public class CCalculator {

    private State state = new State();
    private Operator op;

    /**
     * Processes the input operator and executes the corresponding operation.
     *
     * @param operator the operator or number to be processed. Supported operators are:
     *                 "+", "-", "*", "/", "sqrt", "^", "MR", "MS", "exit" and numbers "0" to "9".
     * @return true if the operation was successfully executed, false if the operator is "exit" or unsupported.
     */
    public boolean input(String operator) {

        /*
        op = new Enter(state);
        op.execute();
         */
        switch (operator) {

            case "*":
                op = new Multi(state);
                break;
            case "-":
                op = new Sub(state);
                break;
            case "/":
                op = new Div(state);
                break;
            case "sqrt":
                op = new Sqrt(state);
                break;
            case "^":
                op = new Square(state);
                break;
            case "+":
                op = new Add(state);
                break;
            case "1":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 1);
                break;
            case "2":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 2);
                break;
            case "3":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 3);
                break;
            case "4":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 4);
                break;
            case "5":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 5);
                break;
            case "6":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 6);
                break;
            case "7":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 7);
                break;
            case "8":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 8);
                break;
            case "9":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 9);
                break;
            case "0":
                op = new Enter(state);
                op.execute();
                op = new Number(state, 0);
                break;
            case "MR":
                op = new MemoryRecall(state);
                break;
            case "MS":
                op = new MemoryStore(state);
                break;
            case "exit":
                return false;
            default:
                return false;
        }

        op.execute();
        return true;

    }

    /**
     * Returns a string representation of the calculator's current state.
     * The string includes the current value and the stack.
     *
     * @return a string representation of the current value and stack
     */
    @Override
    public String toString() {
        return state.getCurrentValue() + " " + state.getStack();
    }

}
