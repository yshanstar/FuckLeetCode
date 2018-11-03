package hack.util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}

	public ListNode(int x, ListNode next) {
		val = x;
		next = next;
	}
}
