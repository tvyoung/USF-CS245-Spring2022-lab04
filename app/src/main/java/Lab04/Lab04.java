package Lab04;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author Vicki Young
  * @date 2022.02.24
  * given an integer, n, program returns a list of unique combinations of its factors
  **/
public class Lab04 {

/** multiSum() accepts an integer n, returns a list of unique factor combinations to n 
  *  first creates a starting factor which includes either 0 or 1
  *  then calls the findFactors() function to recursively find other additional factor combinations of n 
  * @param n integer to calculate for unique combination of factors
  * @return an arraylist of unique arraylist of factors to n
  * @throws NumberFormatException if given integer n is negative
  **/
  public static List<List<Integer>> multiSum(int n) throws NumberFormatException{

    //throws exception if given integer is negative or if n >= 2^16
    if (n < 0 || n >= 65536) {
      throw new NumberFormatException("Try again with a positive integer.");
    } 

    //initializes arraylist of unique arraylist of factors
    List<List<Integer>> factorsList = new ArrayList<>();

    //creates the first factor combination
    List<Integer> startingFactor = new ArrayList<>();

    //if given integer n = 0 or 1, returns the first (and only) factor which consists only of n
    if (n == 0 || n == 1) {
      startingFactor.add(n);
      factorsList.add(startingFactor);
      return factorsList;
    }
    
    //the first factor combination will be [1, n]
    startingFactor.add(1);
    startingFactor.add(n);
    factorsList.add(startingFactor);

    //creates empty arraylist of factors
    List<Integer> factors = new ArrayList<>();

    //calls findFactors() function to find the rest of the unqiue combinations of factors
    findFactors(2, 1, n, factorsList, factors);

    //returns arraylist of unique factor combinations
    return factorsList;
  }

/** findFactors() recursively finds the unique combinations of factors for given integer n
  * @param start starting point from which to icrement toward n
  * @param product accumulated product of factors of n
  * @param n integer to calculate for unique combinations of factors
  * @param factorsList arraylist of unique factor combinations
  * @param factors the unique combination of factors
  **/
  public static void findFactors(int start, int product, int n, List<List<Integer>> factorsList, List<Integer> factors) {
    //base case: returns function call if starting point > n or if accumulated product of n factors > n
    if (start > n || product > n) { 
      return;
    }

    //once accumulated product of n factors = n, unique factor combination is complete; adds it to factorsList
    if (product == n) {
      List<Integer> factorCombo = new ArrayList<>(factors);
      factorsList.add(factorCombo);
      return;
    }

    //loops from i = starting point and increments toward n, checking if i is a factor of n
    //and if so, how many unique combinations of factors can be made with i
    for (int i = start; i < n; i++) {
      //breaks out of for loop once i * product > n (but not if i * proudct == n)
      if (i * product > n) {
        break;
      }

      //recursive step: where i is a factor of n (dividing n by i gives remainder of 0)
      if (n % i == 0) {
        factors.add(i);
        //FOR TESTING: System.out.println("i: " + i + " i*product: " + i*product + " factors: " + factors);
        findFactors(i, i*product, n, factorsList, factors);
        //backtracks by removing the last added factor in combination of factors made with i 
        factors.remove(factors.size()-1);
      }
    }
  }

/** main method for testing
  **/
  public static void main(String[] args){
    //alter n for testing
    int n = 16;
    System.out.print("Expected result for " + n + ":\n" + " [[1,16], [2,8], [2,2,4], [2,2,2,2], [4,4]]\n");
    System.out.print("A total number of unique results found: 5\n");
    System.out.print("------------------------\n");
    System.out.print("Actual result for " + n + ": " + multiSum(n));
  }
}