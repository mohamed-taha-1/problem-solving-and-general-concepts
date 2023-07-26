package recuersion;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingDemo {

	public static List<List<Integer>> diceRoll(int dice) {

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();

		diceRollHelper(dice, current, result);

		return result;

	}

	private static void diceRollHelper(int numDice, List<Integer> current, List<List<Integer>> result) {

		if (numDice == 0) {
			result.add(new ArrayList<>(current)); // Found a valid combination
			return;
		}

		for (int i = 0; i < 6; i++) {

			current.add(i);
			diceRollHelper(numDice - 1, current, result);
			current.remove(current.size() - 1);

		}
	}

	public static void main(String[] args) {
		System.out.println("=========== WE--lcome in backtracking algorithm; actually it is a recursion algorithm with + a plus condition\n");
		// our first example
		
		/*
		 * Backtracking algorithm :
		 * 
		 * if(?) // base case or stop recursion
		 * else 
		 * {  
		 *  {1,2} is a recursion rule 
			 * 1.- make single choice
			 * 2. - explore the remaining / recursion 
			 * 3. - Unmade the choice ,if necessary ( backtrack ) 
		  }
		 
		 */
		
		
		     int numDice =2 ; // Number of dice to roll
	        
	        List<List<Integer>> result = diceRoll(numDice);
	        
	        System.out.println("Possible combinations:" );
	       for(List<Integer> target: result) {
	    	   System.out.println("Possible combinations:" + target);
	       }
		
			
			

	}

}
