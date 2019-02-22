package NumericalMethods;
import java.sql.SQLOutput;
import java.util.*;

public class NumericalMethods {
	public static double x0 = -8;
	public static double x1 = 5;
	static int guess = (int) (Math.random() * (Math.abs(x1 - x0) + 1) + x0);
	static int iterations = 0;
	
	public static double functionEquation(double variable) {
		return Math.pow(variable, 3) + 4 * Math.pow(variable, 2) + 2;
	}
	
	public static double derivativeEquation(double variable) {
		return 3 * Math.pow(variable, 2) + 8 * variable;
	}
	
	public static double newtonsMethod(double guess) {
		guess = guess - (functionEquation(guess)/derivativeEquation(guess));
		if (guess !=.0001 ) {
			newtonsMethod(guess);
			iterations++;
		}
		return guess;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("The equation is f(x) = x^3 + 4x^2 + 2");
		iterations = 0;
		System.out.println("Newton's Method: \tx = " + newtonsMethod(guess) + ", iterations = " + iterations);
		
	}
}
