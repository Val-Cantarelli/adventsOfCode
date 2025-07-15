package ac2024;
import java.util.Arrays;
import java.util.Scanner;

public class SecondDaySecond {
    // Part II: tolerate a single bad level. If I remove one of the levels, and JUST one, it will
    public static void main(String[] args) {
        int totalSafe = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int[] arr = Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();

                if (test(arr)) totalSafe++;
                else {
                    for (int i = 0; i < arr.length; i++) {
                        int [] currentArr = createSubarrays(arr,i);
                        if(test(currentArr)) {
                            totalSafe++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(totalSafe);
    }

    public static int[] createSubarrays(int[] arr, int excludedIndex){
        int [] subArray = new int[arr.length-1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(i != excludedIndex) subArray[index++] = arr[i];
        }
        return subArray;
    }

    public static boolean test(int [] arr){
        boolean isDecreasing = true;
        boolean isIncreasing = true;

        for(int i = 0; i < arr.length-1; i++){
            int range = Math.abs(arr[i] - arr[i+1]);
            if((arr[i] == arr[i+1]) || (range < 1 || range > 3)){
                isDecreasing = false;
                isIncreasing = false;
                break;
            } else if (arr[i]<arr[i+1]) {
                isDecreasing = false;
            }
            else isIncreasing=false;
        }
        return (isIncreasing || isDecreasing);
    }

}
