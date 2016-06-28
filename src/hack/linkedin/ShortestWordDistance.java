package hack.linkedin;

/*
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0) {
			return 0;
		}

		int diff = Integer.MAX_VALUE;
		int idx = -1;

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (word.equals(word1) || word.equals(word2)) {
				if (idx != -1 && !words[idx].equals(word)) {
					diff = Math.min(diff, i - idx);
				}
				idx = i;
			}
		}

		return diff;
	}
}
