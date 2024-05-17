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
    private static final int CELL_SIZE = 100; //may change in future
    
    public Nonogram(String imagePath) {
        try {
            solution = loadSolution(imagePath);
        }
        catch (IOException e) {
            return;
        }

        userSolution = new boolean[gridSize][gridSize];
        generateClues();

        setTitle("Nonogram Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
    }
}
