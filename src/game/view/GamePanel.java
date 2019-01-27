package game.view;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    //Common
    private JLabel labelCounter;
    private JLabel labelWord;
    private JLabel labelResult;
    private JButton buttonPrevious;
    private JButton buttonNext;
    private JButton buttonExit;
    private JButton buttonSubmit;
    //Test
    private JRadioButton radioFirst;
    private JRadioButton radioSecond;
    private JRadioButton radioThird;
    private JRadioButton radioFourth;
    //Write
    private JTextField textField;

    public GamePanel() {
        this.setLayout(null);
    }

    public void onCreate(String mode) {
        labelCounter = new JLabel();
        labelWord = new JLabel();
        labelResult = new JLabel();
        buttonPrevious = new JButton("Previous");
        buttonSubmit = new JButton("Submit");
        buttonNext = new JButton("Next");
        buttonExit = new JButton("Exit");

        labelCounter.setBounds(15, 15, 100, 30);
        labelWord.setBounds(100, 30, 300, 40);
        labelResult.setBounds(200, 325, 100, 40);

        labelWord.setHorizontalAlignment(SwingConstants.CENTER);
        labelWord.setFont(new Font("Arial", Font.PLAIN, 28));
        labelResult.setHorizontalAlignment(SwingConstants.CENTER);
        labelResult.setFont(new Font("Arial", Font.PLAIN, 28));

        this.add(labelCounter);
        this.add(labelWord);
        this.add(labelResult);

        if (mode.equals("Test"))
            createTestComponents();
        else
            createWriteComponents();
    }

    private void createTestComponents() {
        radioFirst = new JRadioButton("First");
        radioSecond = new JRadioButton("Second");
        radioThird = new JRadioButton("Third");
        radioFourth = new JRadioButton("Fourth");

        radioFirst.setBounds(100, 100, 150, 30);
        radioSecond.setBounds(250, 100, 150, 30);
        radioThird.setBounds(100, 150, 150, 30);
        radioFourth.setBounds(250, 150, 150, 30);
        buttonSubmit.setBounds(200, 250, 100, 30);
        buttonNext.setBounds(350, 250, 100, 30);
        buttonPrevious.setBounds(50, 250, 100, 30);
        buttonExit.setBounds(200, 400, 100, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(radioFirst);
        group.add(radioSecond);
        group.add(radioThird);
        group.add(radioFourth);

        this.add(radioFirst);
        this.add(radioSecond);
        this.add(radioThird);
        this.add(radioFourth);
        this.add(buttonSubmit);
        this.add(buttonNext);
        this.add(buttonPrevious);
        this.add(buttonExit);
    }

    private void createWriteComponents() {
        textField = new JTextField(16);

        textField.setBounds(50, 100, 400, 30);
        buttonPrevious.setBounds(50, 150, 100, 30);
        buttonSubmit.setBounds(200, 150, 100, 30);
        buttonNext.setBounds(350, 150, 100, 30);
        buttonExit.setBounds(200, 425, 100, 30);

        textField.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(textField);
        this.add(buttonPrevious);
        this.add(buttonSubmit);
        this.add(buttonNext);
        this.add(buttonExit);
    }

    public void clearPanel() {
        this.removeAll();
    }

    public JLabel getLabelWord() {
        return labelWord;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getButtonSubmit() {
        return buttonSubmit;
    }

    public JButton getButtonNext() {
        return buttonNext;
    }

    public JButton getButtonPrevious() {
        return buttonPrevious;
    }

    public JButton getButtonExit() {
        return buttonExit;
    }

    public JLabel getLabelCounter() {
        return labelCounter;
    }

    public JLabel getLabelResult() {
        return labelResult;
    }

    public JRadioButton getRadioFirst() {
        return radioFirst;
    }

    public JRadioButton getRadioSecond() {
        return radioSecond;
    }

    public JRadioButton getRadioThird() {
        return radioThird;
    }

    public JRadioButton getRadioFourth() {
        return radioFourth;
    }
}
