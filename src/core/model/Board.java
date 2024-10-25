package basics.model;

/**
 * @param size Dimensions in Cells x Cells
 * @param cellLookup Cells that contain mines or hints
 */
public record Board(Dimension size, CellLookup cellLookup) {
}
