package ac2022;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Incremental solution:
 * The initial idea was to use a tree, but it would be cumbersome to retrieve and update a node.
 * We then considered a map-based solution to quickly retrieve all the children of a node.
 * However, this would require multiple maps. To simplify, we implemented it with a single
 * map, using the concept of a **path** for fast retrieval of the directory for updates.
 */


public class Day72022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Dir> content = new HashMap<>();

        Dir rootDir = new Dir("/");
        content.put("/", rootDir);
        Dir currentDir = null;
        String currentPath = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineS = line.split(" ");
            if (line.charAt(0) == '$') {
                if (lineS[1].equals("cd")) {
                    //$ cd ..
                    if (lineS[2].equals("..")) {
                        int li = currentPath.substring(0, currentPath.length() - 1).lastIndexOf("/");
                        currentPath = currentPath.substring(0, li + 1);
                    }
                    // $ cd /
                    else if (lineS[2].equals("/")) {
                        currentPath = "/";
                    }
                    // $ cd x
                    else {
                        currentPath = currentPath + lineS[2] + "/";
                    }
                    currentDir = content.get(currentPath);
                    if (currentDir == null) {
                        System.err.println(currentPath);
                        throw new RuntimeException("error");
                    }
                } else if (lineS[1].equals("ls")) {
                    continue;
                }
            } else {
                // ls
                if (lineS[0].equals("dir")) {
                    // Extrai nome, cria Dir e adiciona no map e no currentDir
                    Dir dir = new Dir(lineS[1]);
                    currentDir.list.add(dir);
                    String newDirPath = currentPath + lineS[1] + "/";
                    System.out.println("adding " + newDirPath);
                    content.put(currentPath + lineS[1] + "/", dir);
                } else {
                    int size = Integer.parseInt(lineS[0]);
                    File file = new File(size);
                    currentDir.list.add(file);

                }
            }
        }
        scanner.close();

        System.out.println(
                content.values().stream()
                        .filter(dir -> dir.size() <= 100000)
                        .mapToInt(Dir::size)
                        .sum()
        );

    }
}
