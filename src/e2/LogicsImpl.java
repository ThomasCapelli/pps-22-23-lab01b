package e2;

public class LogicsImpl implements Logics {

    public static final int MINE_NUMBER = 10;
    private final Grid grid;

    public LogicsImpl(int size) {
        this.grid = new GridImpl(size);
    }
    @Override
    public void startGame() {
        this.grid.setRandomMines(MINE_NUMBER);
    }

    @Override
    public boolean hasMine(int row, int col) {
        return this.grid.hasMine(new CellImpl(row, col));
    }

    @Override
    public boolean isClicked(int row, int col) {
        return this.grid.getCellType(new CellImpl(row, col)).equals(CellType.CLICKED);
    }

    @Override
    public boolean hitCell(int row, int col) {
        if (!this.hasMine(row, col)) {
            this.grid.setCellType(new CellImpl(row, col), CellType.CLICKED);
            if (this.grid.getAdjacentMinesCount(new CellImpl(row, col)) == 0) {
                this.expandGrid(row, col);
            }
            return false;
        }
        return true;
    }

    @Override
    public String getAdjacentMines(int row, int col) {
        return Integer.toString(this.grid.getAdjacentMinesCount(new CellImpl(row, col)));
    }

    @Override
    public void expandGrid(int row, int col) {
        this.grid.expandGrid(new CellImpl(row, col));
    }


}
