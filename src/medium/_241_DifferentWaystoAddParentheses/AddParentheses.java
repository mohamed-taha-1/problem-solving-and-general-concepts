package medium._241_DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddParentheses {
//	Input: expression = "2-1-1"
//			Output: [0,2]
//			Explanation:
//			((2-1)-1) = 0 
//			(2-(1-1)) = 2
	
	
	//  "2*3-4*5" ; so there exists memoization
	
	
	public static  List<Integer> diffWaysToCompute(String expression) {
		  List<Integer> result = new ArrayList<>();
	        
	        for (int i = 0; i < expression.length(); i++) {
	            char c = expression.charAt(i);
	            
	            if (c == '+' || c == '-' || c == '*') {
	                // Split the expression into two parts at the operator
	                String leftExpr = expression.substring(0, i);
	                String rightExpr = expression.substring(i + 1);
	                
	                // Recursively compute the results for the left and right expressions
	                List<Integer> leftResults = diffWaysToCompute(leftExpr);
	                List<Integer> rightResults = diffWaysToCompute(rightExpr);
	                
	                // Combine the results using the current operator
	                for (int left : leftResults) {
	                    for (int right : rightResults) {
	                        if (c == '+') {
	                            result.add(left + right);
	                        } else if (c == '-') {
	                            result.add(left - right);
	                        } else if (c == '*') {
	                            result.add(left * right);
	                        }
	                    }
	                }
	            }
	        }
	        
	        // If no operator is found, the expression is a single number; add it to the result
	        if (result.isEmpty()) {
	            result.add(Integer.parseInt(expression));
	        }
	        
	        return result;
	    }
	    
	    
	 
	 public static void main(String[] args) {
		String expression="2-1-1" ;
		System.out.println(diffWaysToCompute(expression) );
	}
}
