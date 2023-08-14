package medium._105_ConstructBinaryTreefromPreorderandInorderTraversal;

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {

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

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
	}

	private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
	    if (preIndex >= preorder.length || inStart > inEnd) {
	        return null;
	    }

	    TreeNode root = new TreeNode(preorder[preIndex]);
	    int inIndex = -1;

	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	            break;
	        }
	    }

	    root.left = buildTreeHelper(preorder, inorder, preIndex + 1, inStart, inIndex - 1);
	    root.right = buildTreeHelper(preorder, inorder, preIndex + inIndex - inStart + 1, inIndex + 1, inEnd);

	    return root;
	}

	private static void printInorder(TreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.val + " ");
			printInorder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		TreeNode root =buildTree(preorder, inorder);

		printInorder(root);
	}

}
