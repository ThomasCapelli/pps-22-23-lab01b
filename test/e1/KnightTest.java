package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    private final Cell initialPosition = new CellImpl(0, 0);
    private final Cell destination = new CellImpl(4, 4);
    private Knight knight;
    @BeforeEach
    void setUp() {
        this.knight = new KnightImpl(initialPosition);
    }

    @Test
    void testInitialPosition() {
        assertEquals(initialPosition, this.knight.getPosition());
    }

    @Test
    void testSetPosition() {
        this.knight.setPosition(destination);
        assertEquals(destination, this.knight.getPosition());
    }
}