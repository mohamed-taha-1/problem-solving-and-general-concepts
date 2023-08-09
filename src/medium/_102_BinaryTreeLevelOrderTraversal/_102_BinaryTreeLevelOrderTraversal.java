package medium._102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {

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

	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result= new ArrayList<>();
		List<Integer> current=new ArrayList<>();
		
		traversal(root,result, 0);
		
		
		return result;
	}
	
	private static void traversal(TreeNode root,List<List<Integer>> result,int level) {
		if (root == null) return; // Exit the recursion when root is null

	   if(level>=result.size()) result.add(new ArrayList<>());
	  
		   result.get(level).add(root.val);
	   
		
		traversal(root.left,result,level+1);
		traversal(root.right,result,level+1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
