package ac2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day82022Part2 {
    // "NAIVE - O(nˆ2)"
    // If < than me: count
    // tre == to the candidate || tree > candidate || tree reach the border: count and STOP
    // Multiply each direction total visible trees
    // Best candidate: the greatest number of visible tres

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
            //System.out.println(lines);
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

        // just sout
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //System.out.print(grid[i][j]);
            }
            //System.out.println();
        }

        int countRight;
        int countLeft;
        int countTop;
        int countBottom;
        int partialResult;
        int treeValue;
        int maxScore = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                treeValue = grid[i][j];
                //right
                countRight = 0;
                for (int k = j + 1; k < cols; k++) {
                    countRight++;
                    if (grid[i][k] >= treeValue) break;
                }

                //left
                countLeft = 0;
                for (int k = j - 1; k >= 0; k--) {
                    countLeft++;
                    if (grid[i][k] >= treeValue) break;
                }

                //top
                countTop = 0;
                for (int k = i - 1; k >= 0; k--) {
                    countTop++;
                    if (grid[k][j] >= treeValue) break;
                }

                // bottom
                countBottom = 0;
                for (int k = i + 1; k < rows; k++) {
                    countBottom++;
                    if (grid[k][j] >= treeValue) break;
                }

                partialResult = (countRight * countBottom * countLeft * countTop);
                if (partialResult > maxScore) maxScore = partialResult;
                partialResult = 0;
            }
        }
        System.out.println(maxScore);
    }
}
