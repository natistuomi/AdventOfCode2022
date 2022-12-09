import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Snake {
    private Scanner tgb;
    private final String filename;
    private String currentLine;
    private char direction;
    private int steps;
    private int hX = 0;
    private int hY = 0;
    private int tX = 0;
    private int tY = 0;
    private ArrayList<String> visited = new ArrayList<String>();
    private double visitedByTail = 0;

    public Snake(String filename) {
        this.filename = filename;
        initializeScanner();
        while(tgb.hasNextLine()){
            getNextLine();
            calculateMovement();
            if(checkPosition()){
                visited.add(tX + ":" + tY);
            };
        }
    }

    public boolean checkPosition(){
        for(int i = 0; i < visited.size(); i++){
            if(tX == Integer.parseInt(visited.get(i).substring(0,visited.get(i).indexOf(':'))) && tY == Integer.parseInt(visited.get(i).substring(visited.get(i).indexOf(':')+1))){
                return false;
            }
        }
        return true;
    }

    public void calculateMovement(){

    }

    public void getNextLine(){currentLine = tgb.nextLine();}

    public void initializeScanner(){
        try {
            tgb = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }

    public double getVisitedByTail() {
        return visitedByTail;
    }
}
