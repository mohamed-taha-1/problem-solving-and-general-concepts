package general_all_concepts.multiThreading.computablFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<CompletableFuture<Double>> result = getUserDetailById(125)
				.thenApply(user -> getCreditRating(user));
		
		System.out.println(result.get().get());
		
		CompletableFuture<Double> result2 = getUserDetailById(125)
				.thenCompose(user -> getCreditRating(user)); // Awesome; this soul is more elegant that the above one
		System.out.println(result2.get());
	}
	
	private static CompletableFuture<String> getUserDetailById(int userId) {
		return CompletableFuture.supplyAsync(() -> {
			return "user details string";
		});	
	}

	private static CompletableFuture<Double> getCreditRating(String userDetails) {
		return CompletableFuture.supplyAsync(() -> {
			return 110.98;
		});
	}

}
