package streamsApi;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {

	public static void main(String[] args) {

		Stream<String> streamStrings = Stream.of("a1", "a2", "a2");
		Stream<String> streamStrings2 = Stream.of("a1", "a2", "a2");
		Stream<String> streamStrings3 = Stream.of("a1", "a2", "a2");
		Stream<String> streamStrings4 = Stream.of("a1", "a2", "a2");

		System.out.println("The String as list " + streamStrings.collect(Collectors.toList()));
		System.out.println(
				"contain search " + streamStrings2.filter((c) -> c.contains("1")).collect(Collectors.toList()));
		System.out.println("count all occierance of signgle element " + streamStrings3.filter("a1"::equals).count());

		System.out.println("count all occierance of signgle element "
				+ streamStrings4.filter("a1"::equals).collect(Collectors.toList()));

	}

}
