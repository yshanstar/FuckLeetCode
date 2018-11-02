package hack.facebook;

/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

Reference:
https://leetcode.com/problems/permutation-in-string/discuss/102590/8-lines-slide-window-solution-in-Java

 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[256];
        for (char c : s1.toCharArray()) {
            count[c]--;
        }

        for (int left = 0, right = 0; right < s2.length(); right++) {
            count[s2.charAt(right)]++;
            if (count[s2.charAt(right)] > 0) {
                while (--count[s2.charAt(left++)] != 0) {
                }
            } else if ((right - left + 1) == s1.length()) {
                return true;
            }
        }

        return s1.length() == 0;
    }

    public static void main(String[] args){
        PermutationInString test = new PermutationInString();
        test.checkInclusion("ab", "eidbaooo");
    }
}
