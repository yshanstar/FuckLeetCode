package hack.util;

public class DoubleLinkedListNode {
	public int value;
	public int key;
	public DoubleLinkedListNode prev;
	public DoubleLinkedListNode next;

	public DoubleLinkedListNode(int k, int v) {
		this.key = k;
		this.value = v;
		this.prev = null;
		this.next = null;
	}
}
