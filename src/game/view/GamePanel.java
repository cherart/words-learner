package game.view;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel labelWord;
    private JTextField textField;
    private JButton buttonSubmit;
    private JButton buttonNext;
    private JButton buttonPrevious;
    private JButton buttonExit;

    public GamePanel() {
        this.setLayout(null);
        onCreate();
    }

    public void onCreate() {
        labelWord = new JLabel();
        textField = new JTextField(16);
        buttonSubmit = new JButton("Submit");
        buttonNext = new JButton("Next");
        buttonPrevious = new JButton("Previous");
        buttonExit = new JButton("Exit");

        labelWord.setBounds(100, 50, 300, 30);
        textField.setBounds(100, 100, 300, 30);
        buttonSubmit.setBounds(200, 150, 100, 30);
        buttonNext.setBounds(350, 150, 100, 30);
        buttonPrevious.setBounds(50, 150, 100, 30);
        buttonExit.setBounds(200, 425, 100, 30);

        labelWord.setHorizontalAlignment(SwingConstants.CENTER);
        labelWord.setFont(new Font("Arial", Font.PLAIN, 28));

        this.add(labelWord);
        this.add(textField);
        this.add(buttonSubmit);
        this.add(buttonNext);
        this.add(buttonPrevious);
        this.add(buttonExit);
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
}
