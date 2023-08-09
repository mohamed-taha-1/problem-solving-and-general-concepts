package medium._99_RecoverBinarySearchTree;

public class _99_RecoverBinarySearchTree {

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

	public static void recoverTree(TreeNode root) {

		TreeNode prev = null;
		TreeNode current = root;

		while (current != null) {
			prev = current;

			if (current.left.val <= current.val && current.right.val >= current.val) {

			} else if (current.left.val >= prev.val) {
				TreeNode temp = prev;
				prev = current.left;
				current.left = temp;
			} else if (current.right.val <= prev.val) {
				TreeNode temp = prev;
				prev = current.right;
				current.left = temp;
			}

			recoverTree(current.left);
			recoverTree(current.right);
		}
	}

	public static void recover2Tree(TreeNode root) {

		if (root == null)
			return;

		TreeNode prev = null;
		TreeNode first = null;
		TreeNode second = null;
		TreeNode current = root;

		// Use Morris Traversal for in-order traversal without using recursion
		while (current != null) {

			if (current.left == null) {
				if (prev != null && prev.val >= current.val) {
					if (first == null)
						first = prev;
					second = current;
				}

				prev = current;
				current = current.right;

			} else {
				// Find the inorder predecessor of current
				TreeNode pred = current.left;

				if (pred.right != null && pred.right != current) {

					pred = pred.right;
				}
				if (pred.right == null) {

					// Set the right pointer of predecessor to current
					pred.right = current;
					current = current.left;
				} else {
					// Process the current node
					if (prev != null && prev.val >= current.val) {
						if (first == null) {
							first = prev;
						}
						second = current;
					}
					pred.right = null; // Restore the original tree structure
					prev = current;
					current = current.right;
				}

			}

		}

		// Swap the values of the nodes
		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}

	}

	private TreeNode first, second, prev;

	public void recoverTree3(TreeNode root) {
		first = null;
		second = null;
		prev = null;
		traverse(root);

		int temp = first.val;
		first.val = second.val;
		second.val = temp;

	}

	private void traverse(TreeNode node) {

		if (node == null)
			return;

		traverse(node.left);
		if (prev != null && prev.val >= node.val) {
			if (first == null)
				first = prev;
			second = node;

		} else {
			prev = node;

		}

		traverse(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
