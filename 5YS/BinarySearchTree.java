
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T> extends BinaryTree<T> implements Iterable<T> {

	private final Comparator<T> treeComparator;

	// This constructor builds an empty tree
	public BinarySearchTree(Comparator<T> myComparator) {
		super();
		this.treeComparator = myComparator;
	}

	// This constructor is a copy-constructor
	// it creates a perfect tree with the same data as in otherTree
	public BinarySearchTree(BinarySearchTree<T> otherTree) {
		super();
		this.treeComparator = otherTree.getComparator();
		if (!otherTree.isEmpty()) {
			root = new BinarySearchNode<>((BinarySearchNode<T>) otherTree.root, otherTree.iterator());
		}
	}

	public T findData(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			return null;
		}
		return ((BinarySearchNode<T>) root).findData(element);
	}

	public Comparator getComparator() {
		return treeComparator;
	}

	@Override
	public void insert(T toInsert) {
		if (toInsert == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			root = new BinarySearchNode<>(toInsert, treeComparator);
		} else {
			root.insert(toInsert);
		}
	}

	public void remove(T toRemove) {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		root = ((BinarySearchNode<T>) root).remove(toRemove);
	}

	@Override
	public Iterator<T> iterator() {
		return new BinaryTreeInOrderIterator<>(root);
	}
}
