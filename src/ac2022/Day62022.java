package ac2022;

import java.util.Scanner;

public class Day62022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //Set<Character> marker = new HashSet<>(3);
        char[] marker = new char[4];
        scanner.close();
        int i;
        int countMarker = 0;

        for (i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if (countMarker == 0) {
                marker[countMarker++] = letter;
                continue;
            }
            int j = 0;
            for (; j < countMarker; j++) {
                if (letter == marker[j]) break;
            }
            if (letter == marker[j]) {
                char[] novoMarker = new char[4];
                int novoCount = 0;
                for (int k = j + 1; k < countMarker; novoCount++, k++) {
                    novoMarker[novoCount] = marker[k];
                }
                marker = novoMarker;
                countMarker = novoCount;

            }
            marker[countMarker++] = letter;
            if (countMarker == 4) {
                System.out.println(i + 1);
                return;
            }

        }
    }
}
