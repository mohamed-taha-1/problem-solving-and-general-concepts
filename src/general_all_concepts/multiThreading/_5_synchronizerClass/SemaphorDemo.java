package general_all_concepts.multiThreading._5_synchronizerClass;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphorDemo {

	static String item = null;
	static Semaphore full = new Semaphore(0);
	static Semaphore empty = new Semaphore(1);

	static class Consumer implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					full.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Consumer: consumed item: " + item);
				item = null;
				empty.release();
			}
		}
	}

	static class Producer implements Runnable {
		@Override
		public void run() {
			int i = 0;
			while (true) {
				try {
					empty.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				item = "Item " + i++;
				System.out.println("Producer: produced item: " + item);
				full.release();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		/*
		 *  Actually it is a variable or abstract data type.
		 * 
		 * @Param() Semaphores are a synchronisation tool that can be used to restrict
		 * the number of users to a particular resource or a group of resources.
		 * 
		 * 
		 * @Param() Unlike locks, which allow only one user per resource, semaphores can
		 * restrict any given number of users to a resource.
		 * 
		 * 
		 * <br> Every time a thread calls the acquire method, it takes a permit if it’s
		 * available and moves to the next instruction. A thread can actually acquire
		 * more than one permit at a time by passing the number of permits into the
		 * acquire method. The release method can also take an argument and release more
		 * than one permit. <br>
		 * 
		 * 
		 * @Param() semaphore is bad choice ,but Semaphores are a great choice for other
		 * scenarios, such as the producer-consumer scenario
		 * 
		 * 
		 * @UseCase(): We can create a semaphore called “full” initialised with 0 and
		 * another semaphore called “empty” initialized with 1. We also create a shared
		 * variable called “item” which will be null initially. The consumer thread
		 * first tries to acquire the “full” semaphore, which results in blocking and
		 * waiting for the producer to produce an item. The producer first acquires the
		 * “empty” semaphore and produces an item, then releases the “full” semaphore,
		 * waking up the consumer thread and allowing it to consume the item. If the
		 * producer produces items faster than the consumer, the producer will get
		 * blocked and wait until the consumer is done consuming. This process can go on
		 * forever safely and reliably
		 * 
		 * @theGivenUseCaseExample_improvements(): This implementation works only with a
		 * single producer and a single consumer, but it can be generalized to allow
		 * many producers and many consumers with a few modifications such as using a
		 * queue and initializing the empty semaphore with a given capacity. You will
		 * also need to add a lock on the queue object to prevent multiple threads from
		 * accessing it at the same time.
		 * 
		 */

		/*
		 * Thread consumer = new Thread(new Consumer()); Thread producer = new  Thread(new Producer());
		 * 
		 *  consumer.start(); 
		 *  producer.start();
		 */

		/* Second example , to permit users to login */

		int loginPermits = 10;
		var es = Executors.newFixedThreadPool(4);
		var demo = new SemaphorDemo(loginPermits);

		IntStream.range(1, loginPermits).forEach(s -> es.submit(demo::tryLogin));

		es.shutdown();
		es.awaitTermination(2, TimeUnit.SECONDS);

		System.out.println("the avaliable permits for login:\t" + demo.availablePermitsForLogin());
		demo.tryLogin();

		demo.logout();
		System.out.println("the avaliable permits for login:\t" + demo.availablePermitsForLogin());

	}

	private Semaphore semaphore;

	public SemaphorDemo(int slotLimit) {
		semaphore = new Semaphore(slotLimit);
	}

	private void tryLogin() {
		if (semaphore.tryAcquire()) {
			System.out.println("Congrats! You are logged in!");
		} else {
			System.out.println("No permits for login available. Try later.");
		}
	}

	private void logout() {
		semaphore.release();
	}

	private int availablePermitsForLogin() {
		return semaphore.availablePermits();
	}

}
