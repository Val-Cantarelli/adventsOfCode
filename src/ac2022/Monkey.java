package ac2022;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Monkey {

    String operand;
    String operator;
    Integer divisibleBy;
    Integer indexMonkeyTargetIfIsDivisible;
    Integer indexMonkeyTargetIfNotDivisible;
    Queue<Integer> monkeyBag = new LinkedList<>();
    Integer counterOperations = 0;
    private Map<Integer, Monkey> monkeyMap;

    public Integer applyOperation(Integer worryLevel) {
        counterOperations++;
        int newValue = 0;
        Integer newOperand;
        if (this.operand.equals("old")) {
            newOperand = worryLevel;
        } else {
            newOperand = Integer.parseInt(this.operand);
        }

        if (this.operator.equals("+")) {
            newValue = worryLevel + newOperand;
        } else {
            newValue = worryLevel * newOperand;
        }

        return newValue / 3;
    }

    public Integer test(Integer worryLevel) {
        if (worryLevel % this.divisibleBy == 0) {
            return this.indexMonkeyTargetIfIsDivisible;
        } else return this.indexMonkeyTargetIfNotDivisible;
    }

    public void addItem(int i) {
        this.monkeyBag.offer(i);
    }

    public void doThings() {
        while (!this.monkeyBag.isEmpty()) {
            Integer currentWorryLevel = this.monkeyBag.poll();
            currentWorryLevel = this.applyOperation(currentWorryLevel);
            Integer targetMonkey = this.test(currentWorryLevel);
            Monkey monkeytarget = monkeyMap.get(targetMonkey);
            monkeytarget.monkeyBag.offer(currentWorryLevel);
        }
    }

    // parsing
    public static class Parser {

        public static Monkey parser(Scanner scanner, Map<Integer, Monkey> monkeyMap) {
            String[] line;
            Monkey monkey = new Monkey();
            monkey.monkeyMap = monkeyMap;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine().trim().split("[ ,:]+");
                if (line.length == 0 || line[0].isEmpty()) break;

                switch (line[0]) {
                    case "Starting" -> addBag(line, monkey);
                    case "Operation" -> addOperation(line, monkey);
                    case "Test" -> addTest(line, monkey, scanner);
                }
            }
            return monkey;
        }

        public static void addBag(String[] line, Monkey monkey) {
            for (int i = 2; i < line.length; i++) monkey.addItem(Integer.parseInt(line[i]));
        }

        private static void addOperation(String[] line, Monkey monkey) {
            // Should I create an setOperator() on Monkey?
            monkey.operator = line[4];
            monkey.operand = line[5];
        }

        private static void addTest(String[] line, Monkey monkey, Scanner scanner) {
            String[] nextLine = new String[0];
            try {
                monkey.divisibleBy = Integer.parseInt(line[3]);
                nextLine = scanner.nextLine().split("[ ,:]+");
                monkey.indexMonkeyTargetIfIsDivisible = Integer.parseInt(nextLine[6]);
                nextLine = scanner.nextLine().split("[ ,:]+");
                monkey.indexMonkeyTargetIfNotDivisible = Integer.parseInt(nextLine[6]);
            } catch (Exception exception) {
                System.err.println(String.join(",", nextLine));
                exception.printStackTrace();
            }
        }
    }

}
