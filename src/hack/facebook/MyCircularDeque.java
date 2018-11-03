package hack.facebook;

/*
Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not.
isFull(): Checks whether Deque is full or not.


Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  			    // return 2
circularDeque.isFull();				    // return true
circularDeque.deleteLast();			    // return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();			    // return 4


Note:

All values will be in the range of [0, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in Deque library.


Reference:
https://leetcode.com/problems/design-circular-deque/discuss/155209/c%2B%2B-99-ring-buffer-no-edge-cases.-fb-interviewer-really-loves-it.-easy-to-impl-in-4mins.-cheers!

 */
public class MyCircularDeque {
    final int[] nums;
    private int length;
    private int front;
    private int rare;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        nums = new int[k];
        front = nums.length - 1;
        rare = 0;
        length = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        nums[front] = value;
        front = (front - 1 + nums.length) % nums.length;
        length++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        nums[rare] = value;
        rare = (rare + 1) % nums.length;
        length++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % nums.length;
        length--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        rare = (rare - 1 + nums.length) % nums.length;
        length--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : nums[(front + 1) % nums.length];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : nums[(rare - 1 + nums.length) % nums.length];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return length == nums.length;
    }

    public static void main(String[] args) {
        MyCircularDeque queue = new MyCircularDeque(3);
        queue.insertFront(9);
        queue.getRear();
        queue.insertFront(9);
        queue.getRear();
        queue.insertLast(5);
        queue.getFront();
        queue.getRear();
        queue.getFront();
        queue.insertLast(8);
        queue.deleteLast();
        queue.getFront();
    }
}
