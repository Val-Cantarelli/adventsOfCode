package ac2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day82022Part {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();

        int rows = lines.size();
        int cols = lines.get(0).length();
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            //System.out.println(line);
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int counterVisible = (2 * rows) + (2 * (cols - 2));
        int[][] auxMatrix = new int[rows][cols];

        // four watches and one aux matrix (0-1)
        // for each line

        // left
        for (int i = 0; i < rows; i++) {
            int max = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    auxMatrix[i][j] = 1;
                }
            }
        }

        // right
        for (int i = 0; i < rows; i++) {
            int max = -1;
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    auxMatrix[i][j] = 1;
                }
            }
        }

        // TOP
        for (int i = 0; i < cols; i++) {
            int max = -1;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                    auxMatrix[j][i] = 1;
                }
            }
        }

        // bottom
        for (int i = 0; i < cols; i++) {
            int max = -1;
            for (int j = rows - 1; j >= 0; j--) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                    auxMatrix[j][i] = 1;
                }
            }
        }

        System.out.println("Final counting: ");
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (auxMatrix[i][j] == 1) counterVisible++;
            }
        }
        System.out.println(counterVisible);
    }
}
