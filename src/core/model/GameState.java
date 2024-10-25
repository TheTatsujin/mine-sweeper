package basics.model;

import java.util.ArrayList;
import java.util.List;

public final class GameState {
    private final List<Coordinate> revealedCells;


    public GameState() {
        this.revealedCells = new ArrayList<>();
    }

    private GameState(List<Coordinate> revealedCells) {
        this.revealedCells = revealedCells;
    }

    private List<Coordinate> newMove(List<Coordinate> moves, Coordinate coordinate) {
        moves.add(coordinate);
        return moves;
    }

    public boolean isCellRevealed(Coordinate coordinate) {
        return revealedCells.contains(coordinate);
    }

    public GameState next(Coordinate newCoordinate) {
        return new GameState(this.newMove(this.revealedCells, newCoordinate));
    }
}
