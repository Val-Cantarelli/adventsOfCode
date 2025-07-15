import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GearRatiosDay3 {

    /**
     * Dado um block retorna a soma dos números encontrados na linha pivot(do meio)
     * que tenha um símbolo na redondeza.
     * @param block
     * @return
     */
    public static int search(String[] block){
        int result = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(block[1]);
        while (matcher.find()){
            int number = Integer.parseInt(matcher.group());
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            if (    block[0] != null && encontraSimbolo(block[0], startIndex-1, endIndex+1) ||
                    block[2] != null && encontraSimbolo(block[2], startIndex-1, endIndex+1) ||
                    encontraSimbolo(block[1], startIndex-1, endIndex+1)
            ) result += number;
        }
        return result;
    }

    private static boolean encontraSimbolo(String s, int start, int end) {
        // Verifica se os índices estão dentro dos limites da string
        if (end > s.length()) end = s.length();
        if (start < 0) start = 0;

        String substring = s.substring(start, end);
        Pattern pattern = Pattern.compile("[^0-9.]+");
        Matcher matcher = pattern.matcher(substring);
        return matcher.find();
    }


    public static void main(String[] args) {
        String filename = "resources/engine.txt";
        int result = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line ;

            String[] block = new String[3];
            for (int i=0; i < 3 && (line = br.readLine()) != null; i++ ){
                block[i] = line;
            }
            String[] firstBlock = new String[]{null, block[0], block[1]};
            result += search(firstBlock);
            result += search(block);
            while(true){
                line = br.readLine();
                if (line == null) break;
                block = new String[]{block[1], block[2], line};
                result += search(block);
            }
            String[] lastBlock = new String[]{block[1], block[2], null};
            result += search(lastBlock);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }

}
