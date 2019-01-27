package game.controller;

import game.view.GamePanel;
import main.MainController;
import menu.model.Settings;
import myvocabulary.model.Word;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.List;


public class GameController {

    private int counter = -1;
    private String checkedWord = "";
    private List<Word> words;
    private GamePanel gamePanel;
    private MainController mainController;

    public GameController(MainController mainController) {
        this.mainController = mainController;
    }

    public void start(Settings settings) throws SQLException {
        startPanel(settings);
        initWords(settings);
        initActionListeners(settings);
    }

    private void startPanel(Settings settings) {
        gamePanel = new GamePanel();
        gamePanel.onCreate(settings.getMode());
        mainController.addPanel(gamePanel, "GamePanel");
    }

    private void initWords(Settings settings) throws SQLException {
        words = mainController.getWordDao().getAllWords();
        words.subList(Integer.parseInt(settings.getStartIndex()), Integer.parseInt(settings.getLastIndex()));
        counter = Integer.parseInt(settings.getStartIndex());
    }

    private void initActionListeners(Settings settings) {
        CardLayout cardLayout = (CardLayout) mainController.getCardPanel().getLayout();

        count(settings);
        getNextWord(settings);

        gamePanel.getButtonNext().addActionListener(e -> {
            getNextWord(settings);
            count(settings);
        });

        gamePanel.getButtonPrevious().addActionListener(e -> {
            getPreviousWord(settings);
            count(settings);
        });

        gamePanel.getButtonSubmit().addActionListener(e -> {
            checkWord(settings);
        });

        gamePanel.getButtonExit().addActionListener(e -> {
            cardLayout.show(mainController.getCardPanel(), "MenuPanel");
        });

        if (settings.getMode().equals("Test")) {

        } else {
            gamePanel.getTextField().addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    gamePanel.getLabelResult().setText("");
                }

                @Override
                public void focusLost(FocusEvent e) {
                    checkedWord = gamePanel.getTextField().getText();
                }
            });
        }
    }

    private void count(Settings settings) {
        gamePanel.getLabelCounter().setText(counter + "/" + settings.getLastIndex());
    }

    private void getNextWord(Settings settings) {
        counter++;
        if (settings.getLanguage().equals("English"))
            gamePanel.getLabelWord().setText(words.get(counter).getEnglishTranslate());
        else
            gamePanel.getLabelWord().setText(words.get(counter).getRussianTranslate());
    }

    private void getPreviousWord(Settings settings) {
        counter--;
        if (settings.getLanguage().equals("English"))
            gamePanel.getLabelWord().setText(words.get(counter).getEnglishTranslate());
        else
            gamePanel.getLabelWord().setText(words.get(counter).getRussianTranslate());
    }

    private void checkWord(Settings settings) {
        String answerWord;
        if (settings.getLanguage().equals("English"))
            answerWord = words.get(counter).getRussianTranslate();
        else
            answerWord = words.get(counter).getEnglishTranslate();
        if (answerWord.equals(checkedWord)) {
            gamePanel.getLabelResult().setText("Right");
            gamePanel.getLabelResult().setForeground(Color.green);
        } else {
            gamePanel.getLabelResult().setText("Wrong");
            gamePanel.getLabelResult().setForeground(Color.red);
        }
    }
}
