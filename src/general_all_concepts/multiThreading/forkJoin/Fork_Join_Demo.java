package multiThreading.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Fork_Join_Demo {

	public static void main(String[] args) {
		// the framework helps to speed up the parallel processing by using all
		// available cores

		ForkJoinPool pool1 = new ForkJoinPool(4);
		ForkJoinPool pool2 = new ForkJoinPool();
		ForkJoinPool CommonPool2 = ForkJoinPool.commonPool();

		System.out.println("the first patch of fork join mechnaisms ");

		/*
		 * with Call able and future able here we can use 2 types {tasks , actions } //
		 * 1. actions: does not return anything // 2. tasks: return the result
		 */

		
		
		// -- it is bad and complex t use it 
		
		
	}
}
