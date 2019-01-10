import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

class WordsLearnerWindow extends JFrame {

    private File htmlFile = null;

    WordsLearnerWindow() throws HeadlessException {
        super("Words Learner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton buttonChoose = new JButton("Choose");
        buttonChoose.setSize(80,40);
        buttonChoose.setLocation(100,100);
        buttonChoose.addActionListener(e -> chooseFile());
        panel.add(buttonChoose);
        setContentPane(panel);
        setSize(500, 700);
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            htmlFile = fileChooser.getSelectedFile();
        }
    }
}
