package e2;

import e1.Cell;
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
    @Test
    void testSetCellType() {
        this.grid.setCellType(new CellImpl(0, 0), CellType.CLICKED);
        assertEquals(CellType.CLICKED,this.grid.getCellType(new CellImpl(0,0)));
    }
    @Test
    void testAdjacentMines() {
        assertEquals(0, this.grid.getAdjacentMinesCount(new CellImpl(0, 0)));
    }
    @Test
    void testExpandGrid() {
        this.grid.expandGrid(new CellImpl(0, 0));
    }
}