package hack.facebook;

/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

Reference:
https://leetcode.com/problems/backspace-string-compare/discuss/135603/C++JavaPython-O(N)-time-and-O(1)-space

 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        /*
        However, we can do a back string compare (just like the title of problem).
        If we do it backward, we meet a char and we can be sure this char won't be deleted.
        If we meet a '#', it tell us we need to skip next lowercase char.
         */

        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipI = 0;
        int skipJ = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipI++;
                    i--;
                } else if (skipI > 0) {
                    i--;
                    skipI--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipJ++;
                    j--;
                } else if (skipJ > 0) {
                    j--;
                    skipJ--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

    public boolean backspaceCompareNavie(String S, String T) {
        if (S == null && T == null) {
            return true;
        }

        if (S == null || T == null) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (sb2.length() > 0)
                    sb2.deleteCharAt(sb2.length() - 1);
            } else {
                sb2.append(c);
            }
        }

        return sb.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        BackspaceStringCompare test = new BackspaceStringCompare();
        test.backspaceCompare("y#fo##f", "y#f#o##f");
    }
}
