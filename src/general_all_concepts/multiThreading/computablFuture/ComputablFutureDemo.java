package general_all_concepts.multiThreading.computablFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ComputablFutureDemo {

	public static void main(String[] args) throws InterruptedException {
		// it help us to handle multiThreading + parallel tasks 
		CompletableFuture.runAsync(()->{
			System.out.println("the first patch "+Thread.currentThread().getName());
			System.out.println("the second patch ");
			
		});
//		
		TimeUnit.SECONDS.sleep(2);
		
		ExecutorService es= Executors.newFixedThreadPool(6);
		CompletableFuture.runAsync(()->{
			System.out.println("the first patch  es "+Thread.currentThread().getName());
			System.out.println("the second patch es ");
			
		},es);
		
		
		es.shutdown();
		
		
	
		
		
		

	}

}
