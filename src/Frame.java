import javax.swing.*;
import java.awt.FlowLayout;
import java.io.IOException;

public class Frame extends JFrame {
    public Frame(String imagePath) {
        try {
            Model model = new Model(imagePath);
            Panel panel = new Panel(model);

            setTitle("Nonogram");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout(FlowLayout.LEADING));
            add(panel);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (IOException e) {
            System.out.println(e);
            return;
        }
    }
}
