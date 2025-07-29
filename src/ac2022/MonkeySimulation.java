package ac2022;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MonkeySimulation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] line;
        Map<Integer, Monkey> monkeyMap = new HashMap<>();
        PriorityQueue<Monkey> pq = new PriorityQueue<>(Comparator.comparingInt(m -> m.counterOperations));


        // 1. Parsing and output after parsing:
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().trim().split("[ ,:]+");
            if (line.length == 0 || line[0].isEmpty()) continue;


            if (line[0].equals("Monkey")) { // stop and collect
                Monkey monkeyCurrent = Monkey.Parser.parser(scanner, monkeyMap);
                monkeyMap.put(Integer.parseInt(line[1].replace(":", "")), monkeyCurrent);
            }
        }

        System.out.println("Printing the parsing:");
        for (Map.Entry<Integer, Monkey> entry : monkeyMap.entrySet()) {
            Monkey m = entry.getValue();
            System.out.printf(
                    "Monkey %d => items=%s, operator=%s, operand=%s, divisible=%d, true=%d, false=%d%n",
                    entry.getKey(), m.monkeyBag, m.operator, m.operand,
                    m.divisibleBy, m.indexMonkeyTargetIfIsDivisible, m.indexMonkeyTargetIfNotDivisible
            );
        }

        // 2. Simulation and result
        int round = 0;
        while (round < 20) {
            for (int i = 0; i < monkeyMap.size(); i++) {
                Monkey currentMonkey = monkeyMap.get(i);
                currentMonkey.doThings();
            }
            round++;
        }


        /*
        Tip: Priority Queue
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (Monkey entry : monkeyMap.values()) {
            int count = entry.counterOperations;
            if (count >= max2) {
                max1 = max2;
                max2 = count;
            } else if (count > max1) {
                max1 = count;
            }
        }
        System.out.println("Values of the most active Monkeys multiplied after simulation of 20 rounds: " + max1 * max2);
        */

        for (Monkey monkey : monkeyMap.values()) {
            pq.offer(monkey);
            if (pq.size() > 2) {
                pq.poll();//remove the smallest
            }
        }

        Monkey first = pq.poll();
        Monkey second = pq.poll();
        assert second != null;
        assert first != null;
        int result = (first.counterOperations * second.counterOperations);
        System.out.println(result);
    }
}