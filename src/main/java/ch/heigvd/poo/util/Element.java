package ch.heigvd.poo.util;

/**
 * @author Marcuard Adrien, Perret Jonatan
 * A generic class representing an element in a sequence.
 *
 * @param <T> the type of the value stored in this element
 */
public class Element<T> {

    private T value;
    private Element<T> next;

    /**
     * Constructs an Element with the specified value.
     *
     * @param value the value to be stored in this Element
     */
    public Element(T value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Returns the value of this element.
     *
     * @return the value of type T
     */
    public T getValue() {
        return value;
    }

    /**
     * Returns the next element in the sequence.
     *
     * @return the next element of type T, or null if there is no next element
     */
    public Element<T> getNext() {
        return next;
    }

    /**
     * Sets the next element in the sequence.
     *
     * @param next the next element to be set
     */
    public void setNext(Element<T> next) {
        this.next = next;
    }

}
