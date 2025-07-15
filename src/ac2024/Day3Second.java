package ac2024;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Pay attention to the status. Use regex, but remember to keep track the activation/deactivation
and use it as a condition to process the data*/

public class Day3Second {
    public static void main(String[] args) {
        int totalSum = 0;
        boolean isEnabled = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                Pattern instructionPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");
                Matcher matcher = instructionPattern.matcher(line);

                while (matcher.find()) {
                    if (matcher.group().equals("do()")) {
                        isEnabled = true;
                    } else if (matcher.group().equals("don't()")) {
                        isEnabled = false;
                    } else if (matcher.group().startsWith("mul(") && isEnabled) {
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(2));
                        totalSum += (x * y);
                    }
                }
            }
        }
        System.out.println("Total Sum: " + totalSum);
    }
}
