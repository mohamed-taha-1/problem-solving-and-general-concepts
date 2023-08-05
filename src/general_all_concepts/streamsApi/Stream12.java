package streamsApi;

import java.util.Arrays;
import java.util.Collection;

public class Stream12 {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("Test reduce start");

		Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 2);

		Integer sum = collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0);

		Integer oldSum = 0;
		for (int i : collection) {
			oldSum += i;
		}

		System.out.println(" the reduce result sum : " + sum + " the oldSum : " + oldSum);

		// example 2
		int max = collection.stream().reduce((s1, s2) -> s1 > s2 ? s1 : s2).orElse(0);
		System.out.println("The max int here is : " + max);

		// example 3 {return max in but in deffrent way
		int max2 = collection.stream().reduce(Integer::max).orElse(0);
		System.out.println("The way No.2 to get max element in the List is :  " + max2);

		// example 4 {return min in but in deffrent way
		int min = collection.stream().reduce(Integer::min).orElse(0);
		System.out.println("The way No.2 to get min element in the List is :  " + min);

		// example 5 return the last elemement in the list
		int last = collection.stream().reduce((s1, s2) -> s2).orElse(0);
		System.out.println("The last item in the list is  " + last);

		// example 6
		int sumWithCondion = collection.stream().filter(s -> s > 2).reduce((s1, s2) -> s1 + s2).orElse(0);
		System.out.println("the sum of items thos are bigger than 2: " + sumWithCondion);

		// example 7
		int sumOfOldItems = collection.stream().filter(s -> s % 2 == 1).reduce((s1, s2) -> s1 + s2).orElse(0);
		System.out.println("The sum of old items is : " + sumOfOldItems);

		// example 8
		int sumOfEvenItems = collection.stream().filter(s -> s % 2 == 0).reduce((s1, s2) -> s1 + s2).orElse(0);
		System.out.println("The sum of even items is : " + sumOfEvenItems);

		
		// example 9
		
		  Collection<People> peoples = Arrays.asList(
		       	     new People("William", 16, Sex.MAN),
		             new People("soha", 23, Sex.WOMEN),
		             new People("Helen", 42, Sex.WOMEN),
		             new People("nesreen", 69, Sex.WOMEN)
		        );
		  
		  
		  Object collecxtPerson = peoples.stream().filter(p->p.getSex()==Sex.WOMEN)
				  .map(People::getAge)
				  .reduce((p1,p2)-> p1>p2? p1: p2).orElse(0);
		  
		  System.out.println(" The person who has Max age && it is Woman "+collecxtPerson  );
		  
	}

}
