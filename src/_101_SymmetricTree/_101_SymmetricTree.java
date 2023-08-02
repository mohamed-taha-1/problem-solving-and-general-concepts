package _101_SymmetricTree;

public class _101_SymmetricTree {

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

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true; // An empty tree is symmetric by definition
		}
		return isMirror(root.left, root.right);
	}

	private static boolean isMirror(TreeNode leftSubtree, TreeNode rightSubTree) {

		if (leftSubtree == null && rightSubTree == null) {
			return true;
		}

		if (leftSubtree == null || rightSubTree == null) {
			return false;
		}

		return (leftSubtree.val == rightSubTree.val) && isMirror(leftSubtree.left, rightSubTree.right)
				&& isMirror(leftSubtree.right, rightSubTree.left);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
