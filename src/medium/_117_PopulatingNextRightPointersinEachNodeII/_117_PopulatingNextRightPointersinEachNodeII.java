package medium._117_PopulatingNextRightPointersinEachNodeII;

public class _117_PopulatingNextRightPointersinEachNodeII {

	// Definition for a Node.
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

		if(root == null) return null;
		
		connectTree(root , null);
		return root;
	}
	
	private static void connectTree(Node root, Node nextNode) {
		
		if(root ==  null) return;
		
		root.next=nextNode;
		Node nextRight=null;
		Node currentNext= nextNode;
		
		while(currentNext!=null && nextRight==null) {
			
			if(currentNext.left !=null) {
				nextRight=currentNext.left;
			}else if(currentNext.right!=null) {
				nextRight=currentNext.right;
			}else {
				currentNext=currentNext.next;
			}
			
		}
		
		
		connectTree(root.right, nextRight);
		connectTree(root.left, root.right);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
