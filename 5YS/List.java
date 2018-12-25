
public interface List<T> {

    // returns the number of elements in the list
    public int size();

    // returns true if the list is empty
    public boolean isEmpty();

    // Returns true if this list contains the specified element.
    public boolean contains(T element);

    // Replaces the element at the specified position in this list with the specified element.
    public T set(int index, T element);

    // Returns the element at the specified position in this list.
    public T get(int index);

    // Appends the specified element to the end of this list.
    public void add(T element);

    // Inserts the specified element at the specified position in this list.
    public void add(int index, T element);
}
