package multiThreading.computablFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo9 {

	// this demo { thenAcceptBoth }instead of use BI-function use BI-Consumer
	//->it does not return any value and instead it consume/execute the result
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<?> future = CompletableFuture.supplyAsync(() -> "First")
				.thenAcceptBoth(CompletableFuture
						.supplyAsync(() -> " Second"), (s1, s2) -> System.out.println(s1 + s2));
		System.out.println(future.get());
	}



}
