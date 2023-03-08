package e1;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BoardImpl implements Board {
    
    private final int boardSize;
    private Cell pawn = new CellImpl(0, 0);
    private final Random random = new Random();

    public BoardImpl(int size) {
        this.boardSize = size;
        this.pawn = randomEmptyPosition();
    }

    @Override
    public Cell randomEmptyPosition() {
        Cell pos = new CellImpl(this.random.nextInt(this.boardSize),this.random.nextInt(this.boardSize));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public Cell getPawn() {
        return this.pawn;
    }

    @Override
    public boolean isInsideBoard(int row, int col) {
        if (row<0 || col<0 || row >= this.boardSize || col >= this.boardSize) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    @Override
    public int size() {
        return this.boardSize;
    }

    @Override
    public boolean hasPawn(Integer x, Integer y) {
        return this.pawn.equals(new CellImpl(x, y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardImpl board = (BoardImpl) o;
        return boardSize == board.boardSize && Objects.equals(pawn, board.pawn) && Objects.equals(random, board.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardSize, pawn, random);
    }

    @Override
    public void setPawnPosition(Cell pawnPosition) {
        this.pawn = pawnPosition;
    }
}
