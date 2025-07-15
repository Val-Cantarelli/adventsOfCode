import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BagGame {

    public static void main(String[] args) {

        String filename = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Map<String, Integer> cubePattern = new HashMap<>(Map.of(
                    "red", 0,
                    "green", 0,
                    "blue", 0
            ));

            String line;
            int result = 0;
            while ((line = br.readLine()) != null) {
                // Resetando os valores no mapa existente
                cubePattern.put("red", 0);
                cubePattern.put("green", 0);
                cubePattern.put("blue", 0);

                String[] first = line.split(": ");
                String[] idGame = first[0].split(" ");
                //int id = Integer.parseInt(idGame[1]);
                String[] matches = first[1].split("; ");
                int product= 1;
                for (String match : matches) {
                    String[] cubes = match.split(", ");
                    for (String cube : cubes) {
                        String[] parts = cube.split(" ");
                        int count = Integer.parseInt(parts[0]);
                        String color = parts[1];
                        if (count > cubePattern.get(color))cubePattern.put(color,count);
                    }
                    int r = cubePattern.get("red");
                    int g = cubePattern.get("green");
                    int b = cubePattern.get("blue");
                    product = r *g *b;
                }
                result = result + product;
            }
            System.out.println(result);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}