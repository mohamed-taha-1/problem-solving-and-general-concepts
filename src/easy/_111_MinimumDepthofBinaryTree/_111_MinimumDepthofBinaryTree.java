package easy._111_MinimumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import _104_MaximumDepthofBinaryTree._104_MaximumDepthofBinaryTree.TreeNode;

public class _111_MinimumDepthofBinaryTree {

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

	public static int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int depth = 0;

		while (!queue.isEmpty()) {
			int length = queue.size();
			for (int i = 0; i < length; i++) {
				TreeNode node = queue.poll();

				// If a leaf node is encountered, return the current depth
				if (node.left == null && node.right == null) {
					return depth + 1;
				}

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			depth++;
		}

		// This line should never be reached as there should always be a leaf node
		return depth;
	}

	public static void main(String[] args) {
		// Constructing the binary tree:
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println("In-order Traversal: " + minDepth(root));

	}

}
