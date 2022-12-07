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
    private int currentFilesFromSlash = 0;
    private int[] filesFromSlash = new int[210];
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
        addDirectoriesToSizes();
        sumDirectories();
    }

    public void sumDirectories(){
        for(int i = 0; i < 210; i++){
            if(directorySize[i] < 100000){
                directorySum += directorySize[i];
            }
        }
    }

    public void addDirectoriesToSizes(){
        for(int i = 209; i >= 0; i--){
            addIncludedDirectories(i);
        }
    }

    public void addIncludedDirectories(int x){
        int count = 0;
        int lastspot = 0;
        String s = directoryIncludes[x];
        if(s.length() == 0){}
        else{
            for(int i = 0; i < s.length(); i++){
                if(directoryIncludes[x].charAt(i) == ' '){
                    count += 1;
                }
            }
            for(int i = 0; i < count; i++){
                int size;
                if(i == 0){
                    size = Integer.parseInt( s.substring(lastspot,s.indexOf(' ')) );
                    lastspot = s.indexOf(' ')+1;
                }
                else{
                    size = Integer.parseInt( s.substring(lastspot, s.indexOf(' ', lastspot)) );
                    lastspot = s.indexOf(' ', lastspot) +1;
                }
                directorySize[x] += size;
            }
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
        filesFromSlash[amountOfDirectories] = currentFilesFromSlash + 1;
    }

    public void addFileToDirectory(){
        int x = currentLine.indexOf(' ');
        int size = Integer.parseInt(currentLine.substring(0,x));
        directorySize[currentDirectory] += size;
    }

    public void startList(){
        directoryIncludes[currentDirectory] = "";
        directorySize[currentDirectory] = 0;
    }

    public void changeDirectory(){
        while(currentLine.charAt(5) == '.'){
            getNextLine();
            currentFilesFromSlash -= 1;
        }
        String s = currentLine.substring(5);
        for(int i = 0; i < amountOfDirectories; i++){
            int x = amountOfDirectories - i;
            if(directoryName[x].equals(s) && filesFromSlash[x] == currentFilesFromSlash+1){
                currentDirectory = x;
                i = 1000;
                currentFilesFromSlash += 1;
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
            filesFromSlash[0] = 0;
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getDirectorySum() {
        return directorySum;
    }
}
