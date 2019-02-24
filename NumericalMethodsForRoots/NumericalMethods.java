package NumericalMethods;

import java.util.Scanner;

public class NumericalMethods {
    private static int attempts = 0;
    private static double tolerance = .000001;

    /**
     * Evaluates the function
     *
     * @param x the point to evaluate the function at
     * @return the value of the function
     */
    public static float function(float x) {
        return (float) (Math.pow(x, 2) - (5 * x) - 6); // x^2 -5x -6
    }

    /**
     * Evaluates the derivative of the function
     *
     * @param x the value to find the derivative at
     * @return the value of the derivative
     */
    public static float derivative(float x) {
        return 2 * x - 5; // 2x-5
    }

    /**
     * Finds the midpoint of the parameters.
     *
     * @param a the first parameter
     * @param b the second parameter
     * @return the midpoint of the two points
     */
    public static float midPoint(float a, float b) {
        return (a + b) / 2;
    }

    /**
     * Checks to see if the parameters are of opposite signs or not.
     *
     * @param x the first parameter
     * @param y the second parameter
     * @return the boolean determining whether the parameters have opposite signs or not
     */
    public static boolean oppositeSigns(float x, float y) {
        return (x < 0) ? y >= 0 : (y < 0);
    }


    /**
     * Uses the bisection method to narrow down the location of the root of the function given the
     * domain of the function and the guarantee of the Intermediate Value Theorum.
     *
     * @param a the lower bound of the domain
     * @param b the upper bound of the domain
     * @return the nearest root of the function
     */
    public static float bisectionMethod(float a, float b) {
        float c = midPoint(a, b);
        if (Math.abs(function(c)) > tolerance) {
            if (oppositeSigns(function(c), function(a))) {
                b = c;
            } else {
                a = c;
            }
            attempts++;
            return bisectionMethod(a, b);
        } else {
            attempts++;
            return c;
        }
    }

    /**
     * Uses Newton's Method to find the root of a function, given the domain of the function and the guarantee of the
     * Intermediate Value Theorum.
     *
     * @param x0 the guess of the location of the root
     * @return the location of the nearest root of the function
     */
    public static double newtonsMethod(float x0) {
        float xN = x0 - (function(x0) / derivative(x0));
        if (tolerance >= function(xN) && function(xN) >= -tolerance) {
            attempts++;
            return xN;
        } else {
            attempts++;
            return newtonsMethod(xN);
        }
    }

    /**
     * Uses the secant method of drawing secant lines to narrow down the location of the root of the function given the
     * domain of the function and the guarantee of the Intermediate Value Theorum.
     *
     * @param x0 the lower bound of the domain
     * @param x1 the upper bound of the domain
     * @return the nearest root of the function
     */
    public static float secantMethod(float x0, float x1) {
        float x2 = (x0 * function(x1) - x1 * function(x0)) / (function(x1) - function(x0));
        if (tolerance >= function(x2) && -tolerance <= function(x2)) {
            attempts++;
            return x2;
        } else {
            attempts++;
            return secantMethod(x1, x2);
        }
    }

    public static void main(String args[]) {
        // TODO: Options for multiple equations
//        Scanner in = new Scanner(System.in);
//        System.out.println("Which equation would you like to use?");

        System.out.println("Current Equation: x^2 - 5x - 6");
        attempts = 0;
        System.out.println("bisection:\tx: " + bisectionMethod(-4, 5) + ",\titerations: " + attempts);
        attempts = 0;
        System.out.println("netwon:\tx: " + newtonsMethod(-7) + ",\titerations: " + attempts);
        attempts = 0;
        System.out.println("secant:\tx: " + secantMethod(-4, 5) + ",\titerations: " + attempts);

    }

}
