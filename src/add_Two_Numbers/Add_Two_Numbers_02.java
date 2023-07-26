package add_Two_Numbers;

public class Add_Two_Numbers_02 {

	public ListNode addTwoNumbers(ListNode head1 , ListNode head2) {

	    ListNode result = new ListNode(0);
	    ListNode curr = result;

	    int sum = 0;
	    int carry = 0;

	    while (head1 != null || head2 != null) {
	        sum = carry;

	        if (head1 != null) {
	            sum += head1.val;
	            head1 = head1.next;
	        }

	        if (head2 != null) {
	            sum += head2.val;
	            head2 = head2.next;
	        }

	        carry = sum / 10;
	        sum = sum % 10;

	        curr.next = new ListNode(sum);
	        curr = curr.next;
	    }

	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }

	    return result.next;
	}
	  


}
