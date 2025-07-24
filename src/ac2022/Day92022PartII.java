package ac2022;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day92022PartII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> visited = new HashSet<>();
        Position[] arr = new Position[10];
        for (int i = 0; i < arr.length; i++) arr[i] = new Position(0, 0);
        
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] input = line.split(" ");

            String direction = input[0];
            int steps = Integer.parseInt(input[1]);
            for (int i = 0; i < steps; i++) {
                arr[0].move(direction);

                for (int j = 1; j < 10; j++) {
                    arr[j].follow(arr[j - 1]);
                }
                visited.add(arr[9].asKey());
            }
        }
        scanner.close();
        System.out.println(visited.size());
    }
}
