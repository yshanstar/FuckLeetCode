package hack.facebook;

import hack.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		if (lists.length == 1) {
			return lists[0];
		}

		ListNode newHead = null;
		ListNode prev = newHead;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		for (ListNode node : lists) {
			if (node != null) {
				queue.offer(node);
			}
		}

		while (queue.size() > 0) {
			ListNode node = queue.poll();
			if (newHead == null) {
				newHead = node;
				prev = newHead;
			} else {
				prev.next = node;
				prev = node;
			}

			if (node.next != null) {
				node = node.next;
				queue.offer(node);
			}
		}

		return newHead;
	}
}
