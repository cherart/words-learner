package menu.controller;

import main.MainController;
import menu.view.MenuPanel;
import menu.view.SettingsDialog;

import java.awt.*;

public class MenuController {

    private MenuPanel menuPanel;
    private SettingsDialog settingsDialog;

    public MenuController(MainController mainController) {
        menuPanel = new MenuPanel();
        mainController.addPanel(menuPanel, "MenuPanel");

        CardLayout cardLayout = (CardLayout) mainController.getCardPanel().getLayout();

        menuPanel.getButtonStart().addActionListener(e -> {
            cardLayout.show(mainController.getCardPanel(), "GamePanel");
        });
        menuPanel.getButtonSettings().addActionListener(e -> {
            settingsDialog = new SettingsDialog();
            settingsDialog.setVisible(true);
        });
        menuPanel.getButtonMyVocabulary().addActionListener(e -> {
            cardLayout.show(mainController.getCardPanel(), "MyVocabularyPanel");
        });
    }

//    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//    FileFilter filter = new FileNameExtensionFilter("HTML File", "html");
//        fileChooser.setFileFilter(filter);
//    int returnValue = fileChooser.showOpenDialog(null);
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//        htmlFile = fileChooser.getSelectedFile();
//        cardLayout.show(cardPanel, "MenuCard");
//    } else {
//        JLabel text = (JLabel) getContentPane().findComponentAt(150, 50);
//        text.setText("You didn't choose file");
//    }
}
