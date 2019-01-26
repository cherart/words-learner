package menu.controller;

import main.MainController;
import menu.view.MenuPanel;

import java.awt.*;
import java.sql.SQLException;

public class MenuController {

    private MainController mainController;

    public MenuController(MainController mainController) {
        this.mainController = mainController;
        start();
    }

    private void start() {
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.add(mainController.getSettingsController().getSettingsPanel());
        mainController.addPanel(menuPanel, "MenuPanel");

        CardLayout cardLayout = (CardLayout) mainController.getCardPanel().getLayout();

        menuPanel.getButtonStart().addActionListener(e -> {
            try {
                mainController.getGameController().start(mainController.getSettingsController().getSettings());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            cardLayout.show(mainController.getCardPanel(), "GamePanel");
        });
        menuPanel.getButtonStatistics().addActionListener(e -> {
        });
        menuPanel.getButtonMyVocabulary().addActionListener(e -> {
            cardLayout.show(mainController.getCardPanel(), "MyVocabularyPanel");
        });
    }
}
