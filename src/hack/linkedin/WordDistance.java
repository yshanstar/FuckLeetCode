package hack.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

 Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.
 */
public class WordDistance {
	Map<String, List<Integer>> map;

	public WordDistance(String[] words) {
		this.map = new HashMap<String, List<Integer>>();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (!map.containsKey(word)) {
				map.put(word, new ArrayList<Integer>());
			}

			List<Integer> idx = map.get(word);
			idx.add(i);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> idx1 = map.get(word1);
		List<Integer> idx2 = map.get(word2);

		int diff = Integer.MAX_VALUE;

		for (int i = 0, j = 0; i < idx1.size() && j < idx2.size();) {
			int pos1 = idx1.get(i);
			int pos2 = idx2.get(j);

			diff = Math.min(diff, Math.abs(pos1 - pos2));

			if (pos1 < pos2) {
				i++;
			} else {
				j++;
			}
		}

		return diff;
	}
}
