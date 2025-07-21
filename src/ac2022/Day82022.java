package ac2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day82022 {
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
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int counterVisible = (2 * rows) + (2 * (cols - 2));

        // four watches and one aux matrix (0-1)


        System.out.println(counterVisible);
    }
}
