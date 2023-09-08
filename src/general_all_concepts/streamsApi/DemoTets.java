package general_all_concepts.streamsApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoTets {

	public static void main(String[] args) {
		Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
		long count = streamFromValues.filter("a"::equals).count();
		System.out.println(count);

		Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 2);
		System.out.println("streamFromIterate = " + streamFromIterate.limit(4).collect(Collectors.toList()));

		// Stream.generate
		Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
		System.out.println("streamFromGenerate = " + streamFromGenerate.limit(3).collect(Collectors.toList()));

		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1", "a3");
		String first = collection.stream().findFirst().orElse("1");
		System.out.println("first = " + first);

		String last = collection.stream().skip(collection.size() - 1).findAny().orElse("1");
		System.out.println("last = " + last);

		boolean find = collection.stream().allMatch(s -> s.contains("a"));
		System.out.println("find = " + find);

		String third = collection.stream().skip(2).findFirst().get();
		System.out.println("third = " + third);

		System.out.println(collection.stream().distinct().collect(Collectors.toList()));

		System.out.println("Test flat map start");
		Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");
		String[] number = collection2.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream())
				.sorted((o1, o2) -> -o1.compareTo(o2)).toArray(String[]::new);
		System.out.println("number = " + Arrays.toString(number));

		System.out.println("Test min and max start");
		Collection<String> collection3 = Arrays.asList("a1", "a2", "a3", "a1");

		String max = collection3.stream().max(String::compareTo).get();
		System.out.println("max " + max);

		String min = collection3.stream().min(String::compareTo).get();
		System.out.println("min " + min);

		System.out.println();
		System.out.println("For each start");
		Collection<String> collection4 = Arrays.asList("a1", "a2", "a3", "a1");
		System.out.print("forEach = ");
		collection4.stream().map(String::toUpperCase).forEach((e) -> System.out.print(e + ","));
		System.out.println();

		Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"),
				new StringBuilder("a3"));
		list.stream().forEachOrdered((p) -> p.append("_new"));
		System.out.println("forEachOrdered = " + list);

		System.out.println();
		System.out.println("Test peek start");
		Collection<String> collection5 = Arrays.asList("a1", "a2", "a3", "a1");
//		System.out.print("peak1 = ");
		List<String> peek = collection5.stream().map(String::toUpperCase).peek((e) -> System.out.print(e + ","))
				.collect(Collectors.toList());
		System.out.println();
		System.out.println("peek2 = " + peek);

		Collection<StringBuilder> list2 = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"),
				new StringBuilder("a3"));
		List<StringBuilder> newList = list2.stream().peek((p) -> p.append("_new")).collect(Collectors.toList());
		System.out.println("newList = " + newList);

	}

}
