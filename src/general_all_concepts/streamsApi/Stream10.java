package streamsApi;

import java.util.Arrays;
import java.util.Collection;

public class Stream10 {

	public static void main(String[] args) {
		System.out.println();
        System.out.println("For each start");
        
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        collection.stream().map(String::toUpperCase).forEach(
        		s->System.out.println(s + ","));
        
        
        // second example
        Collection<StringBuilder> list = 
        		Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        list.stream().forEachOrdered((p) -> p.append("_new"));
        
        System.out.println(list);
        

	}

}
