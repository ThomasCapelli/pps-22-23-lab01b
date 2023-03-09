package e2;

import e1.Pair;

import java.util.Set;

public interface Cell {
    void setCell(int x, int y);

    Pair<Integer, Integer> getCell();

    Integer getX();

    Integer getY();

    Set<Cell> getAdjacentCells();

}
