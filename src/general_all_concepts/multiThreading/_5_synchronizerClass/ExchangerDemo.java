package general_all_concepts.multiThreading._5_synchronizerClass;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;

public class ExchangerDemo {

	public static void main(String[] args) {
		/*
		 * exchanger exchange the data between threads at some points a thread should
		 * wait to other thread arrived at exchange point
		 * 
		 * 
		 * -- the Long timeUnit is define actually the wait that the thread should
		 * waited for other threads
		 */

		Exchanger<String> exchanger = new Exchanger<>();

		Runnable ts1 = () -> {

			String msg;
			try {
				msg = exchanger.exchange("mesage form task #1");
				System.out.println(msg);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		};

		Runnable ts2 = () -> {

			String msg;
			try {
				msg = exchanger.exchange("mesage form task #2");
				System.out.println(msg);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		};

		var es = Executors.newCachedThreadPool();
		es.submit(ts1);
		es.submit(ts2);
		es.shutdown();

	}

}
