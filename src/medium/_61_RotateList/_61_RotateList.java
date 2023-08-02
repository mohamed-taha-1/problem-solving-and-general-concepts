package medium._61_RotateList;

public class _61_RotateList {

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

		  int length = 1;
	        ListNode current = head;

	        // Calculate the length of the linked list.
	        while (current.next != null) {
	            current = current.next;
	            length++;
	        }

	        // Adjust k to the effective number of rotations needed.
	        k = k % length;

	        if (k == 0) {
	            // If k is a multiple of the list length, no rotations needed.
	            return head;
	        }

		for (int i = 0; i < k; i++) {
			// Step 1: Traverse to find the last node (n-th node).
			ListNode lastNode = head;
			
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}

			// Step 2: Traverse again to find the (n-1)th node.
			ListNode nMinus1Node = head;
			while (nMinus1Node.next != lastNode) {
				nMinus1Node = nMinus1Node.next;
			}

			// Step 3: Update the last node's pointer to point to the first node.
			lastNode.next = head;

			// Step 4: Update the (n-1)th node's pointer to null.
			nMinus1Node.next = null;

			// Update the head to the new head after rotation.
			head = lastNode;
		}

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
