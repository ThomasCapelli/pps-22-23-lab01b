package e1;

import java.util.*;

public class LogicsImpl implements Logics {

	private final Board board;
	private Knight knight = new KnightImpl(new CellImpl(0, 0));

	public LogicsImpl(final Knight knight, final Board board) {
		this.knight = knight;
		this.board = board;
	}
	 
    public LogicsImpl(int size){
		this.board = new BoardImpl(size);
        this.knight.setPosition(board.randomEmptyPosition());
    }
    
	@Override
	public boolean hit(int row, int col) {
		this.board.isInsideBoard(row, col);
		// Below a compact way to express allowed moves for the knight
		Cell knightPosition = this.knight.getPosition();
		int x = row - knightPosition.getX();
		int y = col - knightPosition.getY();
		if (x != 0 && y != 0
				&& Math.abs(x)+Math.abs(y)==3) {
			this.knight.setPosition(new CellImpl(row,col));
			return this.knight.getPosition().equals(this.board.getPawn());
		}
		return false;
	}
	@Override
	public boolean hasKnight(Integer row, Integer col) {
		return this.knight.getPosition().equals(new CellImpl(row, col));
	}
	@Override
	public boolean hasPawn(int row, int col) {
		return this.board.getPawn().equals(new CellImpl(row, col));
	}

}
