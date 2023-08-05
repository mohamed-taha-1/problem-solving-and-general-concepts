package medium._86_PartitionList;

public class _86_PartitionList {

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

	public static ListNode partition(ListNode head, int x) {
		ListNode beforeHead = new ListNode(0); // Dummy node for the nodes with values less than x
		ListNode before = beforeHead;

		ListNode afterHead = new ListNode(0); // Dummy node for the nodes with values greater than or equal to x
		ListNode after = afterHead;

		while (head != null) {
			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}

			head = head.next;
		}

		// Connect the two partitions and set the next of the last node in the "after"
		// partition to null
		after.next = null;
		before.next = afterHead.next;

		return beforeHead.next; // The new head of the partitioned list
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
