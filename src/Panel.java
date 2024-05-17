import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {
    private static final int CELL_SIZE = 30;
    private final Model model;
    public Panel(Model model) {
        this.model = model;
        setPreferredSize(new Dimension(gridSize * CELL_SIZE + 100, gridSize * CELL_SIZE + 100));
        setBackground(Colour.WHITE);
    }
    
    private class MouseListener extends MouseAdapter {
        public void mouseCLicked(mouseEvent e) {
            int x = e.getX();
            int y = e.getY();
        }
    }
}  
