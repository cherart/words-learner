package myvocabulary.controller;

import main.MainController;
import myvocabulary.model.WordDaoImpl;
import myvocabulary.view.MyVocabularyPanel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class MyVocabularyController {

    private File htmlFile;

    private WordDaoImpl dao;

    private MyVocabularyPanel myVocabularyPanel;

    public MyVocabularyController(MainController mainController) throws SQLException {
        myVocabularyPanel = new MyVocabularyPanel();
        mainController.addPanel(myVocabularyPanel, "MyVocabularyPanel");

        dao = mainController.getWordDao();
        myVocabularyPanel.setWords(mainController.getStringArrayWords());

        CardLayout cardLayout = (CardLayout) mainController.getCardPanel().getLayout();
        myVocabularyPanel.getButtonAddWord().addActionListener(e -> {

        });
        myVocabularyPanel.getButtonFromFile().addActionListener(e -> {
            chooseFile();
            try {
                insertWords();
                myVocabularyPanel.getTableWords().repaint();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        });
        myVocabularyPanel.getButtonBack().addActionListener(e -> {
            cardLayout.show(mainController.getCardPanel(), "MenuPanel");
        });
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileFilter filter = new FileNameExtensionFilter("HTML File", "html");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
            htmlFile = fileChooser.getSelectedFile();
    }

    private void insertWords() throws IOException, SQLException {
        Document doc = Jsoup.parse(htmlFile, "UTF-8");
        Elements elements = doc.select("tr").select("td");
        for (int i = 2; i < elements.size(); i++) {
            dao.createWord(elements.get(i).text(), elements.get(++i).text());
            i += 2;
        }
    }
}
