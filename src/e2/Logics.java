package e2;

public interface Logics {

    void startGame();

    boolean hasMine(int row, int col);

    boolean isClicked(int row, int col);

    boolean hitCell(int row, int col);

    String getAdjacentMines(int row, int col);

    void expandGrid(int row, int col);
}
