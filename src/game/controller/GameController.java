package game.controller;

import game.view.GamePanel;
import main.MainController;
import menu.model.Settings;
import myvocabulary.model.Word;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;


public class GameController {

    private int counter;
    private GamePanel gamePanel;

    private MainController mainController;

    public GameController(MainController mainController) {
        this.mainController = mainController;
    }

    public void start(Settings settings) throws SQLException {
        gamePanel = new GamePanel();
        mainController.addPanel(gamePanel, "GamePanel");
        List<Word> words = mainController.getWordDao().getAllWords();
        counter = Integer.parseInt(settings.getStartIndex());

        gamePanel.getLabelWord().setText(words.get(counter).getEnglishTranslate());
        gamePanel.getButtonNext().addActionListener(e -> {
            counter++;
            if (counter != Integer.parseInt(settings.getLastIndex()))
                gamePanel.getLabelWord().setText(words.get(counter).getEnglishTranslate());
            else
                gamePanel.getLabelWord().setText("End");
        });

        CardLayout cardLayout = (CardLayout) mainController.getCardPanel().getLayout();
        gamePanel.getButtonExit().
                addActionListener(e -> cardLayout.show(mainController.getCardPanel(), "MenuPanel"));
    }
}
