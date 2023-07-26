package streamsApi;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream4 {

	public static void main(String[] args) {
		// Stream from array
		Integer[] numbers = { 1, 5, 3, 5, 9 };
		Stream<Integer> streadNumbers = Arrays.stream(numbers);
		System.out.println("Streamd Number \t " + streadNumbers.filter(s -> s >= 5).collect(Collectors.toList()));

		
		Stream<Integer> streadNumbers2 = Stream.of(numbers);
		System.out.println("Streamd Number \t " + streadNumbers2.filter(s -> s == 5).collect(Collectors.toList()));
		
	}

}
