package basics.model;

public class HintCellContent implements CellContent {
    private int surroundingMines;

    public HintCellContent() {
        this.surroundingMines = 1;
    }

    public int getHint() {
        return surroundingMines;
    }

    public void updateHint(){
        this.surroundingMines += 1;
    }

    @Override
    public boolean isMine() {
        return false;
    }

    @Override
    public String toString() {
        return "[" + this.surroundingMines + "]";
    }
}
