import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CalibrationFix {

    public static int extNumber(String s){
        int[] arr = {-1,-1};
        int number;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                arr[j] = c - 48;
                if (j == 0) j = 1;
            }
        }
        if (arr[1] == -1)number = (arr[0] * 10) + arr[0] ;
        else number = (arr[0] * 10) + arr[1];

        return number;
    }

    public static void main(String[] args) throws IOException {
        // Nome do arquivo de recurso
        String resourceFileName = "calibration.txt";

        // Obtém o InputStream para o recurso
        InputStream inputStream = CalibrationFix.class.getClassLoader().getResourceAsStream(resourceFileName);

        if (inputStream == null) {
            System.err.println("Recurso não encontrado: " + resourceFileName);
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int result = 0;
            while ((line = br.readLine()) != null) {
                result += extNumber(line);// Processa cada linha conforme necessário
            }
            System.out.println(result);
        } catch (IOException e) {
            System.err.println("Erro ao ler o recurso: " + e.getMessage());
        }
    }

}
