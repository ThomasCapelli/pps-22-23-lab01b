package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LogicsImplTest {

    public static final int SIZE = 10;
    public static final Cell PAWN = new CellImpl(1, 2);
    public static final Knight KNIGHT = new KnightImpl(new CellImpl(0, 0));
    public static Board BOARD;
    private Logics logic;
    @BeforeEach
    void setUp() {
        BOARD = new BoardImpl(SIZE);
        this.logic = new LogicsImpl(KNIGHT, BOARD);
    }
    @Test
    void testHasPawn() {
        BOARD.setPawnPosition(PAWN);
        assertTrue(this.logic.hasPawn(PAWN.getX(), PAWN.getY()));
    }
    @Test
    void testHasKnight() {
        assertTrue(this.logic.hasKnight(KNIGHT.getPosition().getX(), KNIGHT.getPosition().getY()));
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
        BOARD.setPawnPosition(PAWN);
        assertTrue(this.logic.hit(PAWN.getX(), PAWN.getY()));
    }
}