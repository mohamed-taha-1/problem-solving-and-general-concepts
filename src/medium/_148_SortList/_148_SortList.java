package medium._148_SortList;

import java.util.Stack;

public class _148_SortList {

	// Given the head of a linked list, return the list after sorting it in
	// ascending order.

	/*
	 * Input: head = [4,2,1,3] Output: [1,2,3,4]
	 */

	/*
	 * Input: head = [-1,5,3,4,0] Output: [-1,0,3,4,5]
	 */

	/*
	 * Input: head = [] Output: []
	 */

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// Can you sort the linked list in O(n logn) time and O(1) memory.....

	public static ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = findMiddle(head);
		ListNode seconHalf = mid.next;
		mid.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(seconHalf);

		return mergeSort(left, right);

	}

	private static ListNode findMiddle(ListNode head) {
		// found middle : slow
		// merge first half and second half
		ListNode right = head;
		ListNode left = head;

		while (right.next != null && right.next.next != null) {
			left = left.next;
			right = right.next.next;
		}

		return left;
	}

	private static ListNode mergeSort(ListNode left, ListNode right) {

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (left != null && right != null) {
			if (left.val < right.val) {
				current.next = left;
				left = left.next;

			} else {
				current.next = right;
				right = right.next;
			}

			current = current.next;
		}

		if (left != null)
			current.next = left;
		if (right != null)
			current.next = right;

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
