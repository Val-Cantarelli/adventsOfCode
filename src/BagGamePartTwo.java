import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BagGamePartTwo {
    //vai usar o mesmo código, mas criando o padrão

    public static void main(String[] args) {

        String filename = args[0];

        // Esse é o padrão dos cubos
        Map<String, Integer> cubePattern = new HashMap<>();
        cubePattern.put("red",12);
        cubePattern.put("green",13);
        cubePattern.put("blue",14);

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int idCounter = 0;
            while ((line = br.readLine()) != null){
                String [] first = line.split(": ");

                String[] idGame = first[0].split(" ");
                int id = Integer.parseInt(idGame[1]);

                String[] matches = first[1].split("; ");

                boolean isValid = true;

                for (String match:matches) {
                    String[] cubes = match.split(", ");
                    for (String cube : cubes) {
                        String[] parts = cube.split(" ");
                        int count = Integer.parseInt(parts[0]);
                        String color = parts[1];
                        if (cubePattern.get(color) >= count) {
                            // valid
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                }
                if (isValid)idCounter+=id;

            }System.out.println(idCounter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
