package general_all_concepts.multiThreading.computablFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub var future = CompletableFuture.supplyAsync(()
		// -> {
		
		
		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Request User Profile from external API...");
			return 30;
		}).thenAccept((result) -> {
			System.out.println("User Profile Received: " + result);  // the difference here is that we do not return anything just execute 
		});
		
		System.out.println(future.get()); // here will out: null because there are no return 
		
		var es = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			System.out.println("Request User Profile from external API...");
			return 40;
		}).thenAcceptAsync((result) -> {
			System.out.println("User Profile Received: " + result);
		}, es);
		
		es.shutdown();
	}
		

	}


