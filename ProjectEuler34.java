/*
 * This program computes the solution to Project Euler problem 34, which asks to
 * find all numbers equal to the sum of the factorial of their digits. The 
 * solution is found through a simple brute force approach. 
 */
package projecteuler34;

public class ProjectEuler34 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i < 100000; i++) {
            if (doesEqualSum(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }//end main method
    
    /*Returns true if the passed int equals the sum of the factorials of its
    digits, else false.*/
    private static boolean doesEqualSum(int toCheck) {
        int hold = toCheck;
        int currentDigit;
        int sum = 0;
        int numDigits = Integer.toString(toCheck).length();
        for (int i = 0; i < numDigits; i++) {
            currentDigit = toCheck % 10;
            sum += factorial(currentDigit);
            toCheck /= 10;
        }
        return sum == hold;
    }//end doesEqualSum method
    
    /*Returns the factorial of the passed int value.*/
    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        int product = 1;
        for (int i = 2; i <= num; i++) {
            product *= i;
        }
        return product;
    }//end factorial method
    
}//end class
