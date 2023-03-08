package e1;

public class KnightImpl implements Knight {

    private Cell position;

    public KnightImpl(Cell initialPosition) {
        this.position = initialPosition;
    }

    @Override
    public Cell getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Cell destination) {
        this.position = destination;
    }
}
