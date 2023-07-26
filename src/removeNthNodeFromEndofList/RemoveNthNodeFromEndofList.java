package removeNthNodeFromEndofList;

public class RemoveNthNodeFromEndofList {

	public class ListNode {
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

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode fast = dummy;
		ListNode slow = dummy;

		// Move the fast pointer n steps ahead
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}

		// Move both pointers until the fast pointer reaches the end
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		// Remove the Nth node from the end
		slow.next = slow.next.next;

		return dummy.next;

	}

	public static void main(String[] args) {

	}

}
