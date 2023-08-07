package easy._144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_BinaryTreePreorderTraversal {

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

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val); // Visit the current node (preorder)
                stack.push(root);
                root = root.left; // Move to the left child
            }
            root = stack.pop();
            root = root.right; // Move to the right child
        }

        return list;
    }

	
	public static List<Integer> preorderTraversalRecuersive(TreeNode root) {
		List<Integer> list = new ArrayList<>();
       

        if (root == null) {
            return list;
        }
		
        
        list.add(root.val);
        list.addAll(    preorderTraversalRecuersive(root.left));
        list.addAll(   preorderTraversalRecuersive(root.right));
       
       
       return list;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		// Call the preorderTraversal method and get the result
		List<Integer> traversalResult = preorderTraversalRecuersive(root);

		// Print the result
		System.out.println("Preorder Traversal Result: " + traversalResult);
	}

}
