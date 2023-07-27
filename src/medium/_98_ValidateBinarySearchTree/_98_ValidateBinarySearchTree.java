package medium._98_ValidateBinarySearchTree;

import java.util.Stack;

public class _98_ValidateBinarySearchTree {

	public class TreeNode {
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

	public static boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null; // To keep track of the previously visited node

		while (root != null || !stack.isEmpty()) {
			// Traverse to the leftmost node of the current subtree
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			// Process the nodes in in-order manner
			root = stack.pop();
			// Check if the current node's value is greater than the previous node's value
			if (prev != null && root.val <= prev.val) {
				return false;
			}
			prev = root; // Update the previous node
			root = root.right; // Move to the right subtree
		}

		return true; // If no v}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
