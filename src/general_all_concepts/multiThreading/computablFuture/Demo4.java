package general_all_concepts.multiThreading.computablFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Demo4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var future = CompletableFuture.runAsync(() -> {
			System.out.println("Saving User Profile via external API...");
		}).thenRun(() -> {
			System.out.println("User Profile Saved");
		});
		
		System.out.println(future.get());
		
		var es = Executors.newCachedThreadPool();
		CompletableFuture.runAsync(() -> {
			System.out.println("Saving User Profile via external API...");
		}).thenRunAsync(() -> {
			System.out.println("User Profile Saved");
		}, es);
		
		es.shutdown();
	}

}
