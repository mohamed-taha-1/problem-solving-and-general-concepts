package easy._160_IntersectionofTwoLinkedLists;

public class _160_IntersectionofTwoLinkedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
	        return null;

	    ListNode currentA = headA;
	    ListNode currentB = headB;

	    while (currentA != currentB) {
	        currentA = (currentA == null) ? headB : currentA.next;
	        currentB = (currentB == null) ? headA : currentB.next;
	    }

	    return currentA; // or currentB, since they will be equal 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
