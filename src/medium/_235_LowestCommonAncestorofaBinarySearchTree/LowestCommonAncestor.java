package medium._235_LowestCommonAncestorofaBinarySearchTree;

public class LowestCommonAncestor {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q);
	}

	private static TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		// If either p or q is found, return the current root as a potential ancestor.
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = helper(root.left, p, q);
		TreeNode right = helper(root.right, p, q);
		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
