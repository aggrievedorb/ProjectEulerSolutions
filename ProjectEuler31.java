/*
 * This program computes the solution to Project Euler problem 31, which is to 
 * find the number of ways to make two pounds using any combination of British
 * coins. We use an array to hold the value representing the number of ways we 
 * can make the value corresponding to the index of the array, with index 0 being
 * set as 1. So waysToMake[200] contains the value representing the number of 
 * ways to make 200 pence/2 pounds.
 */
package projecteuler31;

public class ProjectEuler31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};//represent coins in pennies
        int[] waysToMake = new int[201];
        waysToMake[0] = 1;//saying one way to make 0 coins
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < waysToMake.length; j++) {
                waysToMake[j] += waysToMake[(j-coins[i])];//build soln
            }
            
        }
        System.out.println(waysToMake[200]);
    }//end main method
    
}//end class
