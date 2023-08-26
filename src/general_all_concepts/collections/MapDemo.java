package general_all_concepts.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {

	static class CacheExample extends LinkedHashMap<String, Integer> {
		private final int MAX_ENTRIES;

		CacheExample(int maxEntries) {
			super(maxEntries, 0.75f, true);
			this.MAX_ENTRIES = maxEntries;

		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
			return size() > MAX_ENTRIES;
		}

	}

	public static void main(String[] args) {
		/*
		 * Map<Integer, String> map=new LinkedHashMap<>();
		 * 
		 * map.put(1, "taha");
		 */

		// We override the removeEldestEntry method to control the removal of the eldest
		// entry when new entries are inserted.

		CacheExample cach = new CacheExample(4);

		cach.put("1", 1);
		cach.put("2", 2);
		cach.put("3", 3);
		cach.put("4", 4);

		System.out.println(cach);
		cach.put("5", 5);
		System.out.println(cach);

	}

}
