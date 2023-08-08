package medium._95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {

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

	public static List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	private static List<TreeNode> helper(int start, int end) {

		List<TreeNode> result = new ArrayList<>();

		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftNodesResults = helper(start, i - 1);
			List<TreeNode> rightNodesResults = helper(i + 1, end);

			for (TreeNode left : leftNodesResults) {
				for (TreeNode right : rightNodesResults) {

					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);

				}
			}

		}

		return result;

	}

	private static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		printInOrder(root.left);
		System.out.print(root.val + " ");
		printInOrder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (TreeNode node : generateTrees(3)) {
			printInOrder(node);

		}

	}

}
