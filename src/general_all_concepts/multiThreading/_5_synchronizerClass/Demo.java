package general_all_concepts.multiThreading._5_synchronizerClass;

import java.util.concurrent.Phaser;

public class Demo {

	public static void main(String[] args) {
		  int initialParties = 3;
	        Phaser phaser = new Phaser(initialParties);

	        Runnable task = () -> {
	            System.out.println("Thread started");
	            phaser.arriveAndAwaitAdvance(); // Synchronize at this point
	            System.out.println("Thread completed its work");
	        };

	        for (int i = 0; i < initialParties; i++) {
	            new Thread(task).start();
	        }

	        int additionalParties = 1;
	        phaser.bulkRegister(additionalParties); // Add more parties dynamically
	        phaser.register();

	        for (int i = 0; i < additionalParties; i++) {
	            new Thread(task).start();
	        }

	}

}
