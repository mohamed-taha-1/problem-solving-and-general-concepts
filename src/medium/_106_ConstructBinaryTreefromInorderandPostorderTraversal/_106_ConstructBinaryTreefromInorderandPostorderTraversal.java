package medium._106_ConstructBinaryTreefromInorderandPostorderTraversal;

import java.util.Stack;

public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {

	public static  class TreeNode {
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

	public static TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return null;

		int nPost = postorder.length;
		int nIord = inorder.length;

		TreeNode root = new TreeNode(postorder[nPost - 1]);
		TreeNode current = root;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(current);

		for (int i = nPost - 2, j = nIord - 1; i >= 0; i--) {

			if (current.val != inorder[j]) {
				current.right = new TreeNode(postorder[i]);
				stack.push(current);
				current = current.right;

			} else {
				j--;
				while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
					current=stack.pop();
					j--;
				}

				current.left = new TreeNode(postorder[i]);
				current = current.left;

			}

		}

		return root;
	}
	
	private TreeNode sol(int[] inorder, int[] postorder) {
	      if (inorder.length != postorder.length) {
	            return null; // Invalid input
	        }
	        
	        int n = inorder.length;
	        return buildTreeHelper(inorder, 0, n - 1, postorder, 0, n - 1);
	    }
	    
	    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
	                                     int[] postorder, int postStart, int postEnd) {
	        if (inStart > inEnd || postStart > postEnd) {
	            return null;
	        }
	        
	        int rootValue = postorder[postEnd];
	        TreeNode root = new TreeNode(rootValue);
	        
	        int rootIndexInorder = -1;
	        for (int i = inStart; i <= inEnd; i++) {
	            if (inorder[i] == rootValue) {
	                rootIndexInorder = i;
	                break;
	            }
	        }
	        
	        int leftSubtreeSize = rootIndexInorder - inStart;
	        
	        root.left = buildTreeHelper(inorder, inStart, rootIndexInorder - 1,
	                                    postorder, postStart, postStart + leftSubtreeSize - 1);
	        root.right = buildTreeHelper(inorder, rootIndexInorder + 1, inEnd,
	                                     postorder, postStart + leftSubtreeSize, postEnd - 1);
	        
	        return root;
	    }
	
	

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        System.out.println(  buildTree(inorder, postorder).val);

	}

}
