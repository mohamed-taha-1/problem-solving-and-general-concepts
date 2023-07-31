package medium._61_RotateList;

public class AntherALternativeSolution {

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

	// here it need to rotate with specigic key! and return the root of the rotated
	// one
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			// If the linked list is empty, has only one node, or no rotations needed.
			return head;
		}

		ListNode lastNode = head;
		while (lastNode.next != null) {
			lastNode = lastNode.next;

		}

		ListNode BeforLast = head;
		while (BeforLast.next != lastNode) {
			BeforLast = BeforLast.next;
		}

		lastNode.next = head;
		BeforLast.next = null;
		head = lastNode;

		return head;

	}

	// Helper method to print the linked list
	public static void printLinkedList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		// Example usage:
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Original linked list:");
		printLinkedList(head);

		head = rotateRight(head, 2000000000);

		System.out.println("Rotated linked list:");
		printLinkedList(head);

	}

}
