package general_all_concepts.multiThreading.lockApi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReenterantLockApiDemo {

	private static int counter;

	private Lock lock = new ReentrantLock(); // {true} make the threads to take the same time of wait; but this probably lead to lost update

	public static void main(String[] args) throws InterruptedException {
		var instDemo = new ReenterantLockApiDemo();
		var es = Executors.newFixedThreadPool(4);
		IntStream.range(0, 10024000).forEach((i) -> es.execute(instDemo::incrementWithLock));
		terminateExecutorService(es);

		System.out.println(counter);

	}

	public void incrementWithLock() {

		try {
			lock.lock();
			counter++;
		} finally {
			lock.unlock();
		}
	}

	// if you want to test
	public void increment() {
		synchronized (this) {
			counter++;
		}
	}

	private static void terminateExecutorService(ExecutorService es) throws InterruptedException {
		es.shutdown();
		es.awaitTermination(3, TimeUnit.SECONDS);
		es.shutdownNow();
	}

}
