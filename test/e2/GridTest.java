package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GridTest {

    public static final int BOARD_SIZE = 10;
    public static final int MINE_NUMBER = 3;
    private Grid grid;


    @BeforeEach
    void setUp() {
        this.grid = new GridImpl(BOARD_SIZE);
    }
    @Test
    void testSize() {
        assertEquals(BOARD_SIZE, this.grid.size());
        assertEquals(BOARD_SIZE * BOARD_SIZE, this.grid.getCellCount());
    }

    @Test
    void testSetRandomMines() {
        this.grid.setRandomMines(MINE_NUMBER);
        assertEquals(MINE_NUMBER, this.grid.getMineCount());
    }
    @Test
    void testHasMine() {
        assertFalse(this.grid.hasMine(new CellImpl(0, 0)));
    }
}