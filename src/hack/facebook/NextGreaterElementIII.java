package hack.facebook;

import java.util.Arrays;

/*
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n.
If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21


Example 2:

Input: 21
Output: -1
 */
public class NextGreaterElementIII {
    /*
     * Reference:
     * https://leetcode.com/problems/next-greater-element-iii/discuss/101824/Simple-Java-solution-(4ms)-with-explanation.
     */
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();

        // I) Start from the right most digit and
        // find the first digit that is
        // smaller than the digit next to it.
        int i;
        for (i = number.length - 1; i > 0; i--) {
            if (number[i - 1] < number[i]) {
                break;
            }
        }

        // If the number from right to left is always ascending.
        if (i == 0) {
            return -1;
        }

        // From i find the smallest number from right larger than number[i]
        int x = number[i - 1];
        int smallest = i;
        for (int j = i; j < number.length; j++) {
            if (number[j] > x && number[j] <= number[smallest]) {
                smallest = j;
            }
        }

        // swap with number[i-1]
        char temp = number[i - 1];
        number[i - 1] = number[smallest];
        number[smallest] = temp;

        // sort the right part.
        Arrays.sort(number, i, number.length);

        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}
