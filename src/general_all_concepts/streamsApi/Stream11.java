package streamsApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Stream11 {

	public static void main(String[] args) {
		  System.out.println();
	        System.out.println("Test peek start");
	        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
	        System.out.print("peak1 = ");
	        List<String> peek = collection.stream().map(String::toUpperCase).peek((e) -> System.out.print(e + ",")).
	                collect(Collectors.toList());
	        System.out.println();
	        
	        //---- second Example
	        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
	        List<StringBuilder> newList = list
	        		.stream()
	        		.peek((p) -> p.append("_new")).collect(Collectors.toList());
	        System.out.println("newList = " + newList); 
		
		
	}
	
}
