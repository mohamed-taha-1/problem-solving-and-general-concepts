package _104_MaximumDepthofBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class _104_MaximumDepthofBinaryTree {

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

	public static int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		int leftNodes = maxDepth(root.left);
		int rightNodes = maxDepth(root.right);

		return Math.max(leftNodes, rightNodes) + 1;

	}

	public static int maxDepthIteration(TreeNode root) {

		// with bfs
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
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);

			}

			depth++;

		}

		return depth;

	}

	public static void main(String[] args) {
		// Constructing the binary tree:
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println("In-order Traversal: " + maxDepthIteration(root));

	}

}
