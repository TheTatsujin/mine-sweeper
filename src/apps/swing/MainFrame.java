
import core.graphics.DisplaySettings;
import core.model.Board;
import core.model.Dimension;
import operations.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final DisplaySettings displaySettings;
    public MainFrame() {
        this.commands = new HashMap<>();

        // Initialize Display Window
        this.setTitle("Minesweeper");
        int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.5);
        int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.75);


        this.displaySettings = newDisplaySettings(width, height);
        this.setSize(displaySettings.displayDimensions().width(), displaySettings.displayDimensions().height());
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(optionMenu(), BorderLayout.CENTER);
    }

    private DisplaySettings newDisplaySettings(int width, int height) {
        Dimension screenSize = new Dimension(width, height);
        Dimension boardSize = screenSize.scale(0.5, 0.5);
        Dimension cellSize = boardSize.scale(0.5, 0.5);

        return new DisplaySettings(screenSize);
    }
    private JPanel optionMenu() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(button("Start"));
        return panel;
    }

    private Component button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(e -> commands.get("initializeBoard").execute());
        return button;
    }

    private JPanel game(Board board) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        return panel;
    }

    public void addCommand(String name, Command command) {
        this.commands.put(name, command);
    }
}
