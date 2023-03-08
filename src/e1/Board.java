package e1;

public interface Board {
    boolean isInsideBoard(int row, int col);

    int size();

    boolean hasPawn(Integer x, Integer y);

    void setPawnPosition(Cell pawnPosition);

    Cell randomEmptyPosition();

    Cell getPawn();
}
