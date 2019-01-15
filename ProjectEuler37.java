/*
 * This program computes the solution to Project Euler problem 37, which asks to
 * find the sum of the only 11 primes that are truncatable from left to right 
 * and right to left. We check all odds starting with 9 for primality. Once a 
 * prime is found, we check it for truncatability. Truncatable primes are then
 * summed and the sum is printed. 
 */
package projecteuler37;

public class ProjectEuler37 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int currentPrime = 7; //problem excludes 2, 3, 5, 7
        int sum = 0; //sum of truncatable primes
        int count = 0;
        do {
            currentPrime = findNextPrime(currentPrime);//find next prime
            if (isTruncatable(currentPrime)) {//check if truncatable
                count++;
                sum += currentPrime;
            }
        } while (count < 11);
        System.out.println(sum);
    }//end main method
    
    /*Checks odd numbers for primality, beginning with passed integer. Returns 
    next prime number found.*/
    private static int findNextPrime(int currentPrime) {
        int nextPrime = 0;
        boolean flag = true;
        do {
            if (isPrime(currentPrime+2)) {
                nextPrime = currentPrime + 2;
                flag = false;
            } else {
                currentPrime += 2;
            }
        } while (flag);        
        return nextPrime;
    }//end findNextPrime method
    
    /*Standard primality test. Returns true if passed integer is prime, else
    returns false.*/
    private static boolean isPrime(int toCheck) {
        if (toCheck == 1) {
            return false;
        }
        if (toCheck == 2 || toCheck == 3) {
            return true;
        }
        for (int i = 2; i <= (int)Math.ceil(Math.sqrt(toCheck)); i++) {
            if (toCheck % i == 0) {
                return false;
            }
        }
        return true;
    }//end isPrime method
    
    /*Returns true if passed prime number is a truncatable prime, else returns
    false.*/
    private static boolean isTruncatable(int currentPrime) {
        return (primeFromLeft(currentPrime) && primeFromRight(currentPrime));
    }//end isTruncatable method
    
    /*Checks for primality while removing digits moving from left to right, e.g.-
    going from 3797 to 797 to 97 to 7.*/
    private static boolean primeFromLeft(int currentPrime) {
        boolean stillPrime = true;
        String intAsString = "";
        while (currentPrime >= 10) {
            //remove first digit
            intAsString = Integer.toString(currentPrime);
            intAsString = intAsString.substring(1);
            currentPrime = Integer.valueOf(intAsString);
            //ensure remaining number is prime
            if (!isPrime(currentPrime)) {
                stillPrime = false;
                break;
            }
        }
        return stillPrime;        
    }//end primeFromLeft method
    
    /*Checks for primality while removing digits moving from right to left, e.g.-
    going from 3797 to 379 to 37 to 3.*/
    private static boolean primeFromRight(int currentPrime) {
        boolean stillPrime = true;
        while (currentPrime >= 10) {
            currentPrime = (int) Math.floor(currentPrime/10);
            if (!isPrime(currentPrime)) {
                stillPrime = false;
                break;
            }
        }
        return stillPrime;
    }//end primeFromRight method
}//end class
