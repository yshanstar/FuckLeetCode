package hack.facebook;

/*
We have two integer sequences A and B of the same non-zero length.

We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.

At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)

Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.

Example:
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation:
Swap A[3] and B[3].  Then the sequences are:
A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
which are both strictly increasing.
Note:

A, B are arrays with the same length, and that length will be in the range [1, 1000].
A[i], B[i] are integer values in the range [0, 2000].

Reference:
https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119835/Java-O(n)-DP-Solution
https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/solution/
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int n1 = 0; // unswap
        int s1 = 1; // swap

        for (int i = 1; i < A.length; i++) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                n2 = Math.min(n1, n2);
                s2 = Math.min(s2, s1 + 1);
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }
}
