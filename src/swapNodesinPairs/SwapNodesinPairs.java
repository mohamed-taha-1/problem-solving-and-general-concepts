package swapNodesinPairs;

import removeNthNodeFromEndofList.RemoveNthNodeFromEndofList.ListNode;

public  class SwapNodesinPairs {

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

	public static ListNode swapPairs(ListNode head) {
		 ListNode dummy = new ListNode(0);
		    dummy.next = head;

		    ListNode prev = dummy;
		    ListNode curr = head;

		    while (curr != null && curr.next != null) {
		        ListNode nextNode = curr.next;
		        ListNode temp = nextNode.next;

		        // Swap the pair of nodes
		        prev.next = nextNode;
		        nextNode.next = curr;
		        curr.next = temp;

		        // Move the pointers forward
		        prev = curr;
		        curr = temp;
		    }

		    return dummy.next;
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
