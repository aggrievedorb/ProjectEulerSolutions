/*
 * This program computes the solution to Project Euler problem 37, which asks to
 * find the value of p <= 1000, representing the perimeter of a right triangle,
 * which has the largest number of pythagorean triplets where a + b + c = p. 
 * A simple iterative approach is taken to find the value of p with the most
 * triplets.
 */
package projecteuler39;

public class ProjectEuler39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int maximizedP = 0;
        int maxSolutions = 0;
        int numSolutions;
        for (int p = 2; p <= 1000; p += 2) {//p is always even, since a^2 + b^2 = c^2 and a+b+c = p
            numSolutions = 0;
            for (int a = 2; a < (p / 3); a++) {//since a < b < c and a + b + c = p, we have a < p/3
                if (p*(p-2*a) % (2*(p-a)) == 0) {
                    numSolutions++;
                }
            }
            if (numSolutions > maxSolutions) {
                maxSolutions = numSolutions;
                maximizedP = p;
            }
        }
        System.out.println(maximizedP);
    }//end main method

}//end class
