package hack.google;

/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 */
public class LongestSubstringWithAtMostTwoDistinctChar {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] hash = new int[256];
        int counter = 0;
        int start = 0, end = 0;
        int maxLength = 0;

        while (end < s.length()) {
            if (hash[s.charAt(end++)]++ == 0) {
                counter++;
            }

            while (counter > 2) {
                if (hash[s.charAt(start++)]-- == 1) {
                    counter--;
                }
            }

            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctChar test = new LongestSubstringWithAtMostTwoDistinctChar();

        test.lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
