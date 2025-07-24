package ac2022;

import java.util.Scanner;
/*
 * Cycle-based simulation (from 1 to 220):
 * - The loop advances one cycle per iteration;
 * - The 'click' variable controls the remaining execution time of the 'addx'
 *   instruction, which take two full cycles before updating the value of x;
 * - The boolean 'readInput' indicates whether to fetch a new instruction
 *   or continue executing the current one.
 *
 * OOP seems overengineering in this case.
 */

public class Day102022PartI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean readInput = true;
        int catchCycle = 20;
        int x = 1;
        int sum = 0;
        int click = 2;

        String[] line = new String[2];
        
        for (int cycle = 1; cycle <= 220; cycle++) {
            if (readInput) {
                line = scanner.nextLine().split(" ");
            }
            if (line[0].equals("addx")) {
                click--;
                readInput = false;
            }

            if (cycle == catchCycle) {
                sum += (cycle * x);
                catchCycle += 40;
            }

            if (click == 0) {
                x = x + Integer.parseInt(line[1]);
                readInput = true;
                click = 2;
            }
        }
        System.out.println(sum);
    }
}
