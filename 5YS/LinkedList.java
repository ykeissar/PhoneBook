
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    private Link<T> first;
    private Link<T> last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public void addFirst(T element) {
        nullCheck(element);
        if (isEmpty()) {
            first = new Link(element);
            last = first;
        } else {
            Link newFirst = new Link(element, first);
            first = newFirst;
        }
    }

    @Override
    public void add(T element) {
        nullCheck(element);
        if (isEmpty()) {
            first = new Link(element);
            last = first;
        } else {
            Link newLast = new Link(element);
            last.setNext(newLast);
            last = newLast;
        }
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        nullCheck(element);
        if (index == 0) {
            addFirst(element);
        } else {
            Link prev = null;
            Link curr = first;
            for (int i = 0; i < index; i = i + 1) {
                prev = curr;
                curr = curr.getNext();
            }
            Link toAdd = new Link(element, curr);
            prev.setNext(toAdd);
            if (index == size()) {
                last = toAdd;
            }
        }
    }

    @Override
    public int size() {
        int size = 0;
        Link curr = first;
        while (curr != null) {
            size = size + 1;
            curr = curr.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(T element) {
        for (Link curr = first; curr != null; curr = curr.getNext()) {
            if (element.equals(curr.getData())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        nullCheck(element);
        Link<T> curr = first;
        for (int i = 0; i < index; i = i + 1) {
            curr = curr.getNext();
        }
        T output = curr.getData();
        curr.setData(element);
        return output;
    }

    @Override
    public T get(int index) {
        Link<T> curr = first;
        for (int i = 0; i < index; i = i + 1) {
            curr = curr.getNext();
        }
        return curr.getData();
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T output = first.getData();
        first = first.getNext();
        return output;
    }

    public boolean remove(T element) {
        nullCheck(element);
        Link current = first;
        Link prev = current;
        boolean removed = false;
        while (current != null & !removed) {
            if (element.equals(current.getData())) {
                if (first == current) {
                    first = first.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                if (last == current) {
                    last = prev;
                }
                return true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String output = "[";
        Link current = first;
        while (current != null) {
            output = output + current.toString() + "\t";
            current = current.getNext();
        }
        return output.substring(0, output.length() - 1) + "]";
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    }

    private void nullCheck(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
    }
}
