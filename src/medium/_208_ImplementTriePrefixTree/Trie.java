package medium._208_ImplementTriePrefixTree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEndOfWord;

		public TrieNode() {
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}

	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			node.children.putIfAbsent(ch, new TrieNode());
			node = node.children.get(ch);
		}
		node.isEndOfWord = true;
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			if (!node.children.containsKey(ch)) {
				return false;
			}
			node = node.children.get(ch);
		}
		return node.isEndOfWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			if (!node.children.containsKey(ch)) {
				return false;
			}
			node = node.children.get(ch);
		}
		return true;
	}

	public static void main(String[] args) {
		Trie obj = new Trie();
		String word = "apple";
		String prefix = "app";

		obj.insert(word);
		boolean param_2 = obj.search(word);
		System.out.println(" Search:\t" + param_2);
		boolean param_3 = obj.startsWith(prefix);
		System.out.println(" Sart with:\t" + param_3);

	}

}
