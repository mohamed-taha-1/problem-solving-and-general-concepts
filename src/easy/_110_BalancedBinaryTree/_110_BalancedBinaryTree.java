package easy._110_BalancedBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import _104_MaximumDepthofBinaryTree._104_MaximumDepthofBinaryTree.TreeNode;

public class _110_BalancedBinaryTree {

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

	public static boolean isBalanced(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();

		if (root == null)
			return true;

		queue.add(root);

		while (!queue.isEmpty()) {

			int length = queue.size();

			for (int i = 0; i < length; i++) {

				TreeNode node = queue.poll();

				int leftNode = getHeight(node.left);
				int rightNode = getHeight(node.right);

				if (Math.abs(leftNode - rightNode) > 1)
					return false;

				if (node.left != null) {
					queue.add(node.left);

				}
				if (node.right != null) {
					queue.add(node.right);

				}

			}

		}

		return true;
	}

	private static int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHight = getHeight(root.left);
		int rightHight = getHeight(root.right);

		return Math.max(leftHight, rightHight) + 1;

	}

	public static void main(String[] args) {
		// Constructing the binary tree:
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);

		root.right.right = new TreeNode(7);
		root.left.left = null;
		root.left.right = null;

		System.out.println("In-order Traversal: " + isBalanced(root));

	}

}
