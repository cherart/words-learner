package menu.view;

import menu.controller.SettingsController;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    private SettingsController settingsController;

    private JRadioButton radioEnglish;
    private JRadioButton radioRussian;
    private JRadioButton radioTest;
    private JRadioButton radioWrite;
    private JTextField textFrom;
    private JTextField textTo;
    private JLabel labelLanguage;
    private JLabel labelMode;
    private JLabel labelCount;
    private JLabel labelFrom;
    private JLabel labelTo;

    public SettingsPanel(SettingsController settingsController) {
        this.setLayout(null);
        this.setBounds(40, 40, 420, 320);
        this.setBorder(BorderFactory.createLineBorder(Color.gray));
        this.settingsController = settingsController;
        onCreate();
    }

    private void onCreate() {
        radioEnglish = new JRadioButton("English", true);
        radioRussian = new JRadioButton("Русский");
        radioTest = new JRadioButton("Test", true);
        radioWrite = new JRadioButton("Write");
        textFrom = new JTextField(20);
        textTo = new JTextField(20);
        labelLanguage = new JLabel("Language:");
        labelMode = new JLabel("Mode:");
        labelCount = new JLabel("Count:");
        labelFrom = new JLabel("From");
        labelTo = new JLabel("To");

        radioEnglish.setBounds(75, 15, 100, 30);
        radioRussian.setBounds(180, 15, 100, 30);
        radioTest.setBounds(75, 55, 100, 30);
        radioWrite.setBounds(180, 55, 100, 30);
        textFrom.setBounds(130, 95, 50, 30);
        textTo.setBounds(230, 95, 50, 30);
        labelLanguage.setBounds(5, 15, 70, 30);
        labelMode.setBounds(5, 55, 50, 30);
        labelCount.setBounds(5, 95, 50, 30);
        labelFrom.setBounds(80, 95, 40, 30);
        labelTo.setBounds(200, 95, 20, 30);


        ButtonGroup groupLanguage = new ButtonGroup();
        groupLanguage.add(radioEnglish);
        groupLanguage.add(radioRussian);

        ButtonGroup groupMode = new ButtonGroup();
        groupMode.add(radioTest);
        groupMode.add(radioWrite);


        this.add(radioEnglish);
        this.add(radioRussian);
        this.add(radioTest);
        this.add(radioWrite);
        this.add(textFrom);
        this.add(textTo);
        this.add(labelLanguage);
        this.add(labelMode);
        this.add(labelCount);
        this.add(labelFrom);
        this.add(labelTo);
    }

    public JRadioButton getRadioEnglish() {
        return radioEnglish;
    }

    public JRadioButton getRadioRussian() {
        return radioRussian;
    }

    public JRadioButton getRadioTest() {
        return radioTest;
    }

    public JRadioButton getRadioWrite() {
        return radioWrite;
    }

    public JTextField getTextFrom() {
        return textFrom;
    }

    public JTextField getTextTo() {
        return textTo;
    }

    public JLabel getLabelLanguage() {
        return labelLanguage;
    }
}
