package e1;

public class CellImpl implements Cell {

    private Pair<Integer, Integer> cell;

    public CellImpl(int x, int y) {
        this.cell = new Pair<>(x, y);
    }

    @Override
    public void setCell(int x, int y) {
        this.cell = new Pair<>(x, y);
    }

    @Override
    public Pair<Integer, Integer> getCell() {
        return this.cell;
    }

    @Override
    public Integer getX() {
        return this.cell.getX();
    }

    @Override
    public Integer getY() {
        return this.cell.getY();
    }
}
