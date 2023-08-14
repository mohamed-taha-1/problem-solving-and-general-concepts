package medium._103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103_BinaryTreeZigzagLevelOrderTraversal {
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

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		
		 if (root == null) {
	            return result;
	        }
		
		queue.offer(root);
		  boolean reverse = false;
		
		while(!queue.isEmpty()) {
			
			List<Integer> current=new ArrayList<>();
			int levelSize=queue.size();
			  for (int i = 0; i < levelSize; i++) {
				  TreeNode node= queue.poll();
				    if(reverse) current.add(0,node.val );
				    else current.add(node.val);
				    
				    if(node.left!=null) queue.offer(node.left);
				    if(node.right!=null) queue.offer(node.right);
				
			}
			  result.add(current);
			  reverse=!reverse;
			
		}
		
		
		
		
		return result;
	}

	public static void main(String[] args) {
		 // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
      
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);

	}

}
