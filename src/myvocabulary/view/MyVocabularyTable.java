package myvocabulary.view;

import javax.swing.*;
import java.util.List;

public class MyVocabularyTable extends JTable {

    private MyVocabularyTableModel tableModel;

    public MyVocabularyTable() {
        tableModel = new MyVocabularyTableModel();
        this.setModel(tableModel);
    }

    void setModelWords(List<String[]> words) {
        tableModel.setWords(words);
    }
}
