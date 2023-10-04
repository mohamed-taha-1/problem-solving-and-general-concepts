package medium._237_DeleteNodeinaLinkedList;

public class DeleteNode {

	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	  
	  // Input: head = [4,5,1,9], node = 5 : [4,1,9]
	  public  static void deleteNode(ListNode node) {
	        
		  if(node == null || node.next==null) return;
		  
		   node.val=node.next.val;
		   node.next=node.next.next;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
