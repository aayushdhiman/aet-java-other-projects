package NumericalMethods;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class NumericalMethods {
	private static int bisectionTrials = 0;
	private static int newtonTrials = 0;
	private static int secantTrials = 0;
	private static int equation = 0;
	
	public static void main(String args[]) {
		// TODO: File input for equations
		// TODO: Sysin for equation
		float x = (float) (Math.random() * 7 + -1);
		System.out.println(newtonsMethod(x));

//		try {
//			System.setOut(new PrintStream(new FileOutputStream("results.txt")));
//		} catch (IOException e) {
//			System.out.println("error creating file");
//		}
//
//		print(1, "x^2 - 5x - 6", -4, 5);
//		System.out.println();
//		print(2, "x^3 + 4x^2 + 2", -8, 5);
//		System.out.println();
//		print(3, "3cos(x) - 2sin(x)", 0, 2);
//		System.out.println();
//		print(4, "e^x + x^2 - 5", 0, 2);
	}

//	public static void print(int eq, String eqS, int a, int b) {
//		bisectionTrials = 0;
//		newtonTrials = 0;
//		secantTrials = 0;
//		equation = eq;
//		System.out.println("For the equation " + eqS);
//		System.out.println(
//				"Using the bisection method, the root is on: ("
//						+ bisection(a, b)
//						+ ", 0) and it took "
//						+ bisectionTrials
//						+ " runs to calculate it.");
//		System.out.println(
//				"Using the newton method, the root is on: ("
////						+ newton(a)
//						+ ", 0) and it took "
//						+ newtonTrials
//						+ " runs to calculate it.");
//		System.out.println(
//				"Using the secant method, the root is on: ("
//						+ secant(a, b)
//						+ ", 0) and it took "
//						+ secantTrials
//						+ " runs to calculate it.");
//	}
	
	public static float function(float x) {
		return (float) (Math.pow(x, 2) - (5 * x) - 6); // x^2 -5x -6
		
	}
	
	public static float derivative(float x) {
		return 2 * x - 5; // 2x-5
		
	}
	
	public static float midPoint(float a, float b) {
		return (a + b) / 2;
	}
	
	public static boolean oppositeSigns(float x, float y) {
		return (x < 0) ? y >= 0 : (y < 0);
	}
	
	
	public static float bisectionMethod(float a, float b) {
		float c = midPoint(a, b);
		if (Math.abs(function(c)) > .0000001) {
			if (oppositeSigns(function(c), function(a))) {
				b = c;
			}else {
				a = c;
			}
			return bisectionMethod(a, b);
		}else{
			return c;
		}
	}
	
	public static float newtonsMethod(float xGuess) {
		float Xn = xGuess - (function(xGuess) / derivative(xGuess));
		if (.0000001 >= function(xGuess) && -.0000001 <= function(xGuess)) {
			return xGuess;
		} else {
			return newtonsMethod(Xn);
		}
	}

//	public static double secant(double x1, double x2) {
//		secantTrials++;
//		double x0 = (x1 * function(x2) - x2 * function(x1)) / (function(x2) - function(x1));
//		double y = function(x0);
//		if (.0000001 >= y && y >= -.0000001) {
//			return x0;
//		} else {
//			return secant(x2, x0);
//		}
//	}
}
