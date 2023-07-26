package multiThreading._5_synchronizerClass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CutdownLatchDemo {
	private static final int COUNT = 4;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * <T> It make one or more thread wait for termination of other threads to to
		 * terminate their operations
		 * 
		 * <T> so this differ from cyclicBarrier; may be if one thread finish wait to
		 * other to get the same point not waiting them to finish all its operation
		 *
		 * 
		 * @Param() CountDownLatch is a synchronisation aid that allows one or more
		 * threads to wait for a set of operations to complete. It is initialised with a
		 * count, and each time the count is decremented by one, the waiting threads are
		 * released. Once the count reaches zero, all threads are released and can
		 * continue their execution.
		 *
		 *
		 * @Param() is count == 5 then should make {- } 5 times :
		 * countDownLatch.countDown(); for each thread.
		 *
		 *
		 *
		 *
		 *
		 * @Param(): ### difference ####
		 *
		 * 1. The main difference between CountDownLatch and CyclicBarrier is the way
		 * they handle exceptions. CountDownLatch does not provide any mechanism to
		 * handle exceptions thrown by the threads that are waiting on the latch. If an
		 * exception is thrown by one of the threads, the latch will not be decremented,
		 * and the other threads will continue to wait indefinitely.
		 *
		 * 2. CyclicBarrier, on the other hand, provides a way to handle exceptions
		 * thrown by the threads. It has a broken state that is set when a thread throws
		 * an exception while waiting on the barrier. Once the barrier is broken, all
		 * threads that are currently waiting on the barrier will be released and any
		 * subsequent threads that try to wait on the barrier will be thrown a
		 * BrokenBarrierException.
		 * 
		 * 
		 * @Param() : CountDownLatch is a simple, one-time use class that is useful for
		 * waiting for a set of operations to complete, while CyclicBarrier is a more
		 * advanced class that can be used for coordinating the execution of multiple
		 * threads, handling exceptions, and specifying a runnable action to be executed
		 * when the barrier is stripped.
		 * 
		 * 
		 * 
		 *
		 */

		CountDownLatch countDownLatch = new CountDownLatch(COUNT);
		var es = Executors.newFixedThreadPool(3);

		IntStream.range(0, 4).forEach(i -> es.submit(new Worker(countDownLatch)));
		countDownLatch.await(); // wait to finish all { - }
		System.out.println("Latch is released");

		es.shutdown();

	}

	private static class Worker implements Runnable {

		private CountDownLatch countDownLatch;

		public Worker(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			System.out.println("doing some work...");
			System.out.println("Counted down -1");
			countDownLatch.countDown(); // -- the count

		}

	}

}
