package general_all_concepts.multiThreading.executor;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorInterface {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		ExecutorService execService = java.util.concurrent.Executors.newCachedThreadPool();

		execService.execute(() -> System.out.println("Hello from thred" + Thread.currentThread().getName()));
		execService.execute(() -> System.out.println("Hello from thred" + Thread.currentThread().getName()));
		execService.execute(() -> System.out.println("Hello from thred" + Thread.currentThread().getName()));

		// now what if i want to wrap the result into a wrapper like future or callable
		String s = "taha";
		Future<String> geted = execService.submit(() -> s.substring(0, 3));
		System.out.println("Taha after substring it \t" + geted.get(40, TimeUnit.SECONDS));

		// second imperative example YA TAHA;use called + invoke all cause of submit for
		// 1 task not multiple
		List<Callable<String>> called = new ArrayList<>(
				Arrays.asList(() -> "taha #1", () -> "Taha #2", () -> "Taha #3"));
		List<Future<String>> futeExecute = execService.invokeAll(called);

		futeExecute.stream().map((p) -> {
			try {
				return p.get();

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return "";

		}).forEach(System.out::println);

		// ####### end of second example and it works well!
		// third example of invoke any

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

		String futeExecuteAny = execService.invokeAny(calledAny); // here is the difference of the return number of
																	// element here is 1 not list
		System.out.println("\n any test:" + futeExecuteAny);

	}

}
