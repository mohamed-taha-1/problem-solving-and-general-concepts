package medium._230_KthSmallestElementinaBST;

import java.util.ArrayList;
import java.util.List;

public class _230_KthSmallestElementinaBST {

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
	
	/*
	 * Input: root = [3,1,4,null,2], k = 1 Output: 1
	 */
	
	/*
	 * Input: root = [5,3,6,2,4,null,null,1], k = 3 Output: 3
	 */

	public static int kthSmallest(TreeNode root, int k) {

		// in-order and store the result in a list
		List<Integer> result = new ArrayList<>();
		helper(root, result);

		result = result.stream().sorted().toList();
		return result.get(k);
	}

	private static void helper(TreeNode root, List<Integer> result) {

		if (root == null)
			return;

		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
