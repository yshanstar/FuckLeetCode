package hack.facebook;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Reference:
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
            return result;
        }

        // init the Pattern P hash
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        // two pointer, initialize count to p's length
        int left = 0;
        int right = 0;
        int counter = p.length();

        while (right < s.length()) {
            // move right pointer everytime, if the char exist in p, decrease the counter
            // if current hash value >= 1 means the char is in p
            if (hash[s.charAt(right++)]-- >= 1) {
                counter--;
            }

            // when the count == 0, record the index
            if (counter == 0) {
                result.add(left);
            }

            // if we find the windows size == p.size, then we need to move left to narrow the window to find the new match
            // ++ to the reset hash because we kicked out the left, only increase the counter if char is in p
            // when count >=0. indicate it was original in the has
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                counter++;
            }
        }

        return result;
    }
}
