package basics.model;


public record Coordinate(int x, int y) implements Comparable<Coordinate> {
    @Override
    public int compareTo(Coordinate other) {
        if (this.y != other.y()) return this.y() - other.y();
        if (this.x != other.x()) return this.x() - other.x();
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate other) {
            return x == other.x()
                    && y == other.y();
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Cantor pairing function:
     *  1:1 Mapping
     *  Non-Commutative
     * @return Unique value for each coordinate
     */
    @Override
    public int hashCode() {
        int addition = this.x + this.y;
        int numerator = addition * (addition + 1);

        return (numerator >> 1) + this.y;
    }
}
