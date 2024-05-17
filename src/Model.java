import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Model {
    private final int gridSize = 15;
    private boolean[][] solution;
    private boolean[][]userSolution;
    private int[] rowClues;
    private int[] colClues;
    private Map<Integer, Boolean> colourMap = new HashMap<>();

    public Model(String imagePath) throws IOException {
        solution = loadSolution(imagePath);
        userSolution = new boolean[gridSize][gridSize];
        generateClues();
    }
public boolean[][] loadSolution(String imagePath) throws IOException {
        File file = new File(imagePath);
        BufferedImage image = ImageIO.read(file);

        if (image == null) {
            throw new IOException("The file is not a valid BMP image.");
        }

        boolean[][] solution = new boolean[gridSize][gridSize];

        
        int blackColour = 0xFF000000;
        colourMap.put(blackColour, true);

        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                int pixel = image.getRGB(x, y);
                solution[y][x] = colourMap.getOrDefault(pixel, false);
            }
        }

        return solution;
    }

    private void generateClues() {
        rowClues = new int[gridSize];
        colClues = new int[gridSize];
        for (int i = 0; i < gridSize; i++) {
            rowClues[i] = countConsec(solution[i]);
            int[] colArray = new int[gridSize];
            for (int j = 0; j < gridSize; j++) {
                colArray[j] = solution[j][i] ? 1 : 0;
            }
            colClues[i] = countConsec(colArray);
        }
    }
    private int countConsec(boolean[] row) {
        int count = 0;
        int consecCount = 0;
        for (boolean cell : row) {
            if (cell) {
                consecCount++;
            }else {
                count = Math.max(count, consecCount);
                consecCount = 0;
            }
        }
        return Math.max(count, consecCount);
    }
    private int countConsec(int[] row) {
        int count = 0;
        int consecCount = 0;
        for (int cell: row) {
            if (cell == 1) {
                consecCount++;
            }else {
                count = Math.max(count, consecCount);
                consecCount = 0;
            }
        }
        return Math.max(count, consecCount);
    }

    public int getGridSize() {
        return gridSize;
    }
    public boolean[][] getSolution() {
        return solution;
    }
    public boolean[][] getUserSolution() {
        return userSolution;
    }
    public int[] getRowClues() {
        return rowClues;
    }
    public int[] getColClues() {
        return colClues;
    }
    public void setUserSolutionCell(int row, int col, boolean value) {
        userSolution[row][col] = value;
    }
    public boolean isSolved() {
        for (int i =0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (userSolution [i][j] != solution [i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
