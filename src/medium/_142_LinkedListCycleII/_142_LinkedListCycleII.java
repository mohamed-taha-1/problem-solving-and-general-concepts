package medium._142_LinkedListCycleII;

import java.util.HashMap;
import java.util.Map;

public class _142_LinkedListCycleII {

	/*
	 * Given the head of a linked list, return the node where the cycle begins. If
	 * there is no cycle, return null.
	 * 
	 * There is a cycle in a linked list if there is some node in the list that can
	 * be reached again by continuously following the next pointer. Internally, pos
	 * is used to denote the index of the node that tail's next pointer is connected
	 * to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as
	 * a parameter.
	 */

	/*
	 * Input: head = [3,2,0,-4], pos = 1 Output: tail connects to node index 1
	 * Explanation: There is a cycle in the linked list, where tail connects to the
	 * second node.
	 */

	/*
	 * Input: head = [1,2], pos = 0 Output: tail connects to node index 0
	 * Explanation: There is a cycle in the linked list, where tail connects to the
	 * first node.
	 */

	/*
	 * Input: head = [1], pos = -1 Output: no cycle Explanation: There is no cycle
	 * in the linked list.
	 */

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

	}

	public static ListNode detectCycle(ListNode head) {

		if(head== null) return null;
		ListNode slow=head;
		ListNode fast=head;
		
		while(fast!=null &&fast.next!=null) {
			slow=slow.next;	
		    fast=fast.next.next;	
		    
		    
		    if(slow==fast) { // cycle detected
		    	ListNode start=head;
		    	while(start!=slow) {
		    		start=start.next;
		    		slow=slow.next;
		    	}
		    	
		    	return start;
		    }
		
		}

		return null;
	}
	
	
	 public ListNode detectCycle2(ListNode head) {
	        if (head == null) {
	        return null;
	    }
	    
	    ListNode current = head;
	    Map<ListNode, ListNode> map = new HashMap<>();
	    
	    // Create the mapping of nodes to their next nodes
	    while (current != null) {
	        if (map.containsKey(current)) {
	            return current; // Return the starting node of the cycle
	        }
	        
	        map.put(current, current.next);
	        current = current.next;
	    }
	    
	    return null; // No cycle found
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
