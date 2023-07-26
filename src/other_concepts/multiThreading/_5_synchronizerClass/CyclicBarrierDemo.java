package multiThreading._5_synchronizerClass;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierDemo {

	private static CyclicBarrier barrier;
	private List<Integer> generatedNumbers = new CopyOnWriteArrayList<>();
	private Random r = new Random();

	public static void main(String[] args) {
		/*
		 * @Param() What is the problem tends to solve ? and how we can implement and
		 * what its features.
		 * 
		 * 
		 * <T> this class tells us ; should each thread stop at a point called barrier
		 * and wait until all another threads to reach at the same point.
		 * 
		 * <T> it contains 4 to 5 method of that contains Reentrant locks
		 * 
		 * 
		 * 
		 * @Param() CyclicBarrier is another synchronisation aid that allows multiple
		 * threads to wait for each other to reach a common point before continuing
		 * their execution. It is initialised with a count, and each time a thread
		 * reaches the barrier, the count is decremented by one. Once the count reaches
		 * zero, all threads are released and can continue their execution.
		 * 
		 * 
		 * @Param() : new CyclicBarrier(3); the should 3 times of barrier.await(); for
		 * each thread;
		 * 
		 * @Param() : CountDownLatch is a simple, one-time use class that is useful for
		 * waiting for a set of operations to complete, while CyclicBarrier is a more
		 * advanced class that can be used for coordinating the execution of multiple
		 * threads, handling exceptions, and specifying a runnable action to be executed
		 * when the barrier is stripped.
		 * 
		 */

		var demo = new CyclicBarrierDemo();
		barrier = new CyclicBarrier(4, demo::numberGenerationCallback);

		var ex = Executors.newFixedThreadPool(4);
		IntStream.range(0, 50).forEach(i -> ex.submit(demo::generateNumbers));

		System.out.println("getParties(): " + barrier.getParties());
		ex.shutdown();

	}

	private void numberGenerationCallback() {
		int max = generatedNumbers.stream().mapToInt(i -> i).max().getAsInt();

		System.out.println("All generated numbers: " + generatedNumbers);
		System.out.println("Maximum: " + max);

	}

	private void generateNumbers() {
		for (int i = 0; i < 3; i++) {

			generatedNumbers.add(r.nextInt(100));
			try {
				barrier.await();

			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

	}

}
