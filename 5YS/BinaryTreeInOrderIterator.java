
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeInOrderIterator<T> implements Iterator<T> {

	private final Stack<BinaryNode<T>> stack;

	public BinaryTreeInOrderIterator(BinaryNode<T> root) {
		stack = new StackAsDynamicArray<>();
		prepareNext(root);
	}

	@Override
	public boolean hasNext() {
		if (!stack.isEmpty())
			return true;
		else
			return false;
	}

	private void prepareNext(BinaryNode<T> node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	@Override
	public T next() {
		if (!stack.isEmpty()) {
			BinaryNode<T> node = stack.pop();
			prepareNext(node.right);
			return node.data;
		} else
			throw new NoSuchElementException();
	}

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

}
