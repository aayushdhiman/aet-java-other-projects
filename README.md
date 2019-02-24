# Other Projects from AET APCS
## ArrayListInteger
My own ArrayList class, except it only uses Integers. You might want to stick with the one that you're supposed to use. It has the basic functions of the ArrayList class, except it skips invalid commands rather than throwing an error.

## Numerical Methods to Find Roots
Uses three common methods to find the root of functions, given that the Intermediate Value Theorum (IVT) applies (That means that the function is continuous across the domain and there is at least one sign change across the domain). 

The [bisection method](https://en.wikipedia.org/wiki/Bisection_method) uses the [midpoint formula](https://www.khanacademy.org/math/geometry/hs-geo-analytic-geometry/hs-geo-distance-and-midpoints/a/midpoint-formula) to find the midpoint of the domain. Given three points, f(a), the lower bound of the domain, f(b), the upper bound of the domain, and f(c), the midpoint of the domain, if f(a) has a different sign than f(c), c becomes the new upper bound. If f(b) and f(c) have different signs, c becomes the new lower bound. It essentially mimics a binary search for the midpoint. However, this method is rather slow. 

[Newton's method](https://en.wikipedia.org/wiki/Newton%27s_method) uses a guess, x0, and the derivative of the function to find the root. Until the value of the function (f(x)) is equal to 0, the values are run through the formula Xn+1 = Xn - ((f(Xn))/((f'(Xn))). 

The [secant method](https://en.wikipedia.org/wiki/Secant_method) uses secant lines, which are lines that pass through two points of the function. One uses the intial values of the secant intersections (x0 and x1) to contruct secants through the points (x0, f(x0)) and (x1, f(x1)). This becomes the equation y = ((f(x1) - f(x0))/(x1 - x0))(x - x1) + f(x1). By solving for x (setting y to 0), one is able ot calculate the root of the line. This solution is given by x = x1 - f(x1)((x1 - x0)/(f(x1) - f(x0)). This is repeated until f(x0) is equal to 0 using thie equation Xn = Xn-1 - f(Xn-1)((Xn-1 - Xn-2)/(f(Xn-1) - f(Xn-2)).

## Movie Theater
### Part A
A bunch of computer programmers independently decide to go to the movies by themselves.  When each person reserves their seat online, the only remaining seats are in the front row.  Each person would want to choose the seat with the most distance away from other occupied seats.  In other words, each person will occupy the middle of the longest sequence of unoccupied places.

### Part B
Alter the rules so the first person randomly chooses a seat anywhere in the empty row.  Then, apply the same rule that each person will choose the seat with the most distance away from other occupied seats.
