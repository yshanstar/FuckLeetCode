package hack.facebook;

import java.util.Arrays;

/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

Reference:
https://leetcode.com/problems/next-closest-time/discuss/107773/Java-AC-5ms-simple-solution-with-detailed-explaination
 */
public class NextCloestTime {
    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[]{result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);

        // find next digit for HH:M_
        result[4] = findNext(result[4], (char) ('9' + 1), digits);  // no upperLimit for this digit, i.e. 0-9
        if (result[4] > time.charAt(4)) {
            return String.valueOf(result);  // e.g. 23:43 -> 23:44
        }

        // find next digit for HH:_M
        result[3] = findNext(result[3], '5', digits);
        if (result[3] > time.charAt(3)) {
            return String.valueOf(result);  // e.g. 14:29 -> 14:41
        }

        // find next digit for H_:MM
        result[1] = result[0] == '2'
                ? findNext(result[1], '3', digits)
                : findNext(result[1], (char) ('9' + 1), digits);

        if (result[1] > time.charAt(1)) {
            return String.valueOf(result);  //  e.g. 02:37 -> 03:00
        }

        // find next digit for _H:MM
        result[0] = findNext(result[0], '2', digits);

        return String.valueOf(result);  // e.g. 19:59 -> 11:11
    }

    // find the next bigger digit which is no more than upperLimit.
    // If no such digit exists in digits[], return the minimum one i.e. digits[0]
    private char findNext(char current, char upperLimit, char[] digits) {
        if (current == upperLimit) {
            return digits[0];
        }

        int pos = Arrays.binarySearch(digits, current) + 1;
        while (pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) {
            pos++;
        }
        return pos == 4 ? digits[0] : digits[pos];
    }
}
