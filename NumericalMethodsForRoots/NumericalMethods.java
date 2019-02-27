package NumericalMethods;

public class NumericalMethods {
	private static double tolerance = .000001;
	private static int bisectionIterations = 0;
	private static int newtonsIterations = 0;
	private static int secantsIterations = 0;
	private static int equationNum = 0;
	
	public static void main(String args[]) {
		System.out.println("Equation: x^2 - 5x - 6");
		runAllTests(1, -4, 5);
		
		System.out.println("Equation: x^3 + 4x^2 + 2");
		runAllTests(2,  -8, 5);
		
		System.out.println("Equation: 3cos(x) - 2sin(x)");
		runAllTests(3,  0, 2);
		
		System.out.println("Equation: e^x + x^2 - 5");
		runAllTests(4, 0, 2);
		
	}
	
	public static void runAllTests(int eq, int a, int b) {
		bisectionIterations = 0;
		newtonsIterations = 0;
		secantsIterations = 0;
		equationNum = eq;
		System.out.println(
				"bisectionMethod: x = " + bisectionMethod(a, b) + "\titerations:  " + bisectionIterations);
		System.out.println(
				"newtonMethod: x = " + newtonMethod(a) + "\titerations: " + newtonsIterations);
		System.out.println(
				"secantMethod: x = " + secantMethod(a, b) + "\titerations: " + secantsIterations);
		System.out.println("=======================================================\n");
	}
	
	public static double function(double x) {
		switch (equationNum) {
			case 1:
				return Math.pow(x, 2) - (5 * x) - 6; // x^2 -5x -6
			case 2:
				return Math.pow(x, 3) + 4 * (Math.pow(x, 2)) + 2; // x^3 +4x^2 +2
			case 3:
				return (3 * Math.cos(x)) - (2 * Math.sin(x)); // 3cos(x) - 2sin(x)
			case 4:
				return (Math.pow(Math.E, x)) + (Math.pow(x, 2)) - 5; // e^x + x^2 -5
			default:
				return Math.pow(x, 2) - (5 * x) - 6; // x^2 -5x -6
		}
	}
	
	public static double derivative(double x) {
		switch (equationNum) {
			case 1:
				return 2 * x - 5; // 2x-5
			case 2:
				return 3 * (Math.pow(x, 2)) + 8 * x; // 3x^2+8x
			case 3:
				return (-3 * Math.sin(x)) - (2 * Math.cos(x)); // -3sin(x) - 2cos(x)
			case 4:
				return (Math.pow(Math.E, x)) + 2 * x; // e^x + 2x
			default:
				return Math.pow(x, 2) - (5 * x) - 6; // x^2 -5x -6
		}
	}
	
	public static double bisectionMethod(double a, double b) {
		double midPoint = (a + b) / 2;
		while (Math.abs(function(midPoint)) > tolerance) {
			bisectionIterations++;
			if (function(midPoint) * function(a) > 0) a = midPoint;
			else b = midPoint;
			midPoint = (a + b) / 2;
		}
		return midPoint;
	}
	
	public static double newtonMethod(double x0) {
		newtonsIterations++;
		double x1 = x0 - (function(x0) / derivative(x0));
		if (tolerance >= function(x1) && function(x1) >= -tolerance) {
			return x1;
		} else {
			return newtonMethod(x1);
		}
	}
	
	public static double secantMethod(double x1, double x2) {
		secantsIterations++;
		double x0 = (x1 * function(x2) - x2 * function(x1)) / (function(x2) - function(x1));
		if (tolerance >= function(x0) && function(x0) >= -tolerance) {
			return x0;
		} else {
			return secantMethod(x2, x0);
		}
	}
}

