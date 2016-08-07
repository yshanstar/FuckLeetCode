package hack.google;

import hack.util.ListNode;

/*
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
 */
public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
		if (helper(head) == 0) {
			return head;
		} else {
			ListNode newHead = new ListNode(1);
			newHead.next = head;
			return newHead;
		}
	}

	private int helper(ListNode n) {
		if (n == null) {
			return 1;
		}

		int carry = helper(n.next);
		if (carry == 0) {
			return 0;
		}

		int val = n.val + 1;
		n.val = val % 10;
		return val / 10;
	}
}
