public class ConsTest {
    static int id = 0;

    int localId = id++;


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            ConsTest test = new ConsTest();
            System.out.println(test.localId);
        }
    }
}
