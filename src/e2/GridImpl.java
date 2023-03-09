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
        if (mineNumber > 0) {
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
    public int getCellCount() {
        return this.grid.size();
    }

    @Override
    public boolean hasMine(Cell cell) {
        return this.grid.get(cell).equals(CellType.BOMB);
    }
}
