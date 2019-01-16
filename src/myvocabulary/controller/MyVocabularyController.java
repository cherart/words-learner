package myvocabulary.controller;

import main.MainController;
import myvocabulary.view.MyVocabularyPanel;

public class MyVocabularyController {

    private MyVocabularyPanel myVocabularyPanel;

    public MyVocabularyController(MainController mainController) {
        myVocabularyPanel = new MyVocabularyPanel();
        mainController.addPanel(myVocabularyPanel, "MyVocabularyPanel");
    }
}
