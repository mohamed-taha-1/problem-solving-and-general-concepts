package hard._23_MergekSortedLists;

public class _23_MergekSortedLists {

	/*
	 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6]
	 * 
	 * Explanation: The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ]
	 * 
	 * 
	 * example2: Input: lists = [] Output: []
	 * 
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

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		int interval = 1;
		while (interval < lists.length) {
			for (int i = 0; i + interval < lists.length; i += interval * 2) {
				lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
			}
			interval *= 2;
		}

		return lists[0];
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}

			current = current.next;
		}

		if (l1 != null) {
			current.next = l1;
		}

		if (l2 != null) {
			current.next = l2;
		}
		return dummy.next;

	}

	public static void main(String[] args) {
		// Create sample linked lists

	}

}
