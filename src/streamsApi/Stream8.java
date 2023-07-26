package streamsApi;

import java.util.Arrays;
import java.util.Collection;

public class Stream8 {

	public static void main(String[] args) {
		
		 System.out.println();
	        System.out.println("Test sorted start");

	        Collection<String> collection = Arrays
	        		.asList("a1", "a4", "a3", "a2", "a1", "a4");
	        
	       System.out.println( collection.stream().sorted().toList()  ); 
	       System.out.println(" romoved duplicates from the sorted list "+ collection.stream().sorted().distinct().toList()  ); 
	       System.out.println(" the sorted list are reversed "+ collection.stream()
	       .sorted( (o1,o2)-> -o1.compareTo(o2) ) // note {-} added befor it 
	       .distinct()
	       .toList()  ); 

	       //--------------------------------------------
	       
	       Collection<People> peoples = Arrays.asList(
	                new People("William", 16, Sex.MAN),
	                new People("John", 23, Sex.MAN),
	                new People("Helen", 42, Sex.WOMEN),
	                new People("Peter", 69, Sex.MAN)
	        );
	       
	       System.out.println("the sorted pople in reverse order with all details :::::::::::::::::::::::::\n \t"+  peoples.stream()
	                     .sorted( (p1,p2)->-p1.getName().compareTo(p2.getName())   )
	                     .toList()
	    		   );
	       
	       System.out.println(" compare by sex and sorted "+peoples.stream()
	    		   			.sorted( (p1,p2)-> ( p1.getSex()!= p2.getSex() ? p1.getSex().compareTo(p2.getSex()) : p1.getAge().compareTo(p2.getAge())))  
	    		   			.toList() );

	}

}
