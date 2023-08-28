package medium._173_BinarySearchTreeIterator;

import java.util.Stack;

public class _173_BinarySearchTreeIterator {

	// 8k : {In-Order traversal |}

	// Implement the BSTIterator class that represents an iterator over the in-order
	// traversal of a binary search tree (BST):

	// boolean hasNext() Returns true ;, otherwise returns false.

	// int next() : Moves the pointer to the right, then returns the number at the
	// pointer.

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

	static class BSTIterator {
		private Stack<TreeNode> stack;

		BSTIterator(TreeNode node) {
			stack = new Stack<>();
			pushAll(node);

		}

		public int next() {

			TreeNode node = stack.pop();
			pushAll(node.right);
			return node.val;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		private void pushAll(TreeNode node) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BSTIterator iterator = new BSTIterator(root);
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
