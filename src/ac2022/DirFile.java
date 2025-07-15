package ac2022;
/*
 Polimorfismo: poso ter uma lista de DirFiles e chamar size() sem saber
 se é um arquivo ou diretório
*/

// abstract: obriga as subclasses a fornecerem implementação de size
public abstract class DirFile {
    public final String name;

    protected DirFile(String name) {
        this.name = name;
    }

    public abstract int size();

}