package ac2024;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Day3 {

    public static void main(String[] args) {
        int totalSum = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
                Matcher match = pattern.matcher(line);

                List<int[]> capturedValues = new ArrayList<>();
                while (match.find()) {
                    // Captura os valores de x e y como strings
                    int x = Integer.parseInt(match.group(1));
                    int y = Integer.parseInt(match.group(2));
                    capturedValues.add(new int[]{x,y});
                }

                for(int[]pair : capturedValues){
                    totalSum = totalSum + pair[0] * pair[1];
                }
            }System.out.println(totalSum);
        }
    }
}