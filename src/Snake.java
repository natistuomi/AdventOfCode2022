import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Snake {
    private Scanner tgb;
    private final String filename;
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
        while(steps != 0){
            moveHead();
            moveTail();
        }
    }

    public void moveTail(){
        int difX = hX - tX;
        int difY = hY - tY;
        if(difY == 0 && difX == -2 || difX == 2){
            if(difX > 0){tX += 1;}
            else{tX -= 1;}
        }
        else if(difX == 0 && difY == -2 || difY == 2){
            if(difY > 0){tY += 1;}
            else{tY -= 1;}
        }
        else if(difY == 2 || difY == -2 || difX == -2 || difX == 2){
            if(difX > 0 && difY > 0){
                tX += 1;
                tY += 1;
            }
            else if(difX > 0 && difY < 0){
                tX += 1;
                tY -= 1;
            }
            else if(difX < 0 && difY < 0){
                tX -= 1;
                tY -= 1;
            }
            else{
                tX -= 1;
                tY += 1;
            }
        }
    }

    public void moveHead(){
        if(direction == 'D'){hY -= 1;}
        else if(direction == 'L'){hX -= 1;}
        else if(direction == 'U'){hY += 1;}
        else{hX += 1;}
    }

    public void getNextLine(){
        String currentLine = tgb.nextLine();
        direction = currentLine.charAt(0);
        steps = Integer.parseInt(currentLine.substring(2));
    }

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
