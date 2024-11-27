package ch.heigvd.poo.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class ElementTest {

    @Test
    public void testElementConstructor() {
        Element<Integer> element = new Element<>(5);
        assertNotNull(element);
        assertEquals(5, element.getValue());
        assertNull(element.getNext());
    }

    @Test
    public void testGetValue() {
        Element<String> element = new Element<>("test");
        assertEquals("test", element.getValue());
    }

    @Test
    public void testSetNext() {
        Element<Integer> element1 = new Element<>(1);
        Element<Integer> element2 = new Element<>(2);
        element1.setNext(element2);
        assertEquals(element2, element1.getNext());
    }

    @Test
    public void testGetNext() {
        Element<Double> element1 = new Element<>(1.1);
        Element<Double> element2 = new Element<>(2.2);
        element1.setNext(element2);
        assertEquals(element2, element1.getNext());
    }
}
