/*
 * This program computes the solution to Project Euler problem 22, which asks to
 * compute the sum of the name scores of names in a text file. The text file is
 * read into an array list, which is then alphabetized and the sum of the name
 * scores is then found and printed. 
 */
package projecteuler22;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectEuler22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        readListFromFile(list, "p022_names.txt");
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += ((i+1)*getNameScore(list.get(i)));
        }
        System.out.println(sum);        
    }//end main method
    
    /*By calling the alphabetValue method, calculates and returns the name score
    for the passed string.*/
    public static int getNameScore(String name) {
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            score += alphabetValue(Character.toLowerCase(name.charAt(i)));
        }
        return score;
    }//end method getNameScore
    
    /*Finds and returns the character value for the passed letter.*/
    private static int alphabetValue(char letter) {
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i < alphabet.length; i++) {
            if (letter == alphabet[i]) {
                return i+1;
            }
        }
        return -1;
    }//end method alphabetValue
    
    /*Read the names from the file using the passed fileName string and storing
    them in the passed list.*/
    public static void readListFromFile(ArrayList<String> list, String fileName) {
        try {
            Scanner stdin = new Scanner(new File(fileName));
            stdin.useDelimiter(",");
            while (stdin.hasNext()) {
                String s = stdin.next();
                list.add(s.substring(1, s.length()-1));//get rid of quotation marks
            }
            stdin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProjectEuler22.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end method readListFromFile

}//end class
