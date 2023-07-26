package multiThreading.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException {

		// - as it appears this method is for delay the execution of the process to a
		// given number of time.

		/*
		 * var es = Executors.newScheduledThreadPool(4); es.schedule(() ->
		 * System.out.println("the new thead pool scheduler " +
		 * Thread.currentThread().getName()), 4, TimeUnit.SECONDS); es.shutdown();
		 */

		System.out.println("==================================================\n");
		// what if you want to start the first after 500 milliseconds and the other
		// after 1000 mill-seconds , so
		var es2 = Executors.newScheduledThreadPool(4);
		es2.scheduleAtFixedRate(() -> {
			System.out.println("hello from the custome scheduler start  fixed rate\n");
			try {

				TimeUnit.MILLISECONDS.sleep(500);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}, 5000, 1000, TimeUnit.MILLISECONDS);

		es2.awaitTermination(7, TimeUnit.SECONDS);
		es2.shutdown();

		System.out.println("==================================================\n");
		var es3 = Executors.newScheduledThreadPool(4);
		es3.scheduleWithFixedDelay(() -> {
			System.out.println("hello from the custome scheduler start  fixed delay! \n");

			// -- now i HIT the es3.shutdownNow(); and make it like es2.shutdown();
		}, 5000, 1000, TimeUnit.MILLISECONDS);

		es3.awaitTermination(7, TimeUnit.SECONDS);
		es3.shutdownNow(); // this will kill the thread even if it not completed all it is operations ; and
							// not work if you remove sleep

	}

}
