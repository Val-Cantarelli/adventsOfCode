import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WinningNumber {
    public static void main(String[] args) throws IOException {
        String filename = "resources/stracthCards.txt";
        long sumCards = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null){
                long valueCard;
                Set<Integer> numberSet = getIntegers(line);
                valueCard = numberSet.isEmpty() ? 0 : 1L << (numberSet.size() -1);
                sumCards = sumCards + valueCard;
            }
        }
        System.out.println(sumCards);
    }

    private static Set<Integer> getIntegers(String line) {
        String[] parts = line.split("\\|");
        String[] firstGroup = parts[0].split(":")[1].trim().split("\\s+");
        String[] secondGroup = parts[1].trim().split("\\s+");

        Set<Integer> numberSet = new HashSet<>();
        Set<Integer> winningSet = new HashSet<>();

        for (String num : firstGroup) {
            numberSet.add(Integer.parseInt(num));
        }
        for (String num : secondGroup) {
            winningSet.add(Integer.parseInt(num));
        }
        numberSet.retainAll(winningSet);
        return numberSet;
    }
}


