package ch.heigvd.poo.util;

/**
 * @author Marcuard Adrien, Perret Jonatan
 * A SimpleStackIterator is an iterator for a stack data structure.
 * It allows for iterating over the elements of the stack starting from a specified head element.
 *
 * @param <T> the type of elements in the stack
 */
public class SimpleStackIterator<T> {

    Element<T> current;

    /**
     * Constructs a SimpleStackIterator with the specified head element.
     *
     * @param head the head element of the stack to start the iteration from
     */
    public SimpleStackIterator(Element<T> head) {
        current = head;
    }

    /**
     * Checks if there is a next element in the stack.
     *
     * @return true if there is a next element, false otherwise
     */
    public boolean hasNext() {
        return current.getNext() != null;
    }

    /**
     * Returns the next element in the iteration.
     * If there is no next element, returns null.
     *
     * @return the next element in the iteration, or null if there is no next element
     */
    public T next() {
        // if there is no next element, return null
        if (current.getNext() == null) {
            return null;
        }
        current = current.getNext();
        return current.getValue();
    }
}
