package tests;

import model.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionTest {

    Connection c;
    @BeforeEach
    void beforeEachTest() {
        c = new Connection ("N","S",10);
    }


    @Test
    void testGetFrom(){
        assertEquals("N",c.getFrom());
    }

    @Test
    void testGetTo(){
        assertEquals("S",c.getTo());
    }
    @Test
    void testSetFrom(){
        c.setFrom("E");
        assertEquals("E",c.getFrom());
    }

    @Test
    void testSetTo(){
        c.setTo("W");
        assertEquals("W", c.getTo());
    }

    @Test
    void testGetLength(){
        assertEquals(10, c.getLength());
    }
}
