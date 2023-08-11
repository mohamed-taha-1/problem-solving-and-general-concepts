package medium._105_ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.Stack;

public class SecondSolution {

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
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[0]);
		TreeNode current = root;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(current);

		for (int i = 1, j = 0; i < preorder.length; i++) {
			if (current.val != inorder[j]) {
				
				// left
				current.left = new TreeNode(preorder[i]);
				stack.push(current);
				current = current.left;
				
			} else {
				j++;
				while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
					current = stack.pop();
					j++;
				}
				
				 // right
				 current.right = new TreeNode(preorder[i]);
				 current =current.right;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		TreeNode root = buildTree(preorder, inorder);

	}

}
