import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filesystem {
    private Scanner tgb;
    private final String filename;
    private double directorySum = 0;

    public Filesystem(String filename) {
        this.filename = filename;
    }

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getDirectorySum() {
        return directorySum;
    }
}
