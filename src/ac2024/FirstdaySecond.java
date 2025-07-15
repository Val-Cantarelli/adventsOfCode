package ac2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FirstdaySecond {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        try(Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNextLine()){
                l1.add(scanner.nextInt());
                Integer key = scanner.nextInt();
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }
        System.out.println(l1);
        System.out.println(map1);
        int result = 0;
        for(int i= 0; i< l1.size(); i++){
            result = result + (l1.get(i) * map1.getOrDefault(l1.get(i),0));
        }
        System.out.println(result);
    }
}
