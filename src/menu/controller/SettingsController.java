package menu.controller;

import main.MainController;
import menu.model.Settings;
import menu.view.MenuPanel;
import menu.view.SettingsPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SettingsController {

    private MainController mainController;
    private SettingsPanel settingsPanel;

    private String startIndex;
    private String lastIndex;
    private String language = "English";
    private String mode = "Test";

    public SettingsController(MainController mainController) {
        this.mainController = mainController;
        start();
    }

    private void start() {
        settingsPanel = new SettingsPanel(this);
        mainController.addPanel(settingsPanel, "SettingsPanel");
        settingsPanel.getTextFrom().addActionListener(e -> startIndex = settingsPanel.getTextFrom().getText());
        settingsPanel.getTextTo().addActionListener(e -> lastIndex = settingsPanel.getTextTo().getText());
    }

    public Settings getSettings() throws SQLException {
        if (settingsPanel.getRadioRussian().isSelected())
            language = "Русский";
        if (settingsPanel.getRadioWrite().isSelected())
            mode = "Write";
        if (startIndex.equals(""))
            startIndex = "0";
        if (lastIndex.equals(""))
            lastIndex = String.valueOf(mainController.getWordDao().getAllWords().size());

        return new Settings(startIndex, lastIndex, language, mode);
    }

    public SettingsPanel getSettingsPanel() {
        return settingsPanel;
    }
}
