package ac2022;


public abstract class DirFile {
    public final String name;


    protected DirFile() {
        this.name = "";
    }

    protected DirFile(String name) {
        this.name = name;
    }

    public abstract int size();

}