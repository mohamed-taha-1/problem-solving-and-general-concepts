package general_all_concepts.functionalProgramming;

import java.util.function.BiFunction;

public class BI_functionDemo {
	public static void main(String[] args) {
		 BiFunction<Integer, Integer,Integer> addFunction = (a, b) -> a + b;
	    
		  int sum=addFunction.apply(3,4);
		  System.out.println(sum);
	
	}

}
