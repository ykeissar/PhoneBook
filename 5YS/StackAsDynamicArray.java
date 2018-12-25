
import java.util.NoSuchElementException;

public class StackAsDynamicArray<T> implements Stack<T> {

    private final DynamicArray<T> array;

    public StackAsDynamicArray() {
        this.array = new DynamicArray();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array.remove();
    }

    @Override
    public void push(T element) {
        array.add(element);
    }
}
