package streamsApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Stream3 {

	public static void main(String[] args) {
		
		Stream<People> peoples = Stream.of(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("William", 22, Sex.WOMEN),
                new People("Helen", 42, Sex.WOMEN),
                new People("Peter", 69, Sex.MAN)
        );
		
		
		System.out.println("ARRAYS OF multi peopesl and apply operation oon it \t \n"+
		        peoples.filter(  p-> p.getName().contains("William"))
		               .filter((p)-> p.getAge()>=22 && p.getSex()==Sex.WOMEN)
		               .count());
				
	}
}
