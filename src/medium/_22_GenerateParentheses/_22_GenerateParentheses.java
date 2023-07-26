package medium._22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

import recuersion.BacktrackingDemo;

public class _22_GenerateParentheses {

	public static List<String> generateParenthesis(int n) {

		List<String> returnList = new ArrayList<>();

		BackTrack(returnList, n, new StringBuilder(), 0, 0);

		return returnList;

	}

	private static void BackTrack(List<String> returnList, int n, StringBuilder sb, int openCount, int closeCount) {

		// base case
	    if (sb.length() == n * 2) {
	        returnList.add(sb.toString());
	        return;
	    } else {

	    	 if (openCount < n) {
	    	        sb.append("(");
	    	        BackTrack(returnList, n, sb, openCount + 1, closeCount);
	    	        sb.deleteCharAt(sb.length() - 1);
	    	    }
	    	
	    	
	    	 
	    	 // Add close parenthesis if the count of close parenthesis is less than open parenthesis
	    	    if (closeCount < openCount) {
	    	        sb.append(")");
	    	        BackTrack(returnList, n, sb, openCount, closeCount + 1);
	    	        sb.deleteCharAt(sb.length() - 1);
	    	    }
	    	
	    	
			}

	}

	public static void main(String[] args) {
		System.out.println("generate parancess based on the number you take ");
		int num=1;
		System.out.println("the n parancess for"+generateParenthesis(num)); 
		
		

	}

}
