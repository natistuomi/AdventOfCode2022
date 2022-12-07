import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filesystem {
    private Scanner tgb;
    private final String filename;
    private String currentLine;
    private int currentDirectory = 0;
    private double[] directorySize = new double[210];
    private String[] directoryIncludes = new String [210];
    private int amountOfDirectories = 0;
    private String[] directoryName = new String[210];
    private double directorySum = 0;

    public Filesystem(String filename) {
        this.filename = filename;
        initializeScanner();
        calculateDirectories();
    }

    public void calculateDirectories(){
        while(tgb.hasNextLine()){
            getNextLine();
            implementLine();
        }
    }

    public void implementLine(){
        String type = identifyLineType();
        if(type.equals("move")){changeDirectory();}
        else if(type.equals("list")){startList();}
        else if(type.equals("file")){addFileToDirectory();}
        else{noteDirectory();}
    }

    public void noteDirectory(){
        amountOfDirectories += 1;
        directoryName[amountOfDirectories] = currentLine.substring(4);
        directoryIncludes[currentDirectory] += amountOfDirectories + " ";
    }

    public void addFileToDirectory(){
        int x = currentLine.indexOf(' ');
        int size = Integer.parseInt(currentLine.substring(0,x));
        directorySize[currentDirectory] += size;
    }

    public void startList(){
        directoryIncludes[currentDirectory] = "";
    }

    public void changeDirectory(){
        while(currentLine.charAt(5) == '.'){
            getNextLine();
        }
        String s = currentLine.substring(5);
        for(int i = 0; i < amountOfDirectories; i++){
            int x = amountOfDirectories - i;
            if(directoryName[x].equals(s)){
                currentDirectory = x;
            }
        }
    }

    public String identifyLineType(){
        String s = "";
        if(currentLine.charAt(0) == '$'){
            if(currentLine.charAt(2) == 'l'){s = "list";}
            else{s = "move";}
        }
        else if(currentLine.charAt(0) == 'd'){s = "directory";}
        else{s = "file";}
        return s;
    }

    public void getNextLine(){currentLine = tgb.nextLine();}

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
            getNextLine();
            directoryName[0] = "/";
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getDirectorySum() {
        return directorySum;
    }
}
