package e1;

public class KnightImpl implements Knight {

    private Pair<Integer, Integer> position;

    public KnightImpl(Pair<Integer, Integer> initialPosition) {
        this.position = initialPosition;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> destination) {
        this.position = destination;
    }
}
