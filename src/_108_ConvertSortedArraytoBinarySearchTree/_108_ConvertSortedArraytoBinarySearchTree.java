package _108_ConvertSortedArraytoBinarySearchTree;

public class _108_ConvertSortedArraytoBinarySearchTree {

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

	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, left, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, right);

		return root;

	}

	// Inorder traversal of the BST (used for verification)
	private static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -10, -3, 0, 5, 9 };

		TreeNode root = sortedArrayToBST(nums);

		// Print the inorder traversal of the BST to verify it's balanced
		System.out.println("Inorder Traversal of the Balanced BST:");
		inorderTraversal(root);

	}

}
