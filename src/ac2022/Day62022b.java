package ac2022;

import java.util.Scanner;

public class Day62022b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //Set<Character> marker = new HashSet<>(3);
        Marker marker = new Marker();
        scanner.close();
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            marker.offer(letter);
            if (marker.nonRepeatChars() == 4) {
                System.out.println(i + 1);
                return;
            }
        }
    }

    static class Marker {
        char[] innerMarker = new char[4];
        int count = 0;

        public int nonRepeatChars() {
            return count;
        }

        public void offer(char letter) {
            int index = indexOf(letter);
            if (index == -1) {
                innerMarker[count++] = letter;
                return;
            }
            Marker newMarker = new Marker();
            for (int i = index + 1; i < count; i++) {
                newMarker.offer(innerMarker[i]);
            }
            newMarker.offer(letter);
            this.innerMarker = newMarker.innerMarker;
            this.count = newMarker.count;
        }

        int indexOf(char letter) {
            for (int i = 0; i < count; i++)
                if (innerMarker[i] == letter) return i;
            return -1;
        }
    }
}
