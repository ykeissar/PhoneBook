
public class BinaryNode<T> {

	protected T data;
	protected BinaryNode left;
	protected BinaryNode right;

	public BinaryNode(T element) {
		this.data = element;
		left = null;
		right = null;
	}

	public void insert(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (Math.random() < 0.5) {
			if (left == null) {
				left = new BinaryNode<>(element);
			} else {
				left.insert(element);
			}
		} else {
			if (right == null) {
				right = new BinaryNode<>(element);
			} else {
				right.insert(element);
			}
		}
	}

	public boolean contains(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		boolean found = false;
		if (data.equals(element)) {
			found = true;
		} else if (left != null && left.contains(element)) {
			found = true;
		} else if (right != null && right.contains(element)) {
			found = true;
		}
		return found;
	}

	public int height() {
		int leftH = 0, rightH = 0;
		if (left != null) {
			leftH = left.height();
		}
		if (right != null) {
			rightH = right.height();
		}
		return Math.max(leftH, rightH) + 1;
	}

	public int size() {
		int leftS = 0, rightS = 0;
		if (left != null) {
			leftS = left.size();
		}
		if (right != null) {
			rightS = right.size();
		}
		return leftS + rightS + 1;
	}

	public void inOrder() {
		if (left != null) {
			left.inOrder();
		}
		System.out.println(data.toString());
		if (right != null) {
			right.inOrder();
		}
	}

	public void preOrder() {
		System.out.println(data.toString());
		if (left != null) {
			left.preOrder();
		}
		if (right != null) {
			right.preOrder();
		}
	}

	public void postOrder() {
		if (left != null) {
			left.postOrder();
		}
		if (right != null) {
			right.postOrder();
		}
		System.out.println(data.toString());
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof BinaryNode<?>)) {
			return false;
		}
		return equals(this, (BinaryNode<T>) other);
	}

	private boolean equals(BinaryNode<T> firstRoot, BinaryNode<T> secondRoot) {
		boolean areEqual = (firstRoot == secondRoot);
		if (!areEqual) {
			if (firstRoot != null & secondRoot != null) {
				areEqual = firstRoot.data.equals(secondRoot.data) && equals(firstRoot.left, secondRoot.left)
						&& equals(firstRoot.right, secondRoot.right);
			}
		}
		return areEqual;
	}

	// using toString as a wrapper
	public String toString() {
		return toString(0);
	}

	private String toString(int depth) {
		String tree = "";
		if (left != null)
			// increasing the depth of sub tree
			tree = left.toString(depth + 1);
		String str = "";
		// Creating spaces according to sub tree's depth
		for (int i = 0; i < 2 * (depth); i++)
			str += " ";
		// Creating a string in order
		tree = tree + str + data.toString() + '\n';
		if (right != null)
			tree = tree + right.toString(depth + 1);
		return tree;
	}

}
