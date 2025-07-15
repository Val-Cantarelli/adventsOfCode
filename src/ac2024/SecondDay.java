package ac2024;
import java.util.Arrays;
import java.util.Scanner;

public class SecondDay {
    public static void main(String[] args) {
        int totalSafe = 0;
        try(Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                int[] numbers = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                boolean isDecreasing = true;
                boolean isIncreasing = true;

                for(int i = 0; i < numbers.length-1; i++){
                    int range = Math.abs(numbers[i] - numbers[i+1]);
                    if((numbers[i] == numbers[i+1]) || (range < 1 || range > 3)){
                        isDecreasing = false;
                        isIncreasing = false;
                        break;
                    } else if (numbers[i]<numbers[i+1]) {
                        isDecreasing = false;
                    }
                    else isIncreasing=false;
                }
                if((isIncreasing || isDecreasing)){
                    totalSafe++;
                }
            }
            System.out.println(totalSafe);
        }
    }
}
