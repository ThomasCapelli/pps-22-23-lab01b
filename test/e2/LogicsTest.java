package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    public static final int SIZE = 7;
    public static final int DEFAULT_ROW = 0;
    public static final int DEFAULT_COL = 0;
    private Logics logics;
    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(SIZE);
    }
    @Test
    void testHasMine() {
        assertFalse(this.logics.hasMine(DEFAULT_ROW, DEFAULT_COL));
    }
    @Test
    void testIsClicked() {
        assertTrue(this.logics.isClicked(DEFAULT_ROW, DEFAULT_COL));
    }
    @Test
    void testHitCell() {
        assertFalse(this.logics.hitCell(DEFAULT_ROW, DEFAULT_COL));
    }
    @Test
    void testAdjacentMines() {
        assertEquals("0", this.logics.getAdjacentMines(DEFAULT_ROW, DEFAULT_COL));
    }
    @Test
    void testExpandGrid() {
        this.logics.expandGrid(DEFAULT_ROW, DEFAULT_COL);
    }
}