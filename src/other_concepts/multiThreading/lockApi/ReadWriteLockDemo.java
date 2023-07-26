package multiThreading.lockApi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

	static Map<String, String> synchHashMap = new HashMap<>();
	private static ReadWriteLock readWrite = new ReentrantReadWriteLock();

	private static Lock write = readWrite.writeLock();
	private static Lock read = readWrite.readLock();

	public static void put(String key, String val) {

		try {
			write.lock();
			synchHashMap.put(key, val);
		} finally {
			write.unlock();
		}
	}

	public static String remove(String key) {
		try {
			write.lock();
			return synchHashMap.remove(key);
		} finally {
			write.unlock();
		}
	}

	public static String get(String key) {
		try {

			read.lock();
			return synchHashMap.get(key);

		} finally {
			read.unlock();
		}
	}

	public static boolean containsKey(String key) {
		try {

			read.lock();
			return synchHashMap.containsKey(key);

		} finally {
			read.unlock();
		}
	}

	public static void main(String[] args) {
		/*
		 * <P> This interface has 2 methods {Read , Write}
		 * 
		 * @Param() ->this way are so dump; because the return type just the same of
		 * type LOCK With has implementation ReenterantLock
		 * 
		 * @Param() so funny it has it is own ReentrantReadWriteLock.
		 * 
		 */

		put("first", "mohaemd");
		put("second", "ahmed");
		put("third", "esmail");
		put("four", "asneem");
		put("five", "sara");
		put("sex", "marwa");
		System.out.println(remove("four"));

	}

}
