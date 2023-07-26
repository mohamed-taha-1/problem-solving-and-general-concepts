package _94_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_Binary_Tree_Inorder_Traversal {

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

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			if (!stack.isEmpty()) {
				current = stack.pop();
				result.add(current.val);
				current = current.right;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);


		System.out.println("In-order Traversal: " + inorderTraversal(root));
	}

}
