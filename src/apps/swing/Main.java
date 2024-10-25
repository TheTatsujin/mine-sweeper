
import core.graphics.DisplaySettings;
import core.model.*;
import operations.InitializeBoardCommand;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        Dimension dim = new Dimension(800, 600);
        DisplaySettings displaySettings = new DisplaySettings(dim);

        GameSettings gameSettings = new GameSettings(
                GameSettings.defaultDimension,
                GameSettings.defaultMinMineNumber,
                GameSettings.defaultMaxMineNumber
        );
        Game game = new Game(gameSettings);
        mainFrame.addCommand("initializeBoard", new InitializeBoardCommand(game.getBoard(), gameSettings));

        mainFrame.setVisible(true);

    }
}
