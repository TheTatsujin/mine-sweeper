package basics.model;

import java.util.SortedMap;
import java.util.TreeMap;

public final class CellLookup {
    private final SortedMap<Coordinate, CellContent> cells;

    public CellLookup() {
        this.cells = new TreeMap<Coordinate, CellContent>();
    }

    public void addCell(Coordinate coordinate, CellContent cellContent) {
        this.cells.put(coordinate, cellContent);
    }

    public boolean containsCell(Coordinate coordinate) {
        return this.cells.containsKey(coordinate);
    }

    public int getSize() {
        return this.cells.size();
    }

    public CellContent getCell(Coordinate coordinate) {
        return this.cells.get(coordinate);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Cells = [\n");
        for (Coordinate coordinate : cells.keySet()) {
            result.
                    append(coordinate.toString()).
                    append(": ").
                    append(cells.get(coordinate).toString()).
                    append(",\n");
        }
        result.deleteCharAt(result.length() - 2);
        result.append("]");
        return result.toString();
    }
}
