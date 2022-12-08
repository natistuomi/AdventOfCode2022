import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filesystem2 {
    private Scanner tgb;
    private final String filename;
    private String currentLine;
    private Directory currentDirectory;
    private double sizeSum = 0;
    private Directory c;

    public Filesystem2(String filename) {
        this.filename = filename;
        initializeScanner();
        followTerminal();
        calculateSizes();
    }

    public void followTerminal(){
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

    public void changeDirectory(){
        if(currentDirectory == null){
            currentDirectory = new Directory(currentLine.substring( currentLine.lastIndexOf(' ')+1 ));
            c = currentDirectory;
        }
        else if(currentLine.charAt(5) == '.'){
            currentDirectory = currentDirectory.getParent();
        }
        else{
            String s = currentLine.substring( currentLine.lastIndexOf(' ')+1 );
            for(int i = 0; i < currentDirectory.getDirectories().size(); i++){
                if(s.equals(currentDirectory.getDirectories().get(i).getName())){
                    currentDirectory = currentDirectory.getDirectories().get(i);
                }
            }
        }
    }

    public void startList(){}

    public void addFileToDirectory(){
        String n = currentLine.substring(currentLine.indexOf(' ')+1);
        int s = Integer.parseInt(currentLine.substring( 0, currentLine.indexOf(' ')));
        Files x = new Files(n, s);
        currentDirectory.addFile(x);
    }

    public void noteDirectory(){
        String s = currentLine.substring(4);
        Directory x = new Directory(s, currentDirectory);
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

    public void calculateSizes(){c.getSize();}

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getSizeSum() {
        return sizeSum;
    }
}
