package ac2022;


public class File extends  DirFile{
    public final int size;



    public File(int size) {
        super();
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
