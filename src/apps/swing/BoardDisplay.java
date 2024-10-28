package core.graphics;

import core.model.*;
import core.model.Dimension;
import core.utils.GraphicAdapter;


import java.awt.*;

public class BoardPainter extends Canvas {
    private final Dimension cellPixelDimension;
    private final Board board;


    public BoardPainter(Board board, Dimension screenSize) {
        this.board = board;
        this.cellPixelDimension = GraphicAdapter.getCellPixelDimension(screenSize, board.size());
    }

    public void paint(Graphics g) {
        System.out.println("Painting ...");
        setBackground(Color.lightGray);
        paintGrid(g);
        fillCells(g);
    }


    private void paintGrid(Graphics g) {
        for (int x = 0; x < board.size().width(); x++) g.drawLine(x, 0, x, board.size().height() - 1);
        for (int y = 0; y < board.size().height(); y++) g.drawLine(0, y, board.size().width() - 1, y);
    }

    private void fillCells(Graphics g) {
        for (Coordinate cellCoord : board.cellLookup().getCells()) {
            Coordinate point = GraphicAdapter.coordinateToPoint(cellCoord, cellPixelDimension);
            CellContent c = board.cellLookup().getCell(cellCoord);

            if (c.isMine()) paintMine(g, point);
            else paintHint(g, point, c.toString());
        }
    }

    private void paintMine(Graphics g, Coordinate point) {
        g.drawOval(point.x(), point.y(), 60, 60);
    }

    private void paintHint(Graphics g, Coordinate point, String hint) {
        g.drawString(hint, point.x(), point.y());
    }

}
