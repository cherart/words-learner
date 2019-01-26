package myvocabulary.view;

import javax.swing.*;
import java.util.List;

public class MyVocabularyPanel extends JPanel {

    private JButton buttonAddWord;
    private JButton buttonFromFile;
    private JButton buttonBack;
    private JScrollPane scrollPanel;
    private MyVocabularyTable tableWords;

    public MyVocabularyPanel() {
        this.setLayout(null);
        onCreate();
    }

    public void onCreate() {
        tableWords = new MyVocabularyTable();
        tableWords.setBounds(0, 0, 500, 300);

        scrollPanel = new JScrollPane(tableWords);
        scrollPanel.setBounds(20, 20, 460, 350);

        buttonAddWord = new JButton("Add Word");
        buttonFromFile = new JButton("From File");
        buttonBack = new JButton("Back");

        buttonAddWord.setBounds(75, 390, 150, 30);
        buttonFromFile.setBounds(275, 390, 150, 30);
        buttonBack.setBounds(200, 430, 100, 30);

        this.add(scrollPanel);
        this.add(buttonAddWord);
        this.add(buttonFromFile);
        this.add(buttonBack);
    }

    public void setWords(List<String[]> words) {
        tableWords.setModelWords(words);
    }

    public MyVocabularyTable getTableWords() {
        return tableWords;
    }

    public JButton getButtonAddWord() {
        return buttonAddWord;
    }

    public JButton getButtonFromFile() {
        return buttonFromFile;
    }

    public JButton getButtonBack() {
        return buttonBack;
    }
}
