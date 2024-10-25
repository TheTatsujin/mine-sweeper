package operations;

import core.model.*;
import core.utils.BoardIntegrity;

public final class InitializeBoardCommand implements Command {
    private final Board board;
    private final GameSettings settings;

    public InitializeBoardCommand(Board board, GameSettings settings){
        this.board = board;
        this.settings = settings;
    }

    public void execute() {
        int mineNumber = randomNumber(settings.minNumberOfMines(), settings.maxNumberOfMines());
        for (int i = 0; i < mineNumber; i++) addHintsForMine(addMine(randomCoordinates()));
    }

    private Coordinate addMine(Coordinate coordinate) {
        // Current algorithm: probing
        // TODO: Replace with picking from a pool of empty cells

        CellLookup cells = this.board.cellLookup();
        if (cells.containsCell(coordinate) && !cells.getCell(coordinate).isMine()) addMine(randomCoordinates());
        cells.addCell(coordinate, new MineCellContent());
        return coordinate;
    }

    private void addHintsForMine(Coordinate mineCoordinate) {
        int[] guide = {-1, 0, 1};
        for (int dx: guide) {
            for (int dy: guide) {
                Coordinate newCell = new Coordinate(mineCoordinate.x() + dx, mineCoordinate.y() + dy);
                if (!(dx == 0 && dy == 0) && BoardIntegrity.isCoordianteValid(board, newCell)) addHint(newCell);
            }
        }
    }

    private void addHint(Coordinate hintCoordinate) {
        if (!board.cellLookup().containsCell(hintCoordinate)) {
            board.cellLookup().addCell(hintCoordinate, new HintCellContent());
            return;
        }
        CellContent content = board.cellLookup().getCell(hintCoordinate);
        if (content.isMine()) return;
        ((HintCellContent) content).updateHint();
    }

    private Coordinate randomCoordinates() {
        Coordinate bondaries = BoardIntegrity.getBoundaries(board);

        int x = randomNumber(0, bondaries.x());
        int y = randomNumber(0, bondaries.y());

        return new Coordinate(x, y);
    }

    private int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
