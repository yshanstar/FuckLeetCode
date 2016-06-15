package hack.facebook;

import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] canBreak = new boolean[s.length() + 1];
		canBreak[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (canBreak[j] && wordDict.contains(s.substring(j, i))) {
					canBreak[i] = true;
					break;
				}
			}
		}

		return canBreak[s.length()];
	}
}
