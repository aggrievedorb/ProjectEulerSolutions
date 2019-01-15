/*
 * This program computes the solution to Project Euler problem 28, which is to
 * find the sum of the diagonals in a 1001x1001 spiral. Using the formula
 * T(n) = 4(4n^2 + n + 1) + T(n-1), where n is the current ring level, we 
 * recursively compute and print out this solution. 
 */
package projecteuler28;

public class ProjectEuler28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sumDiagonals(500));//each spiral adds 2 to the length of the side, so only need ring level 500
    }//end main method
    
    /*Calculates the sum of the diagonals for the specified ring level given
    by the passed int, returning this sum.*/
    private static int sumDiagonals(int ringLevel) {
        if (ringLevel == 0) {
            return 1;//the 0th ring is just the number 1 by itself
        }
        /*upper right value is (2ringlevel+1)^2, upper left is (2ringlevel+1)^2-2ringlevel
        bottom left is (2ringlevel+1)^2-4n and bottom right is (2ringlevel+1)^2-6n
        reducing gives the following formula*/
        return 4*(4*ringLevel*ringLevel + ringLevel + 1) + sumDiagonals(ringLevel-1);
    }//end sumDiagonals method
}//end class
