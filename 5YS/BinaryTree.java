
public class BinaryTree<T> {

	protected BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			root = new BinaryNode(element);
		} else {
			root.insert(element);
		}
	}

	public boolean contains(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			return false;
		} else {
			return root.contains(element);
		}
	}

	public int height() {
		if (isEmpty()) {
			return -1;
		} else {
			return root.height();
		}
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return root.size();
		}
	}

	public void inOrder() {
		if (!isEmpty()) {
			root.inOrder();
		}
	}

	public void preOrder() {
		if (!isEmpty()) {
			root.preOrder();
		}
	}

	public void postOrder() {
		if (!isEmpty()) {
			root.postOrder();
		}
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof BinaryTree<?>)) {
			return false;
		}
		BinaryTree<T> otherBinaryTree = (BinaryTree<T>) other;
		int mySize = size();
		if (mySize != otherBinaryTree.size()) {
			return false;
		}
		if (mySize != 0) // both trees are not empty
		{
			return root.equals(otherBinaryTree.root);
		}
		return true;
	}

	@Override
	public String toString() {
		if (!isEmpty()) {
			return root.toString();
		} else {
			return "Empty Tree";
		}
	}
}
