package hard._126_WordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;

public class Solution {

	// return all the shortest transformation sequences from beginWord to endWord,
	// or an empty list if no such sequence exists.

	/*
	 * Input: beginWord = "hit", endWord = "cog", wordList =
	 * ["hot","dot","dog","lot","log","cog"]
	 */
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// Helper function to check if two words can connect
		// Returns true if they differ in exactly one character

		// Use a HashSet for faster word lookup and tracking used words
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord)) {
			return new ArrayList<>(); // End word is not in the word list, no ladder exists.
		}

		dict.remove(beginWord);
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		List<List<String>> nodes = new ArrayList<>();

		// Find all paths from beginning level by level until reaching the end at a
		// level
		boolean reached = false;

		while (!queue.isEmpty() && !reached) {
			// Update nodes of paths for this level
			nodes.add(new ArrayList<>(queue));

			int size = queue.size();
			for (int i = 0; i < size && !reached; i++) {
				String orignalWord = queue.poll();

				// Find all nodes that connect to the nodes of this level
				for (String currentWord : new HashSet<>(dict)) {
					if (!connected(orignalWord, currentWord)) {
						continue;
					}

					// If connected to endWord, stop moving forward
					if (currentWord.equals(endWord)) {
						reached = true;
						break;
					}

					// Otherwise, add all connected nodes to the queue for the next level
					// and remove them from dict to prevent revisiting and forming cycles
					queue.offer(currentWord);
					dict.remove(currentWord);
				}
			}
		}

		// If endWord was not reached, return an empty list
		if (!reached) {
			return new ArrayList<>();
		}

		// Move backward to construct paths
		List<List<String>> ans = new ArrayList<>();
		ans.add(Collections.singletonList(endWord));

		for (int level = nodes.size() - 1; level >= 0; level--) {
			int size = ans.size();
			for (int a = 0; a < size; a++) {

				List<String> p = ans.remove(0);

				String last = p.get(0);

				for (String word : nodes.get(level)) {
					if (!connected(last, word)) {
						continue;
					}

					List<String> newPath = new ArrayList<>(p);
					newPath.add(0, word);
					ans.add(newPath);
				}
			}
		}

		return ans;
	}

	private static boolean connected(String a, String b) {
		int diffCount = 0;
		for (int i = 0; i < a.length() && diffCount < 2; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diffCount++;
			}
		}
		return diffCount == 1;
	}
	
	public static void main(String[] args) {
		Solution wordLadder = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> ladders = wordLadder.findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);

	}

}
