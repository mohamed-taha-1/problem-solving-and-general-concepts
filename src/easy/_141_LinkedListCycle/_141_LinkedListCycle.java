package easy._141_LinkedListCycle;

import java.util.HashSet;

public class _141_LinkedListCycle {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head) {

		ListNode current = head;
		boolean[] visited = new boolean[1000]; // Use a larger size to avoid index out of bounds
		while (current != null) {
			if (visited[current.val]) {
				return true; // Cycle detected
			}
			visited[current.val] = true;
			current = current.next;
		}

		return false; // No cycle found
	}

	public static boolean hasCycleSol2(ListNode node) {

		HashSet<ListNode> visited = new HashSet<>();
		ListNode current = node;
		while (current != null) {
			if (visited.contains(current)) {
				return true; // Cycle detected
			}
			visited.add(current);
			current = current.next;
		}

		return false; // No cycle found

	}

	public static boolean hasCyclicSol3(ListNode node) {

		if (node == null || node.next == null) {
			return false; // No cycle for an empty or single-node linked list
		}

		ListNode fast = node;
		ListNode slow = node;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;

		}

		return false;

	}

	public static void main(String[] args) {
		// Create a linked list with a cycle for testing
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head; // Creating a cycle by pointing the last node to the head

		boolean hasCycle = hasCyclicSol3(head);
		System.out.println("Has cycle: " + hasCycle);
	}

}
