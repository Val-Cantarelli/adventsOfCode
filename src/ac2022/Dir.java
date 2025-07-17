package ac2022;

import java.util.ArrayList;
import java.util.List;

public class Dir extends DirFile {

    public Integer currentSize;

    final List<DirFile> list = new ArrayList<>();

    public Dir(String aName) {
        super(aName);
    }

    @Override
    public int size() {
        if (currentSize == null)
            currentSize = list.stream().mapToInt(dirFile -> dirFile.size()).sum();
        return currentSize;
    }

    public void add(DirFile dirFile) {
        list.add(dirFile);
    }

}
