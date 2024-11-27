package ch.heigvd.poo.util;

/**
 * @author Marcuard Adrien, Perret Jonatan 
 * A simple stack implementation using a singly linked list.
 *
 * @param <T> the type of elements in this stack
 */
public class SimpleStack<T> {

    private Element<T> head;
    private int size = 0;

    /**
     * Creates a new empty stack.
     */
    public SimpleStack() {
        head = new Element<T>(null);
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param value the value to be pushed onto the stack
     */
    public void push(T value) {
        Element<T> el = new Element<>(value);

        el.setNext(head.getNext());
        head.setNext(el);
        size++;
    }

    /**
     * Returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        T el = head.getNext().getValue();
        head.setNext(head.getNext().getNext());
        size--;
        return el;
    }

    /**
     * Returns an iterator over elements of type {@code T} in this stack.
     *
     * @return a {@code SimpleStackIterator<T>} over the elements in this stack
     */
    public SimpleStackIterator<T> iterator() {
        return new SimpleStackIterator<T>(head);
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public Boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * Returns a string representation of the stack. The string representation
     * consists of a list of the stack's elements in the order they are returned
     * by its iterator, enclosed in square brackets ("[]"). Adjacent elements
     * are separated by the characters ", " (comma and space).
     *
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        SimpleStackIterator<T> it = iterator();

        while (it.hasNext()) {
            str.append(it.next());
            str.append(it.hasNext() ? ", " : "");
        }

        str.append("]");

        return str.toString().trim();
    }

    /**
     * Converts the elements in the stack to an array.
     *
     * @return an array containing all the elements in the stack
     */
    public Object[] toArray() {
        java.util.LinkedList<T> list = new java.util.LinkedList<>();
        SimpleStackIterator<T> it = iterator();

        while (it.hasNext()) {
            list.add(it.next());
        }

        return list.toArray();
    }
}
