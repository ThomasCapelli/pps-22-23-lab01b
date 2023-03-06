package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    public static final Pair<Integer, Integer> DESTINATION_CELL = new Pair<>(4, 4);
    public static final Pair<Integer, Integer> INITIAL_CELL = new Pair<>(0, 0);
    private Cell cell;
    @BeforeEach
    void setUp() {
        this.cell = new CellImpl(INITIAL_CELL.getX(), INITIAL_CELL.getY());
    }
    @Test
    void testGetCell() {
        assertEquals(INITIAL_CELL, this.cell.getCell());
    }
    @Test
    void testSetCell() {
        this.cell.setCell(DESTINATION_CELL.getX(), DESTINATION_CELL.getY());
        assertEquals(this.cell.getCell(), DESTINATION_CELL);
    }
    @Test
    void testGetX() {
        this.cell.setCell(DESTINATION_CELL.getX(), DESTINATION_CELL.getY());
        assertEquals(DESTINATION_CELL.getX(), this.cell.getX());
    }
    @Test
    void testGetY() {
        this.cell.setCell(DESTINATION_CELL.getX(), DESTINATION_CELL.getY());
        assertEquals(DESTINATION_CELL.getY(), this.cell.getY());
    }
}