import java.util.HashMap;
import java.util.function.Function;

public class Ideas {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 20);
        map.put(6, 10);
        for (int i=0; i < 10; i++){
            System.out.println(map.getOrDefault(i, i));
        }
    }

    public static int f(int x){
        return x;
    }
}
