package general_all_concepts.multiThreading.computablFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo11 {

	// in this demo if one of multiple CompletableFuture object complete it finish all operation  : here will print A and not wait for complete all streams
	
	public static void main(String[] args) {
		List<String> messages = Arrays.asList("a", "b", "c");
		List<CompletableFuture> futures = messages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApply(Demo11::delayedUpperCase))
				.collect(Collectors.toList());
		CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
			if (th == null) {
				System.out.println(res);
			}
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
