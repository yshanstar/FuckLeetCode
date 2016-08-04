package hack.google;

import java.util.ArrayList;
import java.util.List;

/*
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.
 */
public class Codec {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		if (strs == null || strs.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str.length()).append("/").append(str);
		}

		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.isEmpty()) {
			return res;
		}

		int i = 0;
		while (i < s.length()) {
			int slash = s.indexOf('/', i);
			int size = Integer.valueOf(s.substring(i, slash));
			res.add(s.substring(slash + 1, slash + size + 1));
			i = slash + size + 1;
		}

		return res;
	}
}
