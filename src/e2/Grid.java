package e2;

public interface Grid {
    int size();

    void setRandomMines(int mineNumber);

    int getMineCount();

    int getCellCount();

    boolean hasMine(Cell cell);
}
