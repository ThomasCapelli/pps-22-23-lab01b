package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    public static final Pair<Integer, Integer> INITIAL_POSITION = new Pair<>(0, 0);
    public static final Pair<Integer, Integer> DESTINATION = new Pair<>(4, 4);
    private Knight knight;
    @BeforeEach
    void setUp() {
        this.knight = new KnightImpl(INITIAL_POSITION);
    }

    @Test
    void testInitialPosition() {
        assertEquals(INITIAL_POSITION, this.knight.getPosition());
    }

    @Test
    void testSetPosition() {
        this.knight.setPosition(DESTINATION);
        assertEquals(DESTINATION, this.knight.getPosition());
    }
}