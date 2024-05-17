import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {
    private static final int CELL_SIZE = 30;
    private final Model model;
    private final int gridSize;
    private JButton checkButton;
    public Panel(Model model) {
        this.model = model;
        gridSize = model.getGridSize();
        setPreferredSize(new Dimension(gridSize * CELL_SIZE + 100, gridSize * CELL_SIZE + 100));
        setBackground(Color.WHITE);
        addMouseListener(new mouseListener());
        checkButton = new JButton("Check");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSolution();
            }
        });
        //add(checkButton, BorderLayout.);
        checkButton.setPreferredSize(new Dimension(75, 30));
        add(checkButton, BorderLayout.SOUTH);
    }
    private void checkSolution() {
        boolean isSolved = model.isSolved();
        highlightIncorrectCells();
        if (isSolved) {
            JOptionPane.showMessageDialog(this, "Puzzle is solved");
        }else {
            JOptionPane.showMessageDialog(this, "Incorrect");
        }
    }
    private void highlightIncorrectCells() {
        for (int i = 0; i < model.getGridSize(); i++) {
            for (int j = 0; j < model.getGridSize(); j++) {
                if (model.getUserSolution()[i][j] != model.getSolution()[i][j]) {
                    Graphics g = getGraphics();
                    g.setColor(Color.RED);
                    g.drawRect(j * CELL_SIZE + 50, i * CELL_SIZE + 50, CELL_SIZE, CELL_SIZE);
                }
            }
        }
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
    private void drawGrid(Graphics g) {
        for (int i = 0; i < model.getGridSize(); i++) {
            for (int j = 0; j < model.getGridSize(); j++) {
                g.setColor(model.getUserSolution()[i][j] ? Color.BLACK : Color.WHITE);
                g.fillRect(j * CELL_SIZE + 50, i * CELL_SIZE + 50, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(j * CELL_SIZE + 50, i * CELL_SIZE + 50, CELL_SIZE, CELL_SIZE);
            }
        }
    }
    
    private class mouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX() - 50;
            int y = e.getY() - 50;
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
