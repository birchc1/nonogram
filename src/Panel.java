import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {
    private static final int CELL_SIZE = 30;
    private final Model model;
    private final int gridSize;
    public Panel(Model model) {
        this.model = model;
        gridSize = model.getGridSize();
        setPreferredSize(new Dimension(gridSize * CELL_SIZE + 100, gridSize * CELL_SIZE + 100));
        setBackground(Color.WHITE);
        addMouseListener(new mouseListener());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawClues(g);
        drawGrid(g);
    }
    private void drawClues(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < model.getGridSize(); i++) {
            g.drawString(String.valueOf(model.getRowClues()[i]), 10, (i + 1) * CELL_SIZE + 20);
            g.drawString(String.valueOf(model.getColClues()[i]), (i + 1) * CELL_SIZE + 20, 20);
        }
    }
    
    private class mouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (x >= 0 && x < model.getGridSize() * CELL_SIZE && y >= 0 && y < model.getGridSize() * CELL_SIZE) {
                int row = y / CELL_SIZE;
                int col = x / CELL_SIZE;
                model.setUserSolutionCell(row, col, !model.getUserSolution()[row][col]);
                repaint();
                if (model.isSolved()) {
                    JOptionPane.showMessageDialog(Panel.this, "Nongram is solved");
                }
            }
        }
    }
}  
