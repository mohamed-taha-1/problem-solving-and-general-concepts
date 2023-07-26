package multiThreading;

public class MultiThreading_ extends Thread {

	/*
	 * ############## Become an expert in Multithreading, Concurrency & Parallel
	 * programming in Java, with strong emphasis on high performance
	 */
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> System.out.println("Welcome ya taha " + Thread.currentThread().getName()
				+ " , and it is prioirity is :" + Thread.currentThread().getPriority()));
		
		t1.start(); // catch the name of the global method like ` main ` now
		t1.run(); // it get the thread number is there are multiple threads

		System.out.println("::::::: Lambda::::::/n");
		threadLambdaTest();
		
		// we can create a partaial method and with my custom class ue method refrence to get it instead of lampda functions
		System.out.println(":::::::: Custome :::::/n");
		Thread customThread=new Thread( MultiThreading_::executTahMessage);
		customThread.start();
		

	}

	private static void threadLambdaTest() {
		Thread t1 = new Thread(() -> System.out.println("Welcome ya taha  From lambda " + Thread.currentThread().getName()
				+ " , and it is prioirity is :" + Thread.currentThread().getPriority()));
		t1.start(); // catch the name of the global method like ` main ` now

	}

	private static void executTahMessage() {
		System.out.println("Welcome ya taha From custom" + Thread.currentThread().getName() + " , and it is prioirity is :"
				+ Thread.currentThread().getPriority());
		
	}

}
