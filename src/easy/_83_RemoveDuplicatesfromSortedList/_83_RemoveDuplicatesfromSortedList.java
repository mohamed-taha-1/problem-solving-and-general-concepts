package easy._83_RemoveDuplicatesfromSortedList;

public class _83_RemoveDuplicatesfromSortedList {

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

	public static ListNode deleteDuplicates(ListNode head) {
		if(head== null) return null;
		
		ListNode current=head;
		while(current.next!=null) {
			
			if(current.val==current.next.val) {
				current.next=current.next.next;
			}
			
			current=current.next;
		}
		
		
		return head;
	}
	
	
	 public static void printLinkedList(ListNode head) {
	        ListNode current = head;
	        while (current != null) {
	            System.out.print(current.val + " -> ");
	            current = current.next;
	        }
	        System.out.println("null");
	    }

	public static void main(String[] args) {
		 // Create a linked list with duplicates
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Call the deleteDuplicates function
        head = deleteDuplicates(head);

        System.out.println("\nLinked List after removing duplicates:");
        printLinkedList(head);
        

	}

}
