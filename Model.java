import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private final int gridSize = 15;
    private boolean[][] solution;
    private boolean[][]userSolution;
    private int[] rowClues;
    private int[] colClues;
    private Map<Integer, Boolean> colourMap = new HashMap<>;

    public Model(String imagePath) throws IOException {
        solution = loadSolution(imagePath);
        userSolution = new boolean[gridSize][gridSize];
        generateClues();
    }
}
