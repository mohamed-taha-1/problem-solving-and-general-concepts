package medium._82_RemoveDuplicatesfromSortedListII;

public class _82_RemoveDuplicatesfromSortedListII {

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
        
	
	 if (head == null || head.next == null) {
         return head;
     }
	 ListNode dummy = new ListNode(0);
     dummy.next = head;
     
     ListNode prev = dummy;
     ListNode current = head;
     
     
	while(current!=null) {
		  
		 while (current.next != null && current.val == current.next.val) {
             current = current.next;
         }
		 
		// If no duplicates found, update the pointers
         if (prev.next == current) {
             prev = current;
         } else {
             prev.next = current.next;
         }

         current = current.next;
     }
	
	
	
	
	return dummy.next;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
