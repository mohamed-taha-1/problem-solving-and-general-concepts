package swapNodesinPairs;

import swapNodesinPairs.SwapNodesinPairs.ListNode;

public class solution2WithRecuersion {
	
	
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
	  // Base case: If the list is empty or has only one node, return the head
    if (head == null || head.next == null) {
        return head;
    }

    // Swapping the first pair of nodes
    ListNode newHead = head.next;
    head.next = swapPairs(newHead.next);
    newHead.next = head;

    return newHead;
    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
