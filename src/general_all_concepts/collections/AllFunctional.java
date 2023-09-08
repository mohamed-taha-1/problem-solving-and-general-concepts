package general_all_concepts.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AllFunctional {

	public static void main(String[] args) {

		//

		predicates();
	}

	private static void future() {

		/*
		 * In Java, a Future represents a result of an asynchronous computation or task
		 * that may not have completed yet. It's part of the java.util.concurrent
		 * package and is often used in multithreaded or asynchronous programming to
		 * manage tasks that can run concurrently.
		 */

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> futureResult = executor.submit(() -> {
			// Your asynchronous computation here
			return 42;
		});

		if (futureResult.isDone()) {
			// Task is complete
		}

		try {
			Integer result = futureResult.get();
			System.out.println("Result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			// Handle exceptions
		}

		futureResult.cancel(true); // true to interrupt the task, false to let it complete if not started

		try {
			Integer result = futureResult.get(1, TimeUnit.SECONDS); // Timeout after 1 second
			System.out.println("Result: " + result);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// Handle exceptions
		}

		/*
		 * Future is a fundamental concept in concurrent and asynchronous programming in
		 * Java and is often used when you need to perform operations in parallel or
		 * when you want to execute tasks in the background while your main program
		 * continues to run
		 * 
		 * 
		 * However, Java introduced more advanced abstractions for asynchronous
		 * programming in later versions, such as :-> CompletableFuture in Java 8, which
		 * provides more powerful and flexible ways to work with asynchronous tasks.
		 */

	}

	private static void callable() {

		// It is similar to the Runnable interface, but unlike Runnable, a Callable can
		// return a result or throw checked exceptions.

		/*
		 * The Callable interface defines a single method, V call() throws Exception,
		 * which takes no arguments and returns a result of type V. This method can
		 * throw checked exceptions, which is a key difference from the Runnable
		 * interface.
		 */

		// Create an ExecutorService to manage the execution of Callable tasks
		ExecutorService executor = Executors.newSingleThreadExecutor();

		// Define a Callable task
		Callable<Integer> callableTask = () -> {
			// Simulate a time-consuming task
			Thread.sleep(2000);
			return 42;
		};

		try {
			// Submit the Callable task for execution and receive a Future
			Future<Integer> future = executor.submit(callableTask);

			// Wait for the task to complete and get the result
			int result = future.get();
			System.out.println("Result: " + result);
		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		} finally {
			// Shutdown the executor when done
			executor.shutdown();
		}

	}

	private static void function() {

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		int sum = add.apply(5, 7);
		System.out.println("Sum: " + sum); // "Sum: 12"

		Function<Integer, String> intToString = (integer) -> Integer.toString(integer);
		String str = intToString.apply(42);
		System.out.println(str); // "42"

	}

	private static void predicates() {

		BiPredicate<Integer, Integer> isSumGreaterThanTen = (a, b) -> (a + b) > 10;

		int num1 = 5;
		int num2 = 7;
		boolean result = isSumGreaterThanTen.test(num1, num2);
		System.out.println("Is the sum of " + num1 + " and " + num2 + " greater than 10? " + result);
	}

	private static void consumer() {

		BiConsumer<String, Integer> printKeyValue = (key, value) -> {
			System.out.println("Key: " + key + ", Value: " + value);
		};

		printKeyValue.accept("Java", 11);
		printKeyValue.accept("Python", 3);
		List<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");

		// Using a Consumer to print each element in the list
		Consumer<String> printName = (name) -> System.out.println(name);

		names.forEach(printName);
	}

	private static void supplier() {

		// Create a Supplier to generate a random integer
		Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100);

		// Get a random integer using the Supplier
		int randomNumber = randomNumberSupplier.get();
		System.out.println("Random number: " + randomNumber);

	}

}
