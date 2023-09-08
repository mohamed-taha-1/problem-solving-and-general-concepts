package medium._211_DesignAddandSearchWordsDataStructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isEndOfWord = true;
	}

	public boolean search(String word) {
		return searchHelper(word, 0, root);
	}

	private boolean searchHelper(String word, int index, TrieNode node) {
		if (index == word.length()) {
			return node.isEndOfWord;
		}

		char c = word.charAt(index);
		if (c == '.') {
			for (TrieNode child : node.children) {
				if (child != null && searchHelper(word, index + 1, child)) {
					return true;
				}
			}
			return false;
		} else {
			TrieNode nextNode = node.children[c - 'a'];
			return nextNode != null && searchHelper(word, index + 1, nextNode);
		}
	}

	private class TrieNode {
		TrieNode[] children;
		boolean isEndOfWord;

		public TrieNode() {
			children = new TrieNode[26];
			isEndOfWord = false;
		}
	}

	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		String word = "bad";
		obj.addWord(word);
		boolean param_2 = obj.search(word);
		System.out.println(param_2);

	}

}
