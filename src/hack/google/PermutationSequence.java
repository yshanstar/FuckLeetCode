package hack.google;

import java.util.ArrayList;
import java.util.List;

/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */
public class PermutationSequence {
    /*
     * Reference: https://leetcode.com/problems/permutation-sequence/discuss/22665/Clean-Java-Solution
     */
    public String getPermutation(int n, int k) {
        List<Integer> notUsed = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            notUsed.add(i);
            fact *= (i == n ? 1 : i);
        }

        String res = "";
        k = k - 1;
        while (true) {
            res += notUsed.remove(k / fact);
            k %= fact;
            if (notUsed.isEmpty()) {
                break;
            }
            fact /= notUsed.size();
        }

        return res;
    }

    // generate all the permutation and return the index? Exceeded Time
    public String getPermutationBrustForce(int n, int k) {
        List<String> allPermutation = permute(n);
        return allPermutation.get(k - 1);
    }

    public List<String> permute(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", n);
        return ans;
    }

    private void backTrack(List<String> ans, String tmp, int n) {
        if (tmp.length() == n) {
            ans.add(tmp);
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (tmp.contains(String.valueOf(num))) {
                continue;
            }
            tmp += num;
            backTrack(ans, tmp, n);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        test.getPermutationBrustForce(9, 273815).equals(test.getPermutation(9, 273815));
    }
}
