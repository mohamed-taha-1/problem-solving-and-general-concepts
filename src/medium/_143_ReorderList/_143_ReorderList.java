package medium._143_ReorderList;

import java.util.Stack;

public class _143_ReorderList {

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

	// L0 → L1 → … → Ln - 1 → Ln

	// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

	public static void reorderList(ListNode head) {

		// two pointer - stack - linked- recuersion

		if (head == null)
			return;
		ListNode current = head;
		Stack<ListNode> stack = new Stack<>();

		while (current != null) {
			stack.push(current);
			current = current.next;
		}

		current = head;
		int count = stack.size() / 2;

		while (count > 0) {
			ListNode temp = current.next;
			ListNode cuurentFromStack = stack.pop();

			current.next = cuurentFromStack;
			cuurentFromStack.next = temp;
			current = temp;

			count--;
		}
		if (current != null) {
			current.next = null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
