package ds.unionFind;

public class Node {

	Node parent;
	public int data;
	public int rank;

	private Node() {

	}

	public Node(int data) {
		parent = new Node();
		this.data = data;
		this.rank = 0;
	}

}
