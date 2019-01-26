package menu.view;

import javax.swing.*;

public class MenuPanel extends JPanel {

    private JButton buttonStart;
    private JButton buttonStatistics;
    private JButton buttonMyVocabulary;

    public MenuPanel() {
        this.setLayout(null);
        onCreate();
    }

    public void onCreate() {
        buttonStart = new JButton("Start");
        buttonStatistics = new JButton("Statistics");
        buttonMyVocabulary = new JButton("My Vocabulary");

        buttonStart.setBounds(20, 400, 150, 30);
        buttonStatistics.setBounds(180, 400, 150, 30);
        buttonMyVocabulary.setBounds(340, 400, 150, 30);

        this.add(buttonStart);
        this.add(buttonStatistics);
        this.add(buttonMyVocabulary);
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public JButton getButtonStatistics() {
        return buttonStatistics;
    }

    public JButton getButtonMyVocabulary() {
        return buttonMyVocabulary;
    }
}
