package multiThreading.computablFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo10 {

	//instead of we compile just 2 CompletableFuture object ; now we have the option to compile multiple CompletableFuture objects { allOf || AnyOf }
	
	
	public static void main(String[] args) {
		List<String> messages = Arrays.asList("a", "b", "c");
		List<CompletableFuture> futures = messages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> delayedUpperCase(s)))
				.collect(Collectors.toList());

		CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((v, th) -> {
			futures.forEach(cf -> System.out.println(cf.getNow(null)));  // { whenComplete } is a BI-consumer that is return something
			//{.getNow() } IT RETURN THE RESULT IF THE computation is finished ; the default value otherwise
		});
	}

	static String delayedUpperCase(String s) {
		randomSleep();
		return s.toUpperCase();
	}

	static void randomSleep() {
		try {
			TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
