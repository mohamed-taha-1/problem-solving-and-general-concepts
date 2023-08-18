package medium._129_SumRoottoLeafNumbers;

public class _129_SumRoottoLeafNumbers {

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
	 * You are given the root of a binary tree containing digits from 0 to 9 only.
	 * 
	 * Each root-to-leaf path in the tree represents a number.
	 * 
	 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
	 * Return the total sum of all root-to-leaf numbers. Test cases are generated so
	 * that the answer will fit in a 32-bit integer.
	 * 
	 * A leaf node is a node with no children.
	 * 
	 *
	 * 
	 */
//	Input: root = [1,2,3]
//			Output: 25
//			Explanation:
//			The root-to-leaf path 1->2 represents the number 12.
//			The root-to-leaf path 1->3 represents the number 13.
//			Therefore, sum = 12 + 13 = 25.

//	Input: root = [4,9,0,5,1]
//			Output: 1026
//			Explanation:
//			The root-to-leaf path 4->9->5 represents the number 495.
//			The root-to-leaf path 4->9->1 represents the number 491.
//			The root-to-leaf path 4->0 represents the number 40.
//			Therefore, sum = 495 + 491 + 40 = 1026.
//	

	public static int sumNumbers(TreeNode root) {

		if (root == null)
			return 0;
		return helper(root, 0);
	}

	private static int helper(TreeNode node, int result) {
		if (node == null)
			return 0;

		int updatedValue = result * 10 + node.val;
		if (node.left == null && node.right == null) {
	        return updatedValue;
	    }
		int left = helper(node.left, updatedValue);
		int right = helper(node.right, updatedValue);

		return right+left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
