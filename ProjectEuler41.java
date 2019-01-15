/*
 * This program computes the solution to Project Euler problem 41, which asks us
 * to find the largest n-digit pandigital prime that exists. The isPanDigital
 * method from problem 32 was modified for this problem, to accept numbers of 
 * arbitrary length (as problem 32 dealt only with 9-pandigital numbers). 
 * Otherwise, this was a simple bruteforce approach, with the range of numbers
 * examined being based on the prime they gave us and the fact that any 
 * 9, 8, 6, or 5 pandigital number will be divisible by 3 (the sum of their
 * digits will be divisible by 3) so we can restrict our search to 4 and 7 digit
 * primes. The only issue I encountered was when modifying my isPanDigital 
 * method, I initially forgot to store the length of the passed integer. So as I
 * divided out digits of the number, I was then checking the list containing
 * these digits against a number of smaller length, which was giving me some
 * false answers. It was a dumb mistake I caught pretty quick, fixing the program.
 */
package projecteuler41;

import java.util.ArrayList;

public class ProjectEuler41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int maxPrime = 2143;//given by problem
        for (int i = 2145; i <= 7654321; i += 2) {
            if (isPrime(i)) {
                if (isPanDigital(i)) {
                    maxPrime = i;
                }
            }
        }
        System.out.println(maxPrime);
    }//end main method

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

    /*Returns true if passed int value is pandigital, else returns false.*/
    private static boolean isPanDigital(int toCheck) {
        int hold;
        int length = String.valueOf(toCheck).length();//store length of int, since we divide out digits
        ArrayList<Integer> list = new ArrayList<>();
        while (toCheck > 0) {
            hold = toCheck % 10;
            if (hold > 0 && hold <= length) {
                if (!(list.contains(hold))) {
                    list.add(hold);
                } else {
                    return false;//can't have repeated digits
                }
            } else {
                return false;
            }
            toCheck /= 10;
        }
        //verify all digits up to length included
        for (int i = 1; i <= length; i++) {
            if (!list.contains(i)) {
                return false;
            }
        }
        return true;
    }//end isPanDigital method
}//end class
