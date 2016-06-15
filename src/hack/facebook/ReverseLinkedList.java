package hack.facebook;

import hack.util.ListNode;

/*
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode next = cur.next;
		cur.next = null;

		ListNode reverseRest = reverseList(next);

		next.next = cur;

		return reverseRest;
	}

	public ListNode reverseListInPlace(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode prev = null;

		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}

		return prev;
	}
}
