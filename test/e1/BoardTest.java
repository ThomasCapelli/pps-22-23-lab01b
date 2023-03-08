package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private static final int SIZE = 10;
    private static final Cell PAWN = new CellImpl(0, 0);
    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new BoardImpl(SIZE);
    }
    @Test
    void testBoardCreation() {
        assertEquals(SIZE, this.board.size());
    }
    @Test
    void testOutOfBoard() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.board.isInsideBoard(SIZE, SIZE));
    }
    @Test
    void testIsInsideBoard() {
        assertTrue(this.board.isInsideBoard(SIZE - 1, SIZE - 1));
    }
    @Test
    void testSetPawnPosition() {
        this.board.setPawnPosition(new CellImpl(PAWN.getX(), PAWN.getY()));
        assertTrue(this.board.hasPawn(PAWN.getX(), PAWN.getY()));
    }
    @Test
    void testGetPawn() {
        this.board.setPawnPosition(PAWN);
        assertEquals(PAWN, this.board.getPawn());
    }
}