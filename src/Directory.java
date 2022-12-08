import java.util.ArrayList;

public class Directory {
    private String name;
    private Directory parent;
    private int size = 0;
    ArrayList<Files> files = new ArrayList<Files>();
    ArrayList<Directory> directories = new ArrayList<Directory>();

    public Directory(String name) {
        this.name = name;
    }

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public void addDirectorySize(){
        for (int i = 0; i < directories.size(); i++) {
            size += directories.get(i).getSize();
        }
    }

    public void addFile(Files x){
        files.add(x);
        size += x.getSize();
    }

    public void addDirectory(Directory x){
        directories.add(x);
    }

    public ArrayList<Directory> getDirectories() {
        return directories;
    }

    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        addDirectorySize();
        return size;
    }
}
