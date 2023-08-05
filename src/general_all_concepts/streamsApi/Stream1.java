package streamsApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;



public class Stream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFilterAndCount();

	}
	private static void testFilterAndCount() {
        System.out.println();
        System.out.println("Test filter and count start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<People> peoples = Arrays.asList(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMEN),
                new People("Peter", 69, Sex.MAN)
        );

        long count = collection.stream().filter("a1"::equals).count();
        System.out.println("count = " + count); 

        List<String> select = collection.stream()
        		.filter((s) -> s.contains("1"))
        		.collect(Collectors.toList());
        System.out.println("select = " + select); 

        List<People> militaryService = peoples.stream()
        		.filter((p)-> p.getAge() >= 18 && p.getAge() < 27
                && p.getSex() == Sex.MAN).collect(Collectors.toList());
        System.out.println("militaryService = " + militaryService); 

        double manAverageAge = peoples.stream().filter((p) -> p.getSex() == Sex.MAN).
                mapToInt(People::getAge).average().getAsDouble();
        System.out.println("manAverageAge = " + manAverageAge); 

        long peopleHowCanWork = peoples.stream()
        		.filter((p) -> p.getAge() >= 18)
        		.filter(
                (p) -> (p.getSex() == Sex.WOMEN && p.getAge() < 55) || 
                (p.getSex() == Sex.MAN && p.getAge() < 60)).count();
        System.out.println("peopleHowCanWork = " + peopleHowCanWork); 

    }


}
