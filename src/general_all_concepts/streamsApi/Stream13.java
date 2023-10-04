package general_all_concepts.streamsApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream13 {

	public static void main(String[] args) {
		
		System.out.println();
        System.out.println("Test distinct start");

        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
        
        List<String> distinct=strings.stream().distinct().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(" list of distinct  Uppercase  String : "+ distinct ); // [A1, B2, C3]
        
        // 2en example
        String join = strings.stream().collect(Collectors.joining(" : ", "<b> ", " </b>"));
        System.out.println(join);  // <b> a1 : b2 : c3 : a1 </b>
        
        //3rd example 
        
        //-- this will loop over every string in the list and cut from it the key and the value and convert all th list to Map<key, Value>
        Map<String, String> maped = strings.stream().distinct().collect(Collectors.toMap(  ( s )->s.substring(0,1) ,(s)->s.substring(1,2)));
        System.out.println( maped.entrySet() );  //[a=1, b=2, c=3]   || [1=1, 2=2, 3=3] for key { substring(1,2) } 
        		
        		
        // 4 example 
        Map<String, List<String>> group = strings.stream().distinct().collect(Collectors.groupingBy(p->p.substring(0,1) )); // for every a or b or c put the value without substring in a list as a value 
        System.out.println(group);  // {a=[a1], b=[b2], c=[c3]}
        
        
        //-5 example
        Collection<String> collecStrings = Arrays.asList("a1", "b2", "c3", "a1","a3","a1");
        Map<String , String>  groupJoin=collecStrings.stream().collect(
        		           Collectors.groupingBy( 
        		        		   (p) -> p.substring(0, 1), Collectors.mapping(
        		        		   																	(p) -> p.substring(1, 2), Collectors.joining(":")
        		        		   															  )));
        System.out.println( groupJoin );  //  {a=1:1:3:1, b=2, c=3} ; because there are duplicates ,
                                          // so it  group all duplicates by cutting the number and separate with `:`  l for first a { substring(0, 1) } 
        
        // -6 example 
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int  oldSum=numbers.stream().collect(Collectors.summingInt(p->p%2 ==1? p : 0 ));
        System.out.println(oldSum); // 1+3= 4
        
        double average= numbers.stream().collect(Collectors.averagingDouble(p->p-1));
        System.out.println(average); // 6/4 =1.5 because  the value -1 / count of all values
        
        IntSummaryStatistics statistics=numbers.stream().collect(Collectors.summarizingInt(p->p));
        System.out.println(statistics);  // IntSummaryStatistics{count=4, sum=10, min=1, average=2.500000, max=4} 
        
        long sumEven = numbers.stream().collect(Collectors.summarizingInt((p) -> p % 2 == 0 ? p : 0)).getSum();
        System.out.println("sumEven = " + sumEven);  // sumEven = 6

        Map<Boolean, List<Integer>> parts = numbers.stream().collect(Collectors.partitioningBy(p->p%2==0)); 
        System.out.println(parts);  // {false=[1, 3], true=[2, 4]}   .. you partitioned the result based on the condition and return key as boolean {True , false} and the value as a List
        
		
		

	}

}
