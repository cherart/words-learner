package main;

import game.controller.GameController;
import menu.controller.MenuController;
import menu.controller.SettingsController;
import myvocabulary.model.Word;
import myvocabulary.model.WordDaoImpl;
import myvocabulary.controller.MyVocabularyController;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    private JPanel cardPanel;
    private WordDaoImpl wordDao;

    private MenuController menuController;
    private SettingsController settingsController;
    private GameController gameController;
    private MyVocabularyController myVocabularyController;

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.start();
    }

    private void start() {
        try {
            initDatabase();
            initFrame();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initDatabase() throws SQLException, ClassNotFoundException {
        wordDao = new WordDaoImpl();
    }

    private void initFrame() throws SQLException {
        JFrame frame = new JFrame("Words Learner");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardPanel = new JPanel(new CardLayout());
        frame.add(cardPanel);

        settingsController = new SettingsController(this);
        gameController = new GameController(this);
        menuController = new MenuController(this);
        myVocabularyController = new MyVocabularyController(this);

        frame.setVisible(true);
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public WordDaoImpl getWordDao() {
        return wordDao;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public SettingsController getSettingsController() {
        return settingsController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public MyVocabularyController getMyVocabularyController() {
        return myVocabularyController;
    }

    public java.util.List<String[]> getStringArrayWords() throws SQLException {
        List<String[]> words = new ArrayList<>();
        for (Word word : wordDao.getAllWords()) {
            words.add(new String[]{
                    Integer.toString(word.getId()),
                    word.getEnglishTranslate(),
                    word.getRussianTranslate()});
        }
        return words;
    }

    public void addPanel(Component panel, String name) {
        cardPanel.add(panel, name);
    }
}