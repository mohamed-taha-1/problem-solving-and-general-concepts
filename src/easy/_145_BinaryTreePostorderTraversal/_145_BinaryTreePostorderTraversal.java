package easy._145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class _145_BinaryTreePostorderTraversal {

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

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		list.addAll(postorderTraversal(root.left));
		list.addAll(postorderTraversal(root.right));
		list.add(root.val);

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
