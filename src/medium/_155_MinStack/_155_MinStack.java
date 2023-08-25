package medium._155_MinStack;

import java.util.Stack;

public class _155_MinStack {
  // Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	
	/*
	 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
	 * [[],[-2],[0],[-3],[],[],[],[]]   ==> [null,null,null,null,-3,null,0,-2]
	 */


	static class  MinStack {
		    private Stack<Integer> stack;
		    private Stack<Integer> minStack;

		    public MinStack() {
		        stack = new Stack<>();
		        minStack = new Stack<>();
		    }
		

		    public void push(int val) {
		    	stack.push(val);
		    	if(minStack.isEmpty() || val<=minStack.peek()) minStack.push(val);
		        
		    }
		    
		    public void pop() {
		    	if(stack.isEmpty()) return;
		    	if(stack.peek().equals(minStack.peek())) minStack.pop();
		    	stack.pop();
		        
		    }
		    
		    public int top() {
		        return stack.peek();
		    }
		    
		    public int getMin() {
		        return minStack.peek();
		    }
		    
		}
	
	
	public static void main(String[] args) {
		 MinStack obj = new MinStack();
		  obj.push(40);
		  obj.push(7);
		  obj.push(20);
		  obj.push(3);
		  obj.pop();

		
		  int param_3 = obj.top();
		  int param_4 = obj.getMin();
		  
		  System.out.println( "Cuurent val of stack value:\t"+param_3);
		  System.out.println( "Min value:\t"+param_4);

	}

}
