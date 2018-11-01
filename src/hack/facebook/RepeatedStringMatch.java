package hack.facebook;

/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

Reference:
https://leetcode.com/problems/repeated-string-match/discuss/108086/Java-Solution-Just-keep-building-(OJ-Missing-Test-Cases)
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }

        if (sb.toString().contains(B)) {
            return count;
        }

        if (sb.append(A).toString().contains(B)) {
            return ++count;
        }

        return -1;
    }
}
