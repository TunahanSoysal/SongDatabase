
class Node {
	int key, height,index;
	Node left, right;

	Node(int d,int index) {
		key = d;
		height = 1;
		this.index = index;
	}
}
class AVLintTree {
	Node root;
	int height(Node N) {
		if (N == null)
			return 0;

		return N.height;
	}
	int max(int a, int b) {
		return Math.max(a, b);
	}
	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;


		x.right = y;
		y.left = T2;


		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}
	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;


		y.left = x;
		x.right = T2;


		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;


		return y;
	}
	int getBalance(Node N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}
	Node insert(Node node, int key,int index) {


		if (node == null)
			return (new Node(key,index));

		if (key < node.key)
			node.left = insert(node.left, key, index);
		else if (key > node.key)
			node.right = insert(node.right, key, index);
		else
			return node;
		node.height = 1 + max(height(node.left),
				height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}
	public Node search(Node root, int key) {
		if (root==null || root.key==key)
			return root;

		if (root.key < key)
			return search(root.right, key);

		return search(root.left, key);
	}

}