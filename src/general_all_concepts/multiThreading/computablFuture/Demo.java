package general_all_concepts.multiThreading.computablFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5);
		CompletableFuture<Void> voidFuture = future.thenAccept(result -> System.out.println("Result: " + result));
		voidFuture.get();

		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 5);
		CompletableFuture<String> composedFuture = future3
				.thenCompose(result -> CompletableFuture.supplyAsync(() -> "Composed: " + result + 10));
		System.out.println(composedFuture.get()); // Composed: 510

		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 5);
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> combinedFuture = future1.thenCombine(future2,
				(result1, result2) -> result1 + " " + result2);
		System.out.println(combinedFuture.get()); // 5 Hello

		CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> 5);
		CompletableFuture<Void> voidFuture5 = future5.thenRun(() -> System.out.println("Task completed"));
		voidFuture5.get(); // Task completed

		CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Oops!");
		});
		CompletableFuture<Integer> recoveredFuture = future6.exceptionally(ex -> -1);
		System.out.println(recoveredFuture.get()); // -1

		
		
		CompletableFuture<Integer> futur7 = CompletableFuture.supplyAsync(() -> {
			// Simulate an exception
			throw new RuntimeException("Oops!");
		});

		CompletableFuture<Integer> handledFuture7 = futur7.handle((result, exc) -> {
			if (exc != null) {
				System.out.println("Exception happened during the execution: " + exc.getClass());
				System.out.println("Exception is caused by: " + exc.getCause());
				return -1; // Provide a default value in case of exception
			} else {
				return result; // Use the actual result
			}
		});

		handledFuture7.get();
	}

}
