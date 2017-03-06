package hack.facebook;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int res = 0;
        while (tmp != 0) {
            tmp = tmp & (tmp - 1);
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        hammingDistance(1, 4);
    }
}
