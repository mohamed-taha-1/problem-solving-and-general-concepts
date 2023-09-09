package hard._126_WordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution3 {
	public static  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		    List<List<String>> result = new ArrayList<>();
		    Set<String> wordSet = new HashSet<>(wordList);

		    if (!wordSet.contains(endWord)) {
		        return result; // The endWord is not in the word list, so there's no ladder.
		    }

		    Set<String> startSet = new HashSet<>();
		    Set<String> endSet = new HashSet<>();
		    Map<String, List<String>> graph = new HashMap<>();

		    startSet.add(beginWord);
		    endSet.add(endWord);

		    boolean found = false;
		    boolean reverse = false;
		    while(!startSet.isEmpty()) {
		    	Set<String> tempSet=new HashSet<>();
		    	for(String word: startSet) {
		    		wordSet.remove(word);
		    	}
		    	
		    	  for (String word : endSet) {
			            wordSet.remove(word);
			        }
		    	  
		    	if(startSet.size() > endSet.size()) {
		    		
		    		Set<String> swap=startSet;
		    		startSet=endSet;
		    		endSet=swap;
		    		reverse=!reverse;
		    		
		    	}
		    	
		    	

		        for (String currentWord : startSet) {
		            char[] chars = currentWord.toCharArray();
		            for (int i = 0; i < chars.length; i++) {
		                char originalChar = chars[i];
		                for (char c = 'a'; c <= 'z'; c++) {
		                    if (c == originalChar) {
		                        continue;
		                    }
		                    chars[i] = c;
		                    String newWord = new String(chars);

		                    String key = reverse ? newWord : currentWord;
		                    String nextWord = reverse ? currentWord : newWord;

		                    if (endSet.contains(newWord)) {
		                        found = true;
		                        graph.computeIfAbsent(key, k -> new ArrayList<>()).add(nextWord);
		                    } else if (!found && wordSet.contains(newWord)) {
		                        tempSet.add(newWord);
		                        graph.computeIfAbsent(key, k -> new ArrayList<>()).add(nextWord);
		                    }
		                }
		                chars[i] = originalChar;
		            }
		        }

		        if (found) {
		            break;
		        }

		        startSet = tempSet;
		    }

		    
    	  List<String> path = new ArrayList<>();
		    path.add(beginWord);

		    backTrack(beginWord, endWord, path , result,graph);
		    
		    
		    
		    return result;
		}
	
	private static void backTrack(String currentWord, String endWord,  List<String> path, List<List<String>> result, Map<String , List<String>> graph ) {
		
		// base case
		if(currentWord.equals(endWord)) {
			result.add(new ArrayList<>(path ));
			return;
		}
		
		if(!graph.containsKey(currentWord)) return;
		
		for(String tempWord: graph.get(currentWord)) {
			path.add(tempWord);
			backTrack(tempWord, endWord, path, result, graph);
			path.remove(path.size()-1);
		}
		
		
	}

	public static void main(String[] args) {

		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

		System.out.println(findLadders(beginWord, endWord, wordList));

	}

}
