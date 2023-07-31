package general_all_concepts.multiThreading._5_synchronizerClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PhaserDemo {

	private static final int NUMBER_OF_THREADS = 2;
	private static Phaser phaser = new Phaser();

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * similar to cyclic barrier phaser here implement also barrier but with
		 * flexible approach with this type you can synchronise threads that represents
		 * separate phase, step of the whole execution goal of the common action
		 * 
		 * <T> so the number of threads can participate in this type it not be fixed it
		 * can be dynamically.
		 * 
		 * 
		 * <T> same as cyclicBarier they should implement synchronise method where
		 * multiple threads should meet each other
		 * 
		 * 
		 * The Phaser class is an extension of the functionality offered by
		 * CyclicBarrier and CountDownLatch classes and is more flexible in use.
		 * 
		 * @Param() One stark difference is that the Phaser class allows the number of
		 * registered parties that synchronise on a phaser to vary over time. The Phaser
		 * can be repeatedly awaited similar to a CyclicBarrier.
		 * 
		 * 
		 * <p>
		 * https://www.educative.io/courses/java-multithreading-for-senior-engineering-
		 * interviews/myznjjJ838O
		 */
		var es = Executors.newFixedThreadPool(4);

	//	System.out.println("Phase before tasks execution: " + phaser.getPhase());
		
		IntStream.range(0, 4).forEach(i -> es.submit(new Task(phaser)));
		es.shutdown();

		es.awaitTermination(1, TimeUnit.SECONDS);
		
		System.out.println("Parties after all threads are de-registered: " + phaser.getRegisteredParties());

		// second method
//		method2Phase()

	}

	private static class Task implements Runnable {
		private Phaser phaser;

		public Task(Phaser phaser) {
			this.phaser = phaser;
			this.phaser.register();
		}

		@Override
		public void run() {
			System.out.println("paheser"+ phaser.arriveAndAwaitAdvance());
			
			try {
				
				TimeUnit.MILLISECONDS.sleep(100);
				
				System.out.println("getPhase(): " + phaser.getPhase());
				
				System.out.println("Arrived in thread: " + Thread.currentThread().getName());
				
				System.out.println("Arrival phase number: " + phaser.arriveAndAwaitAdvance());
				
				TimeUnit.MILLISECONDS.sleep(100);
				
				// It just an impct or reprsentaion of number of phases
//				System.out.println("getPhase(): " + phaser.getPhase()); 
			
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			phaser.arriveAndDeregister();
		}
	}

	private static void method2Phase() throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// create an instance of Phaser class and register only a single that will
		// arrive
		// at the barrier
		Phaser phaser = new Phaser(1);

		try {
			
			// a thread registers with the Phaser post construction of the instance
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					phaser.register();
				}
			});

			// main thread bulk-registers two more parties
			phaser.bulkRegister(2);

			// main thread registering one more party.
			phaser.register();

			// we now have 5 parties registered with the Phaser instance
			// we instantiate four threads and have them arrive at the barrier
			for (int i = 0; i < 4; i++) {
				executorService.submit(new Runnable() {
					@Override
					public void run() {
						phaser.arriveAndAwaitAdvance();
						System.out.println(Thread.currentThread().getName() + " moving past barrier.");
					}
				});
			}

			// sleep for a while so that previous threads can arrive at the barrier
			Thread.sleep(2000);

			// before arriving at the barrier, print the counts of parties
			System.out.println(Thread.currentThread().getName() + " just before arrived. \n Arrived parties: "
					+ phaser.getArrivedParties() + "\n Registered parties: " + phaser.getRegisteredParties()
					+ "\n Unarrived parties: " + phaser.getUnarrivedParties());
			phaser.arriveAndAwaitAdvance();

		} finally {
			// remember to shutdown the executor in a finally block
			executorService.shutdown();
			executorService.awaitTermination(1, TimeUnit.HOURS);
		}

		// main thread prints party counts for the barrier
		System.out.println(Thread.currentThread().getName() + " exiting. \n Arrived parties: "
				+ phaser.getArrivedParties() + "\n Registered parties: " + phaser.getRegisteredParties()
				+ "\n Unarrived parties: " + phaser.getUnarrivedParties());
	}

}
