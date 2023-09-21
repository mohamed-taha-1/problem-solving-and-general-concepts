package general_all_concepts.streamsApi;

import java.util.Arrays;
import java.util.Collection;

public class Stream9 {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("Test min and max start");
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

		System.out.println(  collection.stream().max(String::compareTo).get() );
		System.out.println(  collection.stream().min(String::compareTo).get() );
		
		
		//--------------------------
		Collection<People> peoples = Arrays.asList(
       	     new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMEN),
                new People("Peter", 69, Sex.MAN)
       );
		
		System.out.println("List  the name of poples that has Max age   "+peoples.stream().max(  (p1,p2)->(p1.getAge().compareTo(p2.getAge()) )   ).get()  );
		System.out.println("\nList  the name of poples that has Min age   "+peoples.stream().min(  (p1,p2)->(p1.getAge().compareTo(p2.getAge()) )   ).get()  );
	}

}
