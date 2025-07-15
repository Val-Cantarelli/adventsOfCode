package ac2024;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FirstDay {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        try(Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNextLine()){
                l1.add(scanner.nextInt());
                l2.add(scanner.nextInt());
            }
        }

        Collections.sort(l1);
        Collections.sort(l2);
        //System.out.println(l1);
        //System.out.println(l2);

        int distance = 0;
        for(int i=0; i< l1.size(); i++){
            distance = distance + (Math.abs(l1.get(i) - l2.get(i)));
        }
        System.out.println(distance);
    }
}
