package medium._109_ConvertSortedListtoBinarySearchTree;

public class _109_ConvertSortedListtoBinarySearchTree {

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

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private TreeNode sortedListToBST(ListNode head) {

		int length = findLength(head);
		return sortedListToBSTHelper(head, length);
	}

	private static TreeNode sortedListToBSTHelper(ListNode head, int length) {
		if (length == 0) {
			return null;
		}

		int mid = length / 2;

		// Find the middle node
		ListNode midNode = head;
		for (int i = 0; i < mid; i++) {
			midNode = midNode.next;
		}

		// Create the root node with the value of the middle node
		TreeNode root = new TreeNode(midNode.val);

		// Recursively construct the left and right subtrees
		root.left = sortedListToBSTHelper(head, mid);
		root.right = sortedListToBSTHelper(midNode.next, length - mid - 1);

		return root;
	}

	private static int findLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
