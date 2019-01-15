/*
 * This program computes the solution to Project Euler problem 30, which is to
 * find the sum of all numbers which can be written as the sum of the fifth 
 * powers of their digits. 
 */
package projecteuler30;

public class ProjectEuler30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i < 500000; i++) {
            if (doesEqualSum(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }//end main method    
    
    /*Checks if the passed int value is equal to the sum of the fifth power of
    its digits, returning true if equal.*/
    private static boolean doesEqualSum(int toCheck) {
        int hold = toCheck;
        int currentDigit;
        int sum = 0;
        int numDigits = Integer.toString(toCheck).length();
        for (int i = 0; i < numDigits; i++) {
            currentDigit = toCheck % 10;
            sum += (int)Math.pow(currentDigit, 5);
            toCheck /= 10;
        }
        return (sum == hold);
    }//end method doesEqualSum
    
}//end class ProjectEuler30
