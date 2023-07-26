package streamsApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Stream7 {
	
	public static void main(String[] args) {
		
		
		// stream of distinct
		Collection<String> order =Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
		List<String> List=order.stream()
				.distinct()
				.toList();
		
		System.out.println(List);
		
		
		
		
		
		
		
		//-- the second type of stream  :: Math
		System.out.println("Test anyMatch, allMatch, noneMatch  start");
		
		boolean  isOneTrueOrOneFalseAnyMatch=order.stream().anyMatch("a1"::equals);
		System.out.println(isOneTrueOrOneFalseAnyMatch);
		
		boolean isMatchAll=order.stream().allMatch(s-> s.contains("a"));
		System.out.println(isMatchAll);
		
		List<String> filterSearch=order.stream().filter(s->s.contains("2")).toList();
		System.out.println(filterSearch);
		
		
		
		
		//-- the 3rd type of stream ::Map ; so you can generate a new stream with new logic
		
		 System.out.println("Test map start");
		 
		 List<String> transformed=order.stream().map(s->s+"taha").toList();  
		 System.out.println(transformed); //- [a1taha, a2taha, a2taha, a3taha, a1taha, a2taha, a2taha]
		 
		 List<Integer> extractNumber=order
				 .stream()
				 .map(s->Integer.parseInt(s.substring(1)))
				 .toList();
		 System.out.println(extractNumber);  // [1, 2, 2, 3, 1, 2, 2]
		 
		 int[] extractNumber2=order
				 .stream()
				 .mapToInt(s->Integer.parseInt(s.substring(1)))
				 .toArray();
		 System.out.println(Arrays.toString( extractNumber2)); //[1, 2, 2, 3, 1, 2, 2]
		
		 
		
		 
		 // stream for :: FlatMap  and generate new Stream 
		 System.out.println();
	     System.out.println("Test flat map start");
		 
	     Collection<String> collection = Arrays.asList("1,2,0", "4,5");
	     String[] numbers=collection.stream()
	    		 .flatMap(s->Arrays.asList(s.split(",")).stream())
	    		 .toArray(String[]::new);
	     System.out.println(Arrays.toString(numbers)); // [1, 2, 0, 4, 5]
	     
	     int sum=collection
	    		 .stream()
	    		 .flatMap(s->Arrays.asList(s.split(",")).stream())
	    		 .mapToInt(Integer::parseInt)
	    		 .sum();
	     
	     System.out.println("The sume for the previos collection:\t"+sum); // 1+2+4+5= 12
	     
	     
	     
	     
		 
		
		
		
	}
}
