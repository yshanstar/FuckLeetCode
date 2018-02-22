package hack.facebook;

/*
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]

Reference: https://leetcode.com/problems/maximum-swap/discuss/107102/Simple-AC-O(n)-java-solution-with-ex
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        int firstGreaterPos = 0;
        while (firstGreaterPos < digits.length - 1 && digits[firstGreaterPos] >= digits[firstGreaterPos + 1]) {
            firstGreaterPos++;
        }

        if (firstGreaterPos == digits.length - 1) {
            // Nothing needs to swap
            return num;
        }


        int maxPos = firstGreaterPos;
        int max = digits[maxPos] - '0';
        for (int i = firstGreaterPos; i < digits.length; i++) {
            // Find the max digit position
            if (max <= digits[i] - '0') {
                maxPos = i;
                max = digits[i] - '0';
            }
        }

        //find first digit that smaller than max digit in the second part
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] - '0' < max) {
                char tmp = digits[i];
                digits[i] = digits[maxPos];
                digits[maxPos] = tmp;
                return Integer.valueOf(String.valueOf(digits));
            }
        }

        return num;
    }
}
