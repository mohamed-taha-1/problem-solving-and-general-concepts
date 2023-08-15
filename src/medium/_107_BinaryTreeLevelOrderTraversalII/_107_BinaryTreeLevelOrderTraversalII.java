package medium._107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_BinaryTreeLevelOrderTraversalII {

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

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> current = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				current.add(node.val);

				if (node.left != null) {
					queue.offer(node.left);
				} else if (node.right != null) {
					queue.offer(node.right);
				}
			}

			result.add(0, current);

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
