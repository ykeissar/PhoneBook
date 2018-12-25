
import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchNode<T> extends BinaryNode<T> {

	private final Comparator<T> treeComparator;

	public BinarySearchNode(T data, Comparator<T> myComparator) {
		super(data);
		this.treeComparator = myComparator;
	}

	// assume otherTreeRoot.size()>0
	public BinarySearchNode(BinarySearchNode<T> otherTreeRoot, Iterator<T> otherTreeIterator) {
		super(null);
		treeComparator = otherTreeRoot.getComparator();
		buildPerfectTree(otherTreeRoot.size());
		fillTheNodes(this, otherTreeIterator);
	}

	// element is an Entry with one "dummy" field
	public T findData(T element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (treeComparator.compare(data, element) > 0) {
			if (left != null) {
				return ((BinarySearchNode<T>) left).findData(element);
			} else {
				return null;
			}
		} else if (treeComparator.compare(data, element) < 0) {
			if (right != null) {
				return ((BinarySearchNode<T>) right).findData(element);
			} else {
				return null;
			}
		} else {
			return this.data;
		}
	}

	public T findMin() {
		BinaryNode<T> currNode = this;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.data;
	}

	// Complete the following methods:
	private void buildPerfectTree(int size) {
		// create a dummy tree: perfect tree with size nodes
		// create a queue and enqueue the first node
		Queue<BinarySearchNode<T>> q = new QueueAsLinkedList();
		q.enqueue(this);
		while (this.size() < size) {
			BinarySearchNode<T> nextNode = q.dequeue();
			BinarySearchNode<T> leftDummyNode = new BinarySearchNode<T>(null, treeComparator);
			nextNode.left = leftDummyNode;
			q.enqueue(leftDummyNode);
			if (this.size() < size) {
				nextNode.right = new BinarySearchNode<>(null, treeComparator);
				q.enqueue((BinarySearchNode<T>) nextNode.right);
			}
		}
	}

	private void fillTheNodes(BinarySearchNode<T> root, Iterator<T> treeIterator) {
		// Creating empty nodes in order.
		if (root.left != null)
			fillTheNodes((BinarySearchNode<T>) root.left, treeIterator);
		// Placing data inOrder.
		if (treeIterator.hasNext())
			root.data = treeIterator.next();
		if (root.right != null)
			fillTheNodes((BinarySearchNode<T>) root.right, treeIterator);
	}

	public Comparator<T> getComparator() {
		return treeComparator;
	}

	@Override
	public void insert(T toInsert) {
		if (!contains(toInsert))
			insertElement(toInsert);

	}

	public void insertElement(T toInsert) {
		if (treeComparator.compare(toInsert, data) < 0) {
			if (left == null)
				left = new BinarySearchNode<T>(toInsert, treeComparator);
			else
				((BinarySearchNode<T>) left).insertElement(toInsert);
		} else {
			if (right == null)
				right = new BinarySearchNode<T>(toInsert, treeComparator);
			else
				((BinarySearchNode<T>) right).insertElement(toInsert);
		}
	}

	@Override
	public boolean contains(T element) {
		if (element == null)
			throw new NullPointerException();
		else {
			if (treeComparator.compare(element, data) == 0)
				return true;
			if (treeComparator.compare(element, data) < 0) {
				if (left != null)
					return left.contains(element);
				else
					return false;
			}
			if (right != null)
				return right.contains(element);
			else
				return false;
		}
	}

	public BinaryNode<T> remove(T toRemove) {
		BinaryNode<T> me = this;
		// Searching for node
		if (me.left != null && treeComparator.compare(toRemove, me.data) < 0)
			me.left = ((BinarySearchNode<T>) me.left).remove(toRemove);
		if (me.right != null && treeComparator.compare(toRemove, me.data) > 0)
			me.right = ((BinarySearchNode<T>) me.right).remove(toRemove);
		// Node has been found
		if (treeComparator.compare(toRemove, me.data) == 0) {
			// Node is a leaf
			if (me.left == null && me.right == null)
				return null;
			// Node has one left son
			if (me.left != null && me.right == null)
				// returning the rest of the tree
				return me.left;
			// Node has one right son
			if (me.left == null && me.right != null)
				// returning the rest of the tree
				return me.right;
			// Node has two sons
			if (me.left != null && me.right != null) {
				// Taking the smallest node in the tree that is greater than the node that is
				// being
				// removed - hence the most left leaf in it's right sub-tree
				BinaryNode<T> tmpTree = me.right; // one Right
				BinaryNode<T> mostLeft = tmpTree.left; // most left
				while (mostLeft != null) {
					// mostLeft is the node i'm seeking for
					if (mostLeft.left == null) {
						// Replacing data
						me.data = mostLeft.data;
						// Unlinking the most left leaf from it's parent
						tmpTree.left = null;
						return me;
					}
					tmpTree = mostLeft;
					mostLeft = mostLeft.left;
				}
				// When right sub-tree doesn't have a left sub-tree
				tmpTree.left = me.left;
				me = tmpTree;
			}
		}
		return me;

	}

}
