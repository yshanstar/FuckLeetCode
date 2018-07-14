package hack.facebook;

import java.util.ArrayList;
import java.util.List;

/*

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.


Reference: https://leetcode.com/problems/palindromic-substrings/solution/

 */
public class PalindromicSubstrings {
    // solution -- Expand Around Center
    public int countSubstrings2(String s) {
        int total = s.length();
        int result = 0;

        for (int center = 0; center <= 2 * total - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < total && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }

        return result;
    }

    // solution -- brust force.
    public int countSubstrings(String s) {
        int count = 0;
        List<String> allSubString = allSubString(s);
        count = (int) allSubString.stream().filter(this::isPalindrom).count();
        return count;
    }

    private boolean isPalindrom(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private List<String> allSubString(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }

        for (int i = 0; i <= str.length() - 1; i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                res.add(str.substring(i, j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubstrings test = new PalindromicSubstrings();
        test.countSubstrings(s);
    }
}
