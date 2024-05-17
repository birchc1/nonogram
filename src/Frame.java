import javax.swing.*;
import java.io.IOException;

public class Frame extends JFrame {
    public Frame(String imagePath) {
        try {
            Model model = new Model(imagePath);
            Panel panel = new Panel(model);

            setTitle("Nonogram");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
            add(panel, BorderLayout.CENTER):
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (IOException e) {
            System.out.println(e);
            return;
        }
    }
}
