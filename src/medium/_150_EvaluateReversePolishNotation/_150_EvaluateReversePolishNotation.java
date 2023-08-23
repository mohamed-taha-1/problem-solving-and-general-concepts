package medium._150_EvaluateReversePolishNotation;

import java.util.Stack;

public class _150_EvaluateReversePolishNotation {

	// You are given an array of strings tokens that represents an arithmetic
	// expression in a Reverse Polish Notation.

//	The valid operators are '+', '-', '*', and '/'.
//	Each operand may be an integer or another expression.
//	The division between two integers always truncates toward zero.
//	There will not be any division by zero.
//	The input represents a valid arithmetic expression in a reverse polish notation.
//	The answer and all the intermediate calculations can be represented in a 32-bit integer.

	/*
	 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) =
	 * 9
	 */

	/*
	 * Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5))
	 * = 6
	 */

	public static int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];

			if (!token.equals("*") && !token.equals("/") && !token.equals("+") && !token.equals("-")) {
				// If the token is not an operator, parse it and push onto the stack
				stack.push(Integer.parseInt(token));
			} else {
				// If the token is an operator, pop operands from the stack and perform the
				// operation
				int operand2 = stack.pop();
				int operand1 = stack.pop();

				switch (token) {

				case "*":
					stack.push(operand1 * operand2);
					break;
				case "+":
					stack.push(operand1 + operand2);
					break;
				case "-":
					stack.push(operand1 - operand2);
					break;
				case "/":
					stack.push(operand1 / operand2);
					break;

				}
			}
		}

		// The final result should be on top of the stack
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };

		System.out.println(evalRPN(tokens));

	}

}
