package game.controller;

import game.view.GamePanel;
import main.MainController;

public class GameController {

    private GamePanel gamePanel;

    public GameController(MainController mainController) {
        gamePanel = new GamePanel();
        mainController.addPanel(gamePanel, "GamePanel");
    }
}
