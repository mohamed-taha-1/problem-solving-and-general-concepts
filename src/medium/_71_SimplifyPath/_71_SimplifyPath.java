package medium._71_SimplifyPath;

import java.util.Stack;

public class _71_SimplifyPath {

	public static String simplifyPath(String path) {
	

		 String[] parts = path.split("/");
		 Stack<String> stack = new Stack<>();
		   for(String part:parts) {
			     if(part.equals("..")) {
			    	 if (!stack.isEmpty()) {
			                stack.pop();
			            }
			     }else if(!part.isEmpty() && !part.equals(".")) {
			    	 stack.push(path);
			     }
			   
		   }
		   
		   String finalString= "/"+ String.join("/", stack);
		    
          System.out.println(finalString);
		
		return finalString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/home/";
		simplifyPath(path);
	}

}
