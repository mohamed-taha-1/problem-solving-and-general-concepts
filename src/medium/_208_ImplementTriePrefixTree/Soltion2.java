package medium._208_ImplementTriePrefixTree;

import java.util.ArrayList;
import java.util.List;

public class Soltion2 {

	List<String> list;

	public Soltion2() {
		list = new ArrayList<>();
	}

	public void insert(String word) {
		list.add(word);

	}

	public boolean search(String word) {
		if(list.contains(word)) return true;
		
		return false;

	}

	public boolean startsWith(String prefix) {

		for(String str: list) {
			if(str.startsWith(prefix)) return true;
		}
		
		return false;
	}
}

/*
 * rrayList<String> dic; public Trie() { dic = new ArrayList<>(); }
 * 
 * public void insert(String word) { dic.add(word); }
 * 
 * public boolean search(String word) { return dic.contains(word); }
 * 
 * public boolean startsWith(String prefix) { for (String s : dic) { if
 * (s.startsWith(prefix)) return true; } return false; }
 */