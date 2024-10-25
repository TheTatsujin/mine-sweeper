package basics.model;

public record Dimension(int width, int height) {
    public Dimension scale(double widthFactor, double heightFactor) {
        return new Dimension((int) (this.width * widthFactor), (int) (this.height * heightFactor));
    }
}
