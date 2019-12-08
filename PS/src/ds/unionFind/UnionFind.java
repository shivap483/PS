package ds.unionFind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

	private static Map<Integer, Node> map = new HashMap<>();

	// find parent of the set
	public static Node findSet(int data) {
		Node node = map.get(data);
		Node parent = node.parent;
		if (parent.parent == node.parent) {
			return parent;
		}
		node.parent = findSet(node.parent.data);
		return node.parent;
	}

	// make disjoint sets
	public static void makeSet(int data) {
		Node node = new Node();
		node.parent = node;
		node.data = data;
		node.rank = 0;
		map.put(data, node);
	}

	// Join sets
	public static void Connect(int data1, int data2) {
		if (isConneted(data1, data2)) {
			return;
		}
		Node parent1 = map.get(data1).parent;
		Node parent2 = map.get(data2).parent;
		if (parent1.rank > parent2.rank) {
			parent2.parent = parent1;
		} else if (parent1.rank == parent2.rank) {
			parent2.parent = parent1;
			parent1.rank = parent1.rank + 1;
		} else {
			parent1.parent = parent2;
		}
	}

	// check if connected
	public static boolean isConneted(int data1, int data2) {
		if (findSet(data1) == findSet(data2))
			return true;
		return false;
	}

	public static void main(String[] args) {
		makeSet(5);
		makeSet(7);
		makeSet(4);
		makeSet(8);
		makeSet(0);
		makeSet(2);

		Connect(5, 7);
		Connect(4, 7);
		Connect(0, 2);
		Connect(5, 2);
		Connect(4, 8);
		System.out.println(findSet(5).data);
		System.out.println(findSet(7).data);
		System.out.println(findSet(4).data);
		System.out.println(findSet(8).data);
		System.out.println(findSet(0).data);
		System.out.println(findSet(2).data);
	}
}
