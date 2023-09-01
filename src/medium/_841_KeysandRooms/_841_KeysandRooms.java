package medium._841_KeysandRooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _841_KeysandRooms {

	// Given an array rooms where rooms[i] is the set of keys that you can obtain if
	// you visited room i, return true if you can visit all the rooms, or false
	// otherwise.

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

		int n = rooms.size();
		boolean[] visited = new boolean[n];
		dfs(rooms, 0, visited);

		for (boolean isVisited : visited) {
			if (!isVisited)
				return false;
		}

		return true;
	}

	private static void dfs(List<List<Integer>> rooms, int roomIndex, boolean[] visited) {
		visited[roomIndex] = true;
		for (int room : rooms.get(roomIndex)) {
			if (!visited[room]) {
				dfs(rooms, room, visited);
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(Arrays.asList(1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(3));
		rooms.add(Arrays.asList());
		rooms.add(Arrays.asList(4, 6));

		System.out.println(canVisitAllRooms(rooms));

	}

}
