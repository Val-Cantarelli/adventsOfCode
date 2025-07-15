package ac2022;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/* Incremental solution:
 * The initial idea was to use a tree, but it would be cumbersome to retrieve and update a node.
 * We then considered a map-based solution to quickly retrieve all the children of a node.
 * However, this would require multiple maps. To simplify, we implemented it with a single
 * map, using the concept of a **path** for fast retrieval of the directory for updates.
 */



public class Day72022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // abre leitura
        Dir rootDir= new Dir("/");
        Stack<String> currentPath = new Stack<>();// declara a pilha do path vazia
        Map<String, Dir> content = new HashMap<>();
        Dir currentDir = null;
        content.put("/", rootDir);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] lineS = line.split(" ");

            if (lineS[1].equals("cd")){
                currentPath.add(lineS[2]);
                currentDir = content.get(currentPath.toString());
                // ..
            }
            if (lineS[0].equals("dir")){

                Dir dir = new Dir(lineS[1]);
                currentDir.list.add(dir);
                currentPath.add(lineS[1]);
                content.put(String.valueOf(currentPath),dir);

            }
            // if file: cria file e adiciona no currentDir

            System.out.println(
                    content.values().stream()
                            .filter( dir -> dir.size() <= 100000)
                            .mapToInt(dir -> dir.size())
                            .sum()
            );
        }
        scanner.close();
    }
}
