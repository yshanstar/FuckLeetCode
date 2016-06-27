package hack.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> res = new ArrayList<List<String>>();

		if (strs == null || strs.length == 0) {
			return res;
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			String key = getKey(s);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}

			List<String> tmp = map.get(key);
			tmp.add(s);
		}

		for (List<String> value : map.values()) {
			res.add(value);
		}

		return res;
	}

	private String getKey(String s) {
		char[] sChars = s.toCharArray();
		Arrays.sort(sChars);

		return new String(sChars);
	}
}
