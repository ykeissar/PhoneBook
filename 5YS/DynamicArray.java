
import java.util.NoSuchElementException;

public class DynamicArray<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 16;
    private T[] data;
    private int size;
    private int incrementSize;

    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        data = (T[]) new Object[initialCapacity];
        incrementSize = initialCapacity;
        size = 0;
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public String toString() {
        String output = "";
        for (int index = 0; index < size(); index = index + 1) {
            if ((index + 1) % 20 == 0) {
                output = output + "\n";
            }
            output = output + get(index) + "\t";
        }
        return output;
    }

    @Override
    public boolean equals(Object other) {
        boolean isEqual = true;
        if (!(other instanceof DynamicArray)) {
            isEqual = false;
        } else {
            DynamicArray otherDA = (DynamicArray) other;
            if (size() != otherDA.size()) {
                isEqual = false;
            } else {
                for (int index = 0; index < size() & isEqual; index = index + 1) {
                    isEqual = get(index).equals(otherDA.get(index));
                }
            }
        }
        return isEqual;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        dataCheck(element);
        T tmp = get(index);
        data[index] = element;
        return tmp;
    }

    @Override
    public void add(T element) {
        dataCheck(element);
        data[size] = element;
        size = size + 1;
        ensureCapacity(size);
    }

    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        dataCheck(element);
        for (int i = size() - 1; i >= index; i = i - 1) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size = size + 1;
        ensureCapacity(size);
    }

    // remove and return the last element in this array
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T output = data[size() - 1];
        data[size() - 1] = null;
        size = size - 1;
        return output;
    }

    public boolean remove(Object element) {
        boolean found = false;
        int i;
        for (i = 0; i < size() & !found; i = i + 1) {
            if (data[i].equals(element)) {
                found = true;
            }
        }
        if (found) {
            for (; i < size(); i = i + 1) {
                data[i - 1] = data[i];
            }
            size = size - 1;
            return true;
        }
        return false;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= data.length) {
            T[] newData = (T[]) new Object[data.length + incrementSize];
            for (int i = 0; i < data.length; i = i + 1) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    }

    private void dataCheck(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean contains(Object element) {
        boolean output = false;
        for (int i = 0; (i < size()) && (!output); i = i + 1) {
            if (get(i).equals(element)) {
                output = true;
            }
        }
        return output;
    }
}
