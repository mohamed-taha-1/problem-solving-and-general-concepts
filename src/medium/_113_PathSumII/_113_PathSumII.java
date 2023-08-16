package medium._113_PathSumII;

import java.util.ArrayList;
import java.util.List;

public class _113_PathSumII {

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

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(result, new ArrayList<>(), root, targetSum);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> current, TreeNode root, int remainingSum) {
		if (root == null) {
			return;
		}

		List<Integer> updatedPath = new ArrayList<>(current);
		updatedPath.add(root.val);

		if (root.left == null && root.right == null && root.val == remainingSum) {
			result.add(updatedPath);
			return;
		}

		helper(result, updatedPath, root.left, remainingSum - root.val);
		helper(result, updatedPath, root.right, remainingSum - root.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		int targetSum = 22;

		System.out.println(pathSum(root, targetSum));

	}

}
