package multiThreading.computablFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> comFut=CompletableFuture.supplyAsync(()->"hello");
		System.out.println(comFut.get());
		
		
		
		
		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Request User ID from external API...");
			return 1234;
		}).thenApply((result) -> {
			System.out.println("Requst total number of purchases in other service by ID...");
			return 150+ result;  // here the result is: 1234
		});
		
		System.out.println(future.get());
		
		var es = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			System.out.println("Request User ID from external API...");
			return 1234;
		}).thenApplyAsync((result) -> {
			System.out.println("Requst total number of purchases in other service by ID...");
			return 1050+ result;
		}, es);
		

		
		es.shutdown();

	}

}
