package easy._203_RemoveLinkedListElements;

public class RemoveLinkedListElements {

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

	/*
	 * Input: head = [1,2,6,3,4,5,6], val = 6 Output: [1,2,3,4,5]
	 * 
	 * Input: head = [], val = 1 Output: []
	 */
	public ListNode removeElements(ListNode head, int val) {

		if(head==null) return null;
		while(head!=null && head.val==val) {
		
			head=head.next;	
		}
		
		 ListNode current = head;
		 while(current.next!=null) {
			 if(current.next.val==val) {
				 current.next=current.next.next;
			 }
			 current=current.next;
		 }
		
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
