package src;

public class File extends  DirFile{
    public final int size;

    public File(int size, String name) {
        super(name);
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
