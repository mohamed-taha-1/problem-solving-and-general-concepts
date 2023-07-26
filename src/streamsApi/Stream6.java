package streamsApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream6 {

	public static void main(String[] args) {

		Collection<String> collection = Arrays.asList("a1", "a3", "a3", "b3");

		System.out.println("Test findFirst and skip start");
		List<String> first = collection.stream().filter("a3"::equals).skip(1).collect(Collectors.toList());
		System.out.println("first = " + first);

		List<String> select = collection.stream().filter((s) -> s.contains("3")).collect(Collectors.toList());
		System.out.println("select = " + select);
		
		 List<String> limit = collection.stream().limit(2).collect(Collectors.toList());
	        System.out.println("limit = " + limit); 
	        
	        
        List<String> fromTo = collection.stream().skip(1).limit(3).collect(Collectors.toList());
        System.out.println("fromTo = " + fromTo);
        
        
        String last = collection.stream().skip(collection.size() -1).findAny().orElse("last child");
        System.out.println("last = " + last ); 

	}
}
