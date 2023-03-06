package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LogicsImplTest {

    public static final int SIZE = 10;
    public static final Pair<Integer, Integer> PAWN = new Pair<>(1, 2);
    public static final Pair<Integer, Integer> KNIGHT = new Pair<>(0, 0);
    private Logics logic;
    @BeforeEach
    void setUp() {
        this.logic = new LogicsImpl(PAWN, KNIGHT, SIZE);
    }
    @Test
    void testHasPawn() {
        assertTrue(this.logic.hasPawn(PAWN.getX(), PAWN.getY()));
    }
    @Test
    void testHasKnight() {
        assertTrue(this.logic.hasKnight(KNIGHT.getX(), KNIGHT.getY()));
    }
    @Test
    void testHitException() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-3, 4));
    }
    @Test
    void testNotHit() {
        assertFalse(this.logic.hit(1, 0));
    }
    @Test
    void testHit() {
        assertTrue(this.logic.hit(PAWN.getX(),PAWN.getY()));
    }
}