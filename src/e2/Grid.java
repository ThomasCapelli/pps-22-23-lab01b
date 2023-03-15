package e2;

public interface Grid {
    int size();

    void setRandomMines(int mineNumber);

    int getMineCount();

    boolean hasMine(Cell cell);

    void setCellType(CellImpl cell, CellType cellType);

    CellType getCellType(CellImpl cell);

    int getAdjacentMinesCount(CellImpl cell);

    void expandGrid(CellImpl cell);
}
