package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {

    public static final Cell DESTINATION_CELL = new CellImpl(4, 4);
    public static final Cell INITIAL_CELL = new CellImpl(0, 0);
    private Cell cell;
    @BeforeEach
    void setUp() {
        this.cell = new CellImpl(INITIAL_CELL.getX(), INITIAL_CELL.getY());
    }
    @Test
    void testGetCell() {
        assertEquals(INITIAL_CELL, this.cell);
    }
    @Test
    void testSetCell() {
        this.cell.setCell(DESTINATION_CELL.getX(), DESTINATION_CELL.getY());
        assertEquals(this.cell, DESTINATION_CELL);
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