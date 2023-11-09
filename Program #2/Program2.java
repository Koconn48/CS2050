/*
 * Your name: Kevin O'Connell
 * Description: Program #2 - jUnit
 */


public class Program2 {

    // TODO #1: finish the method's implementation
    public static double add(double a, double b) {
        return a + b;
    }
    // TODO #2: finish the method's implementation
    public static double subtract(double a, double b) {
        return a - b;
    }
    // TODO #3: finish the method's implementation
    public static double multiply(double a, double b) {
        return a * b;
    }

    // TODO #4: finish the method's implementation
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN; // Return NaN (Not-a-Number) for an undefined result
        }
        return a / b;
    }

    // TODO #5: finish the method's implementation - assume right triangle
    public static double sineOfAngle(double oppSide, double hyp) {
        if (hyp == 0) {
            System.out.println("Error: Hypotenuse cannot be zero.");
            return Double.NaN; // Return NaN for an undefined result
        }
        return oppSide / hyp;
    }

    // TODO #6: finish the method's implementation - assume right triangle
    public static double hypOfTriangle(double sideA, double sideB) {
        return Math.sqrt(sideA * sideA + sideB * sideB);
    }
        //add examples
    public static void main(String[] args) {

        double result1 = add(7.3, 9.45);
        double result2 = subtract(8.12, 5.32);
        double result3 = multiply(6.76, 5.0);
        double result4 = divide(10.0, 5.0);
        double result5 = sineOfAngle(15.0, 12.0);
        double result6 = hypOfTriangle(6.0, 13.0);

        // print computations
        System.out.println("Result of adding: " + result1);
        System.out.println("Result of subtracting: " + result2);
        System.out.println("Result of multiplying: " + result3);
        System.out.println("Result of dividing: " + result4);
        System.out.println("Sine of angle: " + result5);
        System.out.println("Hypotenuse of triangle: " + result6);
    }
}


