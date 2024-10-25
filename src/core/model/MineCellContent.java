package basics.model;

public final class MineCellContent implements CellContent {
    public MineCellContent() {
    }

    @Override
    public boolean isMine() {
        return true;
    }

    @Override
    public String toString(){
        return "[Mine]";
    }
}
