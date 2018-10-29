package hack.facebook;

/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].

Reference:
https://leetcode.com/problems/reorganize-string/discuss/113451/7-ms-Java-O(n)-Solution.-no-Sorting
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] cnt = new int[26];
        int maxFreq = 0;
        char maxChar = 'a';

        for (char c : S.toCharArray()) {
            cnt[c - 'a']++;
            if (cnt[c - 'a'] > maxFreq) {
                maxFreq = cnt[c - 'a'];
                maxChar = c;
            }
        }


        // if the number of majority character is larger than half size of S. impossible.
        if (maxFreq > (S.length() + 1) / 2) {
            return "";
        }

        // put the maxChar into even pos
        char[] ans = new char[S.length()];
        int i = 0;
        while (cnt[maxChar - 'a']-- > 0) {
            ans[i] = maxChar;
            i += 2;
        }

        // set the rest of chars
        for (char c = 'a'; c <= 'z'; c++) {
            while (cnt[c - 'a']-- > 0) {
                if (i >= ans.length) {
                    i = 1;
                }
                ans[i] = c;
                i += 2;
            }
        }

        return new String(ans);
    }
}
