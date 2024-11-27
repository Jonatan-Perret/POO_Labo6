package ch.heigvd.poo;

import java.util.Scanner;

import ch.heigvd.poo.calculator.CCalculator;
import ch.heigvd.poo.calculator.JCalculator;

/**
 * @author Marcuard Adrien, Perret Jonatan
 * The App class serves as the entry point for the calculator application.
 * It initializes the calculator in either graphical mode or console mode
 * based on the value of the 'mode' variable.
 *
 * If 'mode' is true, the application starts in graphical mode by creating
 * an instance of JCalculator.
 *
 * If 'mode' is false, the application starts in console mode by creating
 * an instance of CCalculator and reading user input from the console.
 * The input is processed in a loop until the calculator indicates to stop.
 */
public class App {

    /**
     * The main method serves as the entry point for the application.
     * It initializes the calculator in either graphical mode or console mode
     * based on the value of the 'mode' variable.
     *
     * @param args command-line arguments (not used in this application)
     *
     * If 'mode' is true, the application starts in graphical mode by creating
     * an instance of JCalculator.
     *
     * If 'mode' is false, the application starts in console mode by creating
     * an instance of CCalculator and reading user input from the console.
     * The input is processed in a loop until the calculator indicates to stop.
     */
    public static void main(String... args) {

        // mode graphique => mode = true
        // mode console => mode = false
        boolean mode = true;

        if (mode) {
            // mode graphique
            new JCalculator();
        } else {
            // mode console
            CCalculator calculator = new CCalculator();
            Scanner input = new Scanner(System.in);

            while (calculator.input(input.nextLine())) {
                System.out.println(calculator);
            }
        }
    }
}
