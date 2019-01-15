/*
 * This program computes the solution to Project Euler problem 20, which asks to
 * find the sum of the digits in the number 100!. A factorial function is built
 * to find the factorial of BigIntegers and then the digits are summed.
 */
package projecteuler20;
import java.math.*;

public class ProjectEuler20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigInteger toSum = new BigInteger("100");
        System.out.println("The sum of digits of " + toSum + "! is " +
                getSumOfDigits(bigIntFactorial(toSum)));
    }//end main method
    
    /*Implements a factorial function using the BigInteger class, returning
    the factorial of the passed value.*/
    private static BigInteger bigIntFactorial(BigInteger num) {
        if (num.compareTo(new BigInteger("0")) == 0 || num.compareTo(new BigInteger("1")) == 0) {
            return new BigInteger("1");
        }
        BigInteger product = new BigInteger("1");
        BigInteger i = new BigInteger("2");
        while (i.compareTo(num) <= 0) {
            product = product.multiply(i);
            i = i.add(new BigInteger("1"));            
        }
        return product;
    }//end method bigIntFactorial
    
    /*Iteratively sums the digits of the passed BigInteger value, returning
    this sum.*/
    private static BigInteger getSumOfDigits(BigInteger num) {
        BigInteger sum = new BigInteger("0");
        BigInteger zero = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        while (num.compareTo(zero) > 0) {
            sum = sum.add(num.mod(ten));
            num = num.divide(ten);
        }
        return sum;
    }//end method getSumOfDigits
}//end class
