package hack.Microsoft;

/*
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Note:
The n will be in the range [1, 1000].
 */
public class TwoKeysKeyboard {
    // For A, it takes 0
    // For AA, it takes 2
    // For AAA, it takes 3
    // For AAAA, it takes 4
    // For 5A, it takes 5
    // For 6A, it takes 5 [step(3A) + (6/3) paste]
    // For 7A, it takes 7 [step(A) + (7/1) paste]
    // For 8A, it takes 5 [step(2A) + (8/2) paste]
    // For 9A, it takes 6 [step(3A) + (9/3) paste]
    public int minSteps(int n) {
        if (n == 1) return 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        return n;
    }
}
