package multiThreading.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPool {

	public static void main(String[] args) {
		System.out.println("Welcom in different thred pool ways\n");

		
		int threadNum=4;
		ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNum);

		IntStream.range(0, threadNum).forEach(i -> {
			pool.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(2);

				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			});

		});

		pool.shutdown();
		System.out.println("poll size   " + pool.getPoolSize());
		System.out.println("the quque size is:  " + pool.getQueue().size());
		
		// try to figerOut the number of processors
		int numOfCors=Runtime.getRuntime().availableProcessors();
		System.out.println("the number of cors for this device is:  "+ numOfCors);
		
		
		var es=Executors.newFixedThreadPool(numOfCors);
		
		

	}

}
