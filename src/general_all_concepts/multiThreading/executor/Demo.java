package general_all_concepts.multiThreading.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> task = () -> {
			// Simulate a time-consuming task
			Thread.sleep(1000);
			return 42;
		};

		ExecutorService executor = Executors.newFixedThreadPool(4);
		Future<Integer> future = executor.submit(task);
		// Wait for the task to complete and get the result
		int result = future.get();
		System.out.println("Result: " + result);

		List<Callable<String>> called = new ArrayList<>(
				Arrays.asList(() -> "taha #1", () -> "Taha #2", () -> "Taha #3"));

		List<Future<String>> future2 = executor.invokeAll(called);

		future2.stream().map((p) -> {
			try {
				return p.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "";
		}).forEach(System.out::println);
		;

		List<Callable<String>> calledAny = new ArrayList<>(Arrays.asList(() -> {
			TimeUnit.MICROSECONDS.sleep(500);
			return "taha any #1";
		}, () -> {
			TimeUnit.MICROSECONDS.sleep(500);
			return "taha any  #2";
		}, () -> {
			TimeUnit.MICROSECONDS.sleep(50); // print this because it was less time out
			return "taha any #3";
		}));

		String future3 = executor.invokeAny(calledAny);
		System.out.println("\n any test:" + future3);

		executor.shutdown();

	}

}
