package medium._92_ReverseLinkedListII;

public class _92_ReverseLinkedListII {

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

	public static ListNode reverseBetween(ListNode head, int left, int right) {
	        
		   int count = 0;
		    ListNode dummy = new ListNode(0);
		    dummy.next = head;
		    ListNode prev = dummy;

		    // Move prev to the node before the left position
		    while (count < left - 1 && prev.next != null) {
		        prev = prev.next;
		        count++;
		    }
		 
		    // Initialize current and the tail pointers
		    ListNode current = prev.next;
		    ListNode tail = current;

		    // Reverse the nodes from left to right
		    ListNode nextNode = null;
		    while (count < right && current != null) {
		        ListNode temp = current.next;
		        current.next = nextNode;
		        nextNode = current;
		        current = temp;
		        count++;
		    }

		 
		 
		 // Connect the reversed portion with the rest of the list
		    prev.next = nextNode;
		    tail.next = current;
		 
		 return dummy.next;
	    }

	public static void main(String[] args) {
		// Example usage of reverseBetween method
		// Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		// Reverse the portion between left = 2 and right = 4
		ListNode reversedList = reverseBetween(head, 2, 4);

		// Print the reversed linked list: 1 -> 4 -> 3 -> 2 -> 5 -> null
		ListNode current = reversedList;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

}
