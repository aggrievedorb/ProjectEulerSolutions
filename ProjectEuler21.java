/*
 * This program computes the solution to Project Euler problem 21, which asks to
 * find the sum of all amicable numbers under 10,000. Amicable numbers are 
 * identified iteratively and then summed. 
 */
package projecteuler21;


public class ProjectEuler21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0;
        int toCheck;
        int secondSum;
        for (int i = 2; i < 10000; i++) {
            toCheck = sumOfDivisors(i);
            secondSum = sumOfDivisors(toCheck);
            if (secondSum == i && i < toCheck) {//the inequality ensures we don't repeat numbers later in the for loop
                sum += (i+toCheck);
            }
        }
        System.out.println(sum);
    }//end main method
    
    /*Calculates and returns the sum of the divisors of the passed int value.*/
    private static int sumOfDivisors(int toDivide) {
        if (toDivide == 1) 
            return 1;
        int sum = 1;//1 divides everything
        for (int i = 2; i <= Math.ceil(Math.sqrt(toDivide)); i++) {
            if (toDivide % i == 0) {
                if (i*i == toDivide) {
                    sum += i;//only add perfect squares once
                } else {
                    sum += (i + (toDivide/i));
                }
            }
        }
        return sum;
    }//end method sumOfDivisors
    
}//end class
