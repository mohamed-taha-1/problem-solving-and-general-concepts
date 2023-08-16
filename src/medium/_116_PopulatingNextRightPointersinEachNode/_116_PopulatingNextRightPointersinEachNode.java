package medium._116_PopulatingNextRightPointersinEachNode;

import java.util.ArrayList;
import java.util.List;

public class _116_PopulatingNextRightPointersinEachNode {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public static Node connect(Node root) {

		if (root == null) {
			return null;
		}

		connectNodes(root);
		return root;
	}

	private static void connectNodes(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			node.left.next = node.right;
		}

		if (node.right != null && node.next != null) {
			node.right.next = node.next.left;
		}

		connectNodes(node.left);
		connectNodes(node.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
