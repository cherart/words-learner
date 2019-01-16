package main;

import game.controller.GameController;
import menu.controller.MenuController;
import myvocabulary.controller.MyVocabularyController;

import javax.swing.*;
import java.awt.*;

public class MainController {

    private JPanel cardPanel;

    private MenuController menuController;
    private GameController gameController;
    private MyVocabularyController myVocabularyController;

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.init();
    }

    private void init() {
        JFrame window = new JFrame("Words Learner");
        window.setSize(500, 500);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel = new JPanel(new CardLayout());
        window.add(cardPanel);

        menuController = new MenuController(this);
        gameController = new GameController(this);
        myVocabularyController = new MyVocabularyController(this);

        window.setVisible(true);
    }

    public void addPanel(JPanel panel, String name) {
        cardPanel.add(panel, name);
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }
}

//        File file = new File("Words.html");
//        try {
//            HashMap<String, String> words = new HashMap<>();
//            Document doc = Jsoup.parse(file, "UTF-8");
//            Elements elements = doc.select("tr").select("td");
//            for (int i = 2; i < elements.size(); i++) {
//                String word = elements.get(i).text();
//                words.put(word, elements.get(++i).text());
//                i += 2;
//            }
//            for (String key : words.keySet()) {
//                System.out.println(key);
//                System.out.println(words.get(key));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
