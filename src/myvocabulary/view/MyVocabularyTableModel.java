package myvocabulary.view;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyVocabularyTableModel extends AbstractTableModel {

    private List<String[]> words;

    @Override
    public int getRowCount() {
        return words.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return words.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "English";
            case 2:
                return "Русский";
            default:
                return "Unknown";
        }
    }

    void setWords(List<String[]> words) {
        this.words = words;
    }
}
