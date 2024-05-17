import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Nonogram extends JFrame{
    private boolean[][] solution;
    private boolean[][] userSolution;
    private int[] rowClues;
    private int[] colClues;
    private int gridSize = 15;
    private static final int CELL_SIZE = 50; //may change in future
    private NPanel nonogramPanel;
    private Map<Integer, Boolean> colourMap = new HashMap<>();

    public Nonogram(String imagePath) {
        try {
            solution = loadSolution(imagePath); 
        }
        catch (IOException e) {
            System.out.println(e);
            return;
        }
        userSolution = new boolean[gridSize][gridSize];
        generateClues();
        setTitle("Nonogram Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        nonogramPanel = new Panel();
        add(nonogramPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        

        private boolean[][] loadSolution(String imagePath) throws IOException {

        }
        private class Panel extends JPanel {
            public Panel() {
                setPreferredSize(new Dimension(gridSize * CELL_SIZE + 100, gridSize * CELL_SIZE + 100));
                setBackground(Colour.WHITE);
            }
        }
    }
}
