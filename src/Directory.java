import java.util.ArrayList;

public class Directory {
    private String name;
    private int size = 0;
    private Directory parent;
    ArrayList<Files> files = new ArrayList<Files>();
    ArrayList<Directory> directories = new ArrayList<Directory>();

    public Directory(String name) {
        this.name = name;
    }

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public void addFile(Files x){files.add(x);}

    public void addDirectory(Directory x){
        directories.add(x);
    }

    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {return size;}

    public ArrayList<Files> getFiles() {return files;}

    public ArrayList<Directory> getDirectories() {
        return directories;
    }
}
