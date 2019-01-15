/*
 * This program computes the solution to Project Euler problem 35, which is asks 
 * to find how many circular primes there are below one million. 
 */
package projecteuler35;

public class ProjectEuler35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int toCheck = 99;//problem gave 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97
        int counter = 13;//problem gave 13 such primes already
        do {
            if (isPrime(toCheck)) {//generate a prime to check
                if (isCircular(toCheck)) {
                    counter++;
                }
            }
            toCheck += 2;
        } while (toCheck <= 1000000);
        System.out.println(counter);
    }//end main method
    
    /*Takes the passed prime value and performs all possible rotations of its
    digits, checking for primality at each rotation. If the passed prime is
    circular, returns true. Else, returns false.*/
    private static boolean isCircular(int toCheck) {
        String intAsString = Integer.toString(toCheck);
        char toRotate;
        String toRemain ;
        boolean circular = true;
        for (int i = 0; i < intAsString.length()-1; i++) {
            toRotate = intAsString.charAt(0);//grab first char of string, to be rotated to end
            toRemain = intAsString.substring(1);//get rest of string
            intAsString = toRemain + toRotate;//perform the swap
            if (!isPrime(Integer.valueOf(intAsString))) {
                circular = false;
                break;
            }    
        }
        return circular;       
    }//end isCircular method
    
    /*Primality test based on the fact that all primes are of the form
    6k+1 or 6k-1.*/
    private static boolean isPrime(int toCheck) {
        if (toCheck == 1 || toCheck % 2 == 0 || toCheck % 3 == 0) {
            return false;
        }
        for (int i = 5; i < Math.ceil(Math.sqrt(toCheck)); i += 6) {
            if (toCheck % i == 0 || toCheck % (i+2) == 0) {
                return false;
            }
        }
        return true;
    }//end isPrime method
    
}//end class
