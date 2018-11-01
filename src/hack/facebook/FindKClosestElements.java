package hack.facebook;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

Reference:
https://leetcode.com/problems/find-k-closest-elements/discuss/106430/Updated-Java-Solution
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - k;
        while (start < end) {
            int mid = (end + start) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = start; i < start + k; i++) {
            results.add(arr[i]);
        }
        return results;
    }

    public static void main(String[] args) {
        FindKClosestElements test = new FindKClosestElements();
        int[] arr = {1, 2, 3, 4, 5};
        test.findClosestElements(arr, 4, -1);
    }
}
