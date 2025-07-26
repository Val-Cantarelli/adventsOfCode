package ac2022;

import java.util.Scanner;

// No matter what, all cycles write once. Be able to identify other patterns and this will reduce to just one ternary if

public class Day102022PartII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = 1;
        char[] crt = new char[240];
        String[] line = new String[2];
        boolean readInput = true;

        for (int cycle = 0; cycle < 240; cycle++) {
            int col = cycle % 40;

            crt[cycle] = (col >= x - 1 && col <= x + 1) ? '#' : '.';

            if (readInput) {
                line = scanner.nextLine().split(" ");

                if (line[0].equals("addx")) {
                    readInput = false;
                }
            } else {
                x += Integer.parseInt(line[1]);
                readInput = true;
            }
        }

        for (int i = 0; i < 240; i += 40) {
            System.out.println(new String(crt, i, 40));
        }
    }
}
