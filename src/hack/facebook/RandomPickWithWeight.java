package hack.facebook;

import java.util.Random;

/*
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input:
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input:
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.


 */
public class RandomPickWithWeight {
    final int[] totalSumWeight;
    Random random;

    public RandomPickWithWeight(int[] w) {
        this.totalSumWeight = new int[w.length];
        this.random = new Random();

        for (int i = 0, totalWeight = 0; i < w.length; i++) {
            totalWeight += w[i];
            totalSumWeight[i] = totalWeight;
        }
    }

    public int pickIndex() {
        int len = totalSumWeight.length;
        int weight = random.nextInt(totalSumWeight[len - 1]) + 1;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (totalSumWeight[mid] == weight) {
                return mid;
            } else if (totalSumWeight[mid] < weight) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
