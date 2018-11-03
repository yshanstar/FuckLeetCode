package hack.facebook;

import hack.util.ListNode;

/*
Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.

The following example may help you understand the problem better:

In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list.


Reference: https://leetcode.com/problems/insert-into-a-cyclic-sorted-list/discuss/153116/O(n)-runtime-Java-solution


 */
public class InsertIntoCyclicSortedList {
    public ListNode insert(ListNode head, int insertVal) {
        // If start is null, create a new node
        if (head == null) {
            ListNode newNode = new ListNode(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        // is start is NOT null, try to insert it into correct position
        ListNode cur = head;
        while (true) {
            // Case 1a: has a tipping point , still climbing
            if (cur.val < cur.next.val) {
                if (cur.val <= insertVal && insertVal <= cur.next.val) {
                    // insertVal is between cur and next;
                    insertAfter(cur, insertVal);
                    break;
                }
            }
            // case 1b; has a tipping point, about to return back to min node
            else if (cur.val > cur.next.val) {
                if (cur.val <= insertVal || insertVal <= cur.next.val) {
                    // cur is the tipping point, insertVal is max or min val
                    insertAfter(cur, insertVal);
                    break;
                }
            }
            // case 2: No Tipping point, all flat
            else {
                if (cur.next == head) {  // insert x before we traverse all nodes back to start
                    insertAfter(cur, insertVal);
                    break;
                }
            }
            // None of the above three cases met, go to next node
            cur = cur.next;
        }

        return head;
    }

    // insert value x after Node cur
    private void insertAfter(ListNode cur, int x) {
        cur.next = new ListNode(x, cur.next);
    }

    public ListNode insertAC(ListNode head, int insertVal) {
        if (head == null) {
            ListNode newNode = new ListNode(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        ListNode cur = head;
        boolean inserted = false;

        do {
            if (insertHere(cur, insertVal)) {
                ListNode newNode = new ListNode(insertVal, cur.next);
                cur.next = newNode;
                inserted = true;
            }
            cur = cur.next;
        } while (cur != head && !inserted);

        if (cur == head) {
            cur.next = new ListNode(insertVal, cur.next);
        }

        return head;
    }

    private boolean insertHere(ListNode cur, int insertVal) {
        return (cur.val <= insertVal && cur.next.val >= insertVal)
                || ((cur.next.val < cur.val) && (insertVal <= cur.next.val || insertVal >= cur.val));
    }
}