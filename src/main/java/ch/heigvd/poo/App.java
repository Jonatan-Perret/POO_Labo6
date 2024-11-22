package ch.heigvd.poo;

import ch.heigvd.poo.calculator.JCalculator;
import ch.heigvd.util.SimpleStack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new JCalculator();
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }
}
