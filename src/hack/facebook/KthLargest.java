package hack.facebook;

import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.

Reference:
https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/149050/Java-Priority-Queue
https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/152588/Explanation-of-MinHeap-solution-(NO-CODE)

 */
public class KthLargest {
    final PriorityQueue<Integer> queue;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);

        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (this.queue.size() < k) {
            this.queue.offer(val);
        } else if (this.queue.peek() < val) {
            this.queue.poll();
            this.queue.offer(val);
        }
        return queue.peek();
    }
}
