package basics.model;


public final class GameSettings implements Settings {
    private static final Dimension defaultDimension = new Dimension(20, 10);
    private static final int minMineNumber = 4;
    private static final int maxMineNumber = 6;

    private Dimension dimension;
    private int minMine;
    private int maxMine;

    @Override
    public void loadDefault() {
        this.dimension = defaultDimension;
        this.minMine = minMineNumber;
        this.maxMine = maxMineNumber;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public int getMinMine() {
        return minMine;
    }

    public int getMaxMine() {
        return maxMine;
    }
}
