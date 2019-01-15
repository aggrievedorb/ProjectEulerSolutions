/*
 * This program computes the solution to Project Euler problem 32, which is to
 * find the sum of products whose multiplicand/multiplier/product identity can 
 * be written as a 1 through 9 pandigital. Because we only want numbers with 9
 * digits, we can reduce the set of numbers we range over to be 1-9 times 1000-
 * 9999 and 10-99 times 100-999, as this will generate four or five digit products.
 * So by simply running over these ranges and identifying products that give
 * 9-pandigital numbers, we readily find our solution.
 */
package projecteuler32;
import java.util.*;

public class ProjectEuler32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(findSum());
    }//end main method
    
    /*Returns true if passed long value is 9-pandigital, else returns false.*/
    private static boolean isPanDigital(long toCheck) {
        int hold;
        ArrayList<Integer> list = new ArrayList<>();
        while (toCheck > 0) {
            hold = (int) (toCheck % 10);
            if (!list.contains(hold) && hold > 0 && hold < 10) {
                list.add(hold);
            } else {
                return false;//can't have repeated digits
            }
            toCheck /= 10;
        }
        for (int i = 1; i <= 9; i++) {
            if (!list.contains(i)) {
                return false;
            }
        }
        return true;
    }//end isPanDigital method
    
    /*Returns the sum of the products where the multiplier, multiplicand and
    product is 9-pandigital when concatenated together.*/
    private static long findSum() {
        long sum = 0;
        sum += sumUp(1, 9, 1000, 9999);//handle case where multiplier is one digit
        sum += sumUp(10, 99, 100, 999);//handle case where multiplier is two digits
        return sum;
    }//end findSum method
    
    /*Ranges over the passed values to find products having the desired 9-pandigital
    property, which are then summed up and returned as a long.*/
    private static long sumUp(int lowbdMultiplier, int upbdMultiplier, int lowbdMultiplicand, int upbdMultiplicand) {
        long sum = 0;
        int hold;
        ArrayList<Integer> list = new ArrayList<>();
        String toCheck = "";
        for (int i = lowbdMultiplier; i <= upbdMultiplier; i++) {
            for (int j = lowbdMultiplicand; j <= upbdMultiplicand; j++) {
                hold = i * j;
                if (!list.contains(hold)) {
                    toCheck = Integer.toString(hold).concat(Integer.toString(i)).concat(Integer.toString(j));
                    if (isPanDigital(Long.parseLong(toCheck))) {
                        sum += hold;
                        list.add(hold);
                    }
                }
            }
        }
        return sum;
    }//end sumUp method
}//end class
