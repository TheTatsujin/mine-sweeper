package core.model;


public record GameSettings(Dimension boardDimensions, int minNumberOfMines, int maxNumberOfMines) {
    public static final Dimension defaultDimension = new Dimension(20, 10);
    public static final int defaultMinMineNumber = 4;
    public static final int defaultMaxMineNumber = 6;
}
