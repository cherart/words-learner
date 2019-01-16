package menu.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JButton buttonStart;
    private JButton buttonSettings;
    private JButton buttonMyVocabulary;

    public MenuPanel() {
        this.setLayout(null);

        buttonStart = new JButton("Start");
        buttonSettings = new JButton("Settings");
        buttonMyVocabulary = new JButton("My Vocabulary");

        buttonStart.setBounds(125, 200, 250, 75);
        buttonSettings.setBounds(125, 275, 250, 75);
        buttonMyVocabulary.setBounds(125, 350, 250, 75);

        buttonStart.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonSettings.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonMyVocabulary.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(buttonStart);
        this.add(buttonSettings);
        this.add(buttonMyVocabulary);
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public void setButtonStart(JButton buttonStart) {
        this.buttonStart = buttonStart;
    }

    public JButton getButtonSettings() {
        return buttonSettings;
    }

    public void setButtonSettings(JButton buttonSettings) {
        this.buttonSettings = buttonSettings;
    }

    public JButton getButtonMyVocabulary() {
        return buttonMyVocabulary;
    }

    public void setButtonMyVocabulary(JButton buttonMyVocabulary) {
        this.buttonMyVocabulary = buttonMyVocabulary;
    }
}
