package ac2022;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day92022PartI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Position head = new Position(0, 0);
        Position tail = new Position(0, 0);

        Set<String> visited = new HashSet<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] input = line.split(" ");

            String direction = input[0];
            int steps = Integer.parseInt(input[1]);
            for (int i = 0; i < steps; i++) {
                head.move(direction);
                tail.follow(head);
                visited.add(tail.asKey());
            }
        }
        scanner.close();
        System.out.println(visited.size());
    }
}
