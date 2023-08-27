package medium._199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class _199_BinaryTreeRightSideView {

	/*
	 * Given the root of a binary tree, imagine yourself standing on the right side
	 * of it, return the values of the nodes you can see ordered from top to bottom.
	 */

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

	public static List<Integer> rightSideView(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> result = new ArrayList<>();

		dfs(root, 0, result);
		return result;
	}

	private static void dfs(TreeNode node, int level, List<Integer> result) {
		if (node == null) {
			return;
		}

		if (level == result.size()) {
			result.add(node.val);
		}

		dfs(node.right, level + 1, result);
		dfs(node.left, level + 1, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
