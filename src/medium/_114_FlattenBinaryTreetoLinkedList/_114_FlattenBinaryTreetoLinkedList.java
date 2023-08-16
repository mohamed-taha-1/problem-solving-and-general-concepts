package medium._114_FlattenBinaryTreetoLinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class _114_FlattenBinaryTreetoLinkedList {

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

	public static void flatten(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		flattenHelper(root, queue);
		TreeNode prev = queue.poll();
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			prev.left = null;
			prev.right = current;
			prev = current;
		}

	}

	private static void flattenHelper(TreeNode root, Queue<TreeNode> queue) {
		if (root == null) {
			return;
		}

		queue.offer(root);
		flattenHelper(root.left, queue);
		flattenHelper(root.right, queue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
