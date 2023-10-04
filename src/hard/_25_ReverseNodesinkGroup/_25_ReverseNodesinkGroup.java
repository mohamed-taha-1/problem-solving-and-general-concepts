package hard._25_ReverseNodesinkGroup;

public class _25_ReverseNodesinkGroup {

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

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prevGroupTail = dummy;
		ListNode current = head;

		int count = 0;

		while (current != null) {
			count++;

			if (count % k == 0) {
				prevGroupTail = reverse(prevGroupTail, current.next);
				current = prevGroupTail.next;
			} else {
				current = current.next;
			}

		}

		return dummy.next;
	}

	private ListNode reverse(ListNode prevGroup, ListNode current) {
		ListNode prev = prevGroup.next;
		ListNode currentNode = prev.next;

		while (currentNode != current) {
			prev.next = currentNode.next;
			currentNode.next = prevGroup.next;
			prevGroup.next = currentNode;
			currentNode = prev.next;

		}

		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
