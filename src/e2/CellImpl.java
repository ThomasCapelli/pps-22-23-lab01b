package e2;

import e1.Pair;

import java.util.Objects;
import java.util.Set;

public class CellImpl implements Cell {

    private CellType cellType;
    private Pair<Integer, Integer> cell;

    public CellImpl(int x, int y) {
        this.cell = new Pair<>(x, y);
        this.cellType = CellType.EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellImpl cell1 = (CellImpl) o;
        return Objects.equals(cell, cell1.cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cell);
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

    @Override
    public Set<Cell> getAdjacentCells() {
        return null;
    }
}
