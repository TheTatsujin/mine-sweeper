package basics.model;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private final Board board;
    private final List<GameState> states;
    private GameState currentState;


    public Game(GameSettings settings) {
        this.states = new ArrayList<>();
        this.board = new Board(settings.getDimension(), new CellLookup());
    }

    public Board getBoard() {
        return this.board;
    }

    public void start(){
        this.currentState = new GameState();
        this.states.add(this.currentState);
    }

    /**
     * @param cellCoordinate Cell chosen by the player
     * @return True if player Lost
     */
    public boolean makeMove(Coordinate cellCoordinate){
        if(currentState.isCellRevealed(cellCoordinate)) return false;
        this.states.add(this.currentState.next(cellCoordinate));
        if (this.board.cellLookup().containsCell(cellCoordinate)) {
            return this.board.cellLookup().getCell(cellCoordinate).isMine();
        }
        return true;
    }

    public GameSettings getSettings() {
        return new GameSettings();
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public List<GameState> getStates() {
        return states;
    }
}
