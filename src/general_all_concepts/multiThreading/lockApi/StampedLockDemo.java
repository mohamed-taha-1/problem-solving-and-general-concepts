package general_all_concepts.multiThreading.lockApi;

public class StampedLockDemo {

	public static void main(String[] args) {
		/*
		 * Reentrant RW locks can lead to thread starvation for the write lock under
		 * loaded conditions – which can lead to severe performance issues.
		 * 
		 * @Param() Why are they called “Stamped” ?
		 * 
		 * @Param() There are two elements of a stamped lock, namely – the lock version
		 * and locking mode.
		 * 
		 * @Param() The lock version is also known as a stamp, and is essentially a
		 * value of type “long” returned every time a lock is acquired.
		 * 
		 * 
		 * @Param() There are three locking modes available for synchronisation
		 * granularity – READ, WRITE and OPTIMISTIC READ locks.
		 * 
		 * 
		 * @Param() Conditional Locking & Conversion
		 * 
		 * Stamped Lock APIs also allow for conditional locking by using the “try”
		 * methods.
		 * 
		 * In this process, it is possible to interchange read lock stamps to writes and
		 * vice versa
		 * 
		 * 
		 * 
		 * public long tryConvertToWriteLock(long stamp)
		 * 
		 * 
		 * public long tryConvertToReadLock(long stamp)
		 * 
		 * 
		 * public long tryConvertToOptimisticRead(long stamp)
		 * 
		 * 
		 * <header>
		 * https://medium.com/@aayushbhatnagar_10462/java-concurrency-through-stamped-
		 * locks-eb65e9a675c1 </header>
		 * 
		 * 
		 */
	}

}
