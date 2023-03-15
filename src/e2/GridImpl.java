package e2;

import java.util.*;

public class GridImpl implements Grid {


    private final Random random = new Random();
    private final int boardSize;
    private final Map<Cell, CellType> grid = new HashMap<>();


    public GridImpl(int boardSize) {
        this.boardSize = boardSize;
        this.setUpGrid();
    }

    private void setUpGrid() {
        for (int row = 0; row < this.boardSize; row++) {
            for(int col = 0; col < this.boardSize; col++) {
                grid.put(new CellImpl(row, col), CellType.EMPTY);
            }
        }
    }

    @Override
    public int size() {
        return this.boardSize;
    }

    @Override
    public void setRandomMines(int mineNumber) {
        if (mineNumber > 0 && mineNumber < (this.boardSize * this.boardSize)) {
            if (this.grid.replace(new CellImpl(random.nextInt(this.boardSize), random.nextInt(this.boardSize)), CellType.EMPTY, CellType.BOMB)) {
                setRandomMines(mineNumber - 1);
            } else {
                setRandomMines(mineNumber);
            }
        }
    }

    @Override
    public int getMineCount() {
        return (int) this.grid.values().stream().filter(f -> f.equals(CellType.BOMB)).count();
    }

    @Override
    public boolean hasMine(Cell cell) {
        return this.grid.get(cell).equals(CellType.BOMB);
    }

    @Override
    public void setCellType(CellImpl cell, CellType cellType) {
        this.grid.replace(cell, cellType);
    }

    @Override
    public CellType getCellType(CellImpl cell) {
        return this.grid.get(cell);
    }

    @Override
    public int getAdjacentMinesCount(CellImpl cell) {
        int mineCounter = 0;
        for(int row = cell.getX() - 1; row <= cell.getX() + 1; row++) {
            if (row >= 0 && row < this.boardSize) {
                for (int col = cell.getY() - 1; col <= cell.getY() + 1; col++) {
                    if (col >= 0 && col < this.boardSize) {
                        if (this.grid.get(new CellImpl(row, col)).equals(CellType.BOMB)) {
                            mineCounter = mineCounter + 1;
                        }
                    }
                }
            }
        }
        return mineCounter;
    }

    @Override
    public void expandGrid(CellImpl cell) {
        for(int row = cell.getX() - 1; row <= cell.getX() + 1; row++) {
            if (row >= 0 && row < this.boardSize) {
                for (int col = cell.getY() - 1; col <= cell.getY() + 1; col++) {
                    if (col >= 0 && col < this.boardSize) {
                        if (this.getAdjacentMinesCount(new CellImpl(row, col)) == 0 && !this.grid.get(new CellImpl(row, col)).equals(CellType.CLICKED)) {
                            this.setCellType(new CellImpl(row, col), CellType.CLICKED);
                            this.expandGrid(new CellImpl(row, col));
                        } else if (!this.grid.get(new CellImpl(row, col)).equals(CellType.BOMB)){
                            this.setCellType(new CellImpl(row, col), CellType.CLICKED);
                        }
                    }
                }
            }
        }
    }

}
